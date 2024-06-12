package com.bs.spring.common;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class StringArrayToStringType implements TypeHandler<String[]> {

	@Override
	public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
		//이 메소드는 저장하는애  
		
		
		if(parameter!=null) {
			ps.setString(i, String.join(",", parameter));
		}else {
			ps.setString(i, null);
		}

	}
	//밑에 세개 메소드는 가져오는 메소드
	@Override
	public String[] getResult(ResultSet rs, String columnName) throws SQLException {
		
		String result=rs.getString(columnName);
		return result==null?null:result.split(",");
		
	}

	@Override
	public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
		String result=rs.getString(columnIndex);
		return result==null?null:result.split(",");
		
	}

	@Override
	public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String result=cs.getString(columnIndex);
		return result==null?null:result.split(",");
	}

}
