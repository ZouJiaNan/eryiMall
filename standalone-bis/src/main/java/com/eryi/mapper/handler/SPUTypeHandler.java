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

@MappedTypes(SPU.class)     // ���������Java����
@MappedJdbcTypes(JdbcType.VARCHAR) // ���������JDBC����
public class SPUTypeHandler extends BaseTypeHandler<SPU> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    // ���л���Java���� -> ���ݿ��ֶ�
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    SPU parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setString(i, objectMapper.writeValueAsString(parameter));
        } catch (JsonProcessingException e) {
            throw new SQLException("SPU���л�ʧ��: " + e.getMessage(), e);
        }
    }

    // �����л������ݿ��ֶ� -> Java����
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
            throw new RuntimeException("SPU�����л�ʧ�ܣ�JSON����: " + json, e);
        }
    }
}
