package com.springlec.base0701.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.base0701.dto.BDto;
import com.springlec.base0701.util.Constant;

public class BDao {

	JdbcTemplate template;
//	DataSource dataSource;
	
	public BDao() {
		this.template = Constant.template;
	}
	
	public ArrayList<BDto> list(){
		
//		ArrayList<BDto> dtos = null;
		String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));

//		dtos = (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
//		return dtos;
		
		
		
//		ArrayList<BDto> dtos = new ArrayList<BDto>();
//		Connection connection =null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
//			preparedStatement = connection.prepareStatement(query);
//			resultSet = preparedStatement.executeQuery();
//			
//			while (resultSet.next()) {
//				int bId = resultSet.getInt("bId");
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				
//				BDto dto = new BDto( bId, bName, bTitle, bContent, bDate);
//				dtos.add(dto);
//			}
//			
//			
// 		} catch (Exception e) {
//			e.printStackTrace();
// 		} finally {
// 			try {
//				if(resultSet != null) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
// 		}
//		
//		return dtos;
		
	}

	public void write(final String bName, final String bTitle, final String bContent) {
		// TODO Auto-generated method stub
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "Insert into mvc_board(bName, bTitle, bContent, bDate) values(?,?,?, now())";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				return pstmt;
			}
		});
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "Insert into mvc_board(bName, bTitle, bContent, bDate) values(?,?,?, now())";
//			
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, bName);
//			preparedStatement.setString(2, bTitle);
//			preparedStatement.setString(3, bContent);
//			
//			preparedStatement.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		
		
	}
//	
	
	public BDto content(int strID) {
		String query = "select * from mvc_board where bId = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void update(final int bId, final String bName, final String bTitle, final String bContent) {
		String query = "update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
		
		this.template.update(query, new PreparedStatementSetter() {
		
			@Override
			public void setValues(PreparedStatement ps)throws SQLException{
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, bId);
			}
		});
	}
	
	public void delete(final int bId) {
		String query = "delete from mvc_board where bId=?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, bId);
			}
		});
	}
	
//		BDto dto = null;
//		Connection connection =null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "select bId, bName, bTitle, bContent, bDate from mvc_board where bId=?";
//			
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, bId);
//			resultSet = preparedStatement.executeQuery();
//			
//			while (resultSet.next()) {
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				
//				dto = new BDto( bId, bName, bTitle, bContent, bDate);
//			}
//			
//			
// 		} catch (Exception e) {
//			e.printStackTrace();
// 		} finally {
// 			try {
//				if(resultSet != null) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
// 		}
//		
//		return dto;
//		
	}

//
//	public void update(int bId, String bName, String bTitle, String bContent) {
//		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
//			
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, bName);
//			preparedStatement.setString(2, bTitle);
//			preparedStatement.setString(3, bContent);
//			preparedStatement.setInt(4, bId);
//			
//			preparedStatement.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//	}
	
//	public void delete(int bId) {
//		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "delete from mvc_board where bId=?";
//			
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, bId);
//			
//			preparedStatement.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		
//		
//	}	
	
	
	
	
