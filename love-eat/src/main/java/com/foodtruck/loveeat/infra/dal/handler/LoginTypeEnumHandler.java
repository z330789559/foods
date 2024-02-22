package com.foodtruck.loveeat.infra.dal.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.foodtruck.loveeat.biz.enums.LoginTypeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * LoginTypeEnumHandler
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

@MappedTypes(LoginTypeEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class LoginTypeEnumHandler extends BaseTypeHandler<LoginTypeEnum> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, LoginTypeEnum parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getCode());
	}

	@Override
	public LoginTypeEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
             int code= rs.getInt(columnName);
	          return LoginTypeEnum.getEnum(code);
	}

	@Override
	public LoginTypeEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int code= rs.getInt(columnIndex);
		return LoginTypeEnum.getEnum(code);
	}

	@Override
	public LoginTypeEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	}
}
