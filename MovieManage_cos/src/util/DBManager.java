package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	
	
	public static Connection getConnection() throws NamingException, SQLException {
		
		Context initialContext = new InitialContext();
		Context 	envContext = (Context) initialContext.lookup("java:/comp/env");
		DataSource  		ds = (DataSource) envContext.lookup("jdbc/myoracle");
		Connection         conn= ds.getConnection();
		
		conn.setAutoCommit(false);
		
		return conn;
		/*
		 * https://www.tutorialspoint.com/can-we-access-the-instance-variables-from-a-static-method-in-java
		 * Connection 등 클래스 객체를 만들어 접근했기 때문에 클래스 인스턴스를 static 메서드 내부에서 사용 가능!!
		 * 
		 * */
	}
	
	public static void commit(Connection conn) throws SQLException {
		conn.commit();
	}
	
	public static void rollback(Connection conn) throws SQLException {
		conn.rollback();
	}
	
	public static void close(Connection conn, Statement stat, ResultSet rs) throws SQLException {
		rs.close();
		stat.close();
		conn.close();
	}
	
	public static void close(Connection conn, PreparedStatement stat, ResultSet rs) throws SQLException {
		rs.close();
		stat.close();
		conn.close();
	}
	
	public static void close(Connection conn, Statement stat) throws SQLException {
		stat.close();
		conn.close();
	}
	
	public static void close(Connection conn, PreparedStatement stat) throws SQLException {
		stat.close();
		conn.close();
	}
	
}
