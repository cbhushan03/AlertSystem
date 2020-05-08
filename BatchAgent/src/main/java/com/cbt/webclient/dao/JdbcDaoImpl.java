package com.cbt.webclient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cbt.webclient.model.AlertMonitor;

@Component
public class JdbcDaoImpl {
	DataSource dataSource;
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public AlertMonitor getAlertDetail(int jobId){
		Connection conn = null;
		AlertMonitor alertMonitor = null;
		try{
		
		conn= dataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from alert_monitor where jobid = ?");
		ps.setInt(1, jobId);
		
		
		
		ResultSet rs = ps.executeQuery();
			while(rs.next()){
				alertMonitor = new AlertMonitor(jobId, 
						rs.getString("hostname"),
						rs.getString("srcpath"), 
						rs.getBoolean("checkflag"),
						rs.getString("descpath"), 
						rs.getString("fileextm"), 
						rs.getString("emailrecpt"), 
						rs.getDate("creation_date"),
						rs.getString("created_by"));
			}
			
		rs.close();
		ps.close();
		return alertMonitor;
		
		}catch (Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				conn.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return alertMonitor;
	}
	
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
