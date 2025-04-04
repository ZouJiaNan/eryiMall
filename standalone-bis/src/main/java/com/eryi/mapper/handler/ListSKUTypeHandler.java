package com.eryi.mapper.handler;

import com.eryi.bean.bo.product.SKU;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import java.sql.*;
import java.util.Collections;
import java.util.List;

@MappedTypes(List.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class ListSKUTypeHandler extends BaseTypeHandler<List<SKU>> {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final TypeReference<List<SKU>> TYPE_REF = new TypeReference<List<SKU>>() {};

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    List<SKU> parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setString(i, OBJECT_MAPPER.writeValueAsString(parameter));
        } catch (JsonProcessingException e) {
            throw new SQLException("SKU列表序列化失败", e);
        }
    }

    @Override
    public List<SKU> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parseJson(rs.getString(columnName));
    }

    @Override
    public List<SKU> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parseJson(rs.getString(columnIndex));
    }

    @Override
    public List<SKU> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parseJson(cs.getString(columnIndex));
    }

    private List<SKU> parseJson(String json) {
        if (json == null || json.trim().isEmpty()) return Collections.emptyList();
        try {
            return OBJECT_MAPPER.readValue(json, TYPE_REF);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("SKU列表反序列化失败，JSON内容: " + json, e);
        }
    }
}
