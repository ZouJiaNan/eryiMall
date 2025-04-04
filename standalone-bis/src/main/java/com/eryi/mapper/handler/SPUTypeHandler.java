package com.eryi.mapper.handler;

import com.eryi.bean.bo.product.SPU;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(SPU.class)     // 声明处理的Java类型
@MappedJdbcTypes(JdbcType.VARCHAR) // 声明处理的JDBC类型
public class SPUTypeHandler extends BaseTypeHandler<SPU> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    // 序列化：Java对象 -> 数据库字段
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    SPU parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setString(i, objectMapper.writeValueAsString(parameter));
        } catch (JsonProcessingException e) {
            throw new SQLException("SPU序列化失败: " + e.getMessage(), e);
        }
    }

    // 反序列化：数据库字段 -> Java对象
    @Override
    public SPU getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parseJson(rs.getString(columnName));
    }

    @Override
    public SPU getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parseJson(rs.getString(columnIndex));
    }

    @Override
    public SPU getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parseJson(cs.getString(columnIndex));
    }

    private SPU parseJson(String json) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.readValue(json, SPU.class);
        } catch (IOException e) {
            throw new RuntimeException("SPU反序列化失败，JSON内容: " + json, e);
        }
    }
}
