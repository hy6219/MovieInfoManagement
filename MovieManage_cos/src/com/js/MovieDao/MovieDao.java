package com.js.MovieDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static util.DBManager.*;

import com.js.MovieDto.MovieDto;

public class MovieDao {
	
	private MovieDao() {
		
	}
	
	private static MovieDao dao = new MovieDao();
	Connection 		conn = null;
	PreparedStatement ps = null;
	Statement 		stat = null;
	ResultSet 		  rs = null;
	
	
	public static MovieDao getInstance() {
		return dao;
	}
	
	public List<MovieDto> selectAll(){
		List<MovieDto> list   = new ArrayList<>();
		String  selectAllQuery= "SELECT CODE, TITLE, PRICE, DIRECTOR, ACTOR, POSTER, SYNOPSIS FROM MOVIE";
		
		try {
			conn = getConnection();
			stat = conn.createStatement();
			
			rs   = stat.executeQuery(selectAllQuery);
			
			while(rs.next()) {
				MovieDto dto = new MovieDto();
				
				dto.setCode(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setDirector(rs.getString(4));
				dto.setActor(rs.getString(5));
				dto.setPoster(rs.getString(6));
				dto.setSynopsis(rs.getString(7));
				
				list.add(dto);
			}
			
		}catch(Exception e) {
			System.out.println("[ERR]SELECT ALL ERROR");
			e.printStackTrace();
		}finally {
			try {
				close(conn,stat,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//영화정보 찾기
	public MovieDto selectOne(int code) {
		MovieDto dto 	= new MovieDto();
		String pickQuery= "SELECT CODE,TITLE,PRICE,DIRECTOR,ACTOR,POSTER,SYNOPSIS FROM MOVIE WHERE CODE="+code;
		
		try {
			conn = getConnection();
			stat = conn.createStatement();
			rs   = stat.executeQuery(pickQuery);
			
			if(rs.next()) {
				dto.setCode(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setDirector(rs.getString(4));
				dto.setActor(rs.getString(5));
				dto.setPoster(rs.getString(6));
				dto.setSynopsis(rs.getString(7));
			}
			
		}catch(Exception e) {
			System.out.println("[ERR]select one error!");
			e.printStackTrace();
		}finally {
			try {
				close(conn,stat,rs);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return dto;
	}
	
	//영화 등록
	public int registerMovie(MovieDto dto) {
		int regIns	    = 0;
		String insQuery ="INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL,?,?,?,?,?,?)";
		
		try {
			
			conn    = getConnection();
			ps      = conn.prepareStatement(insQuery);
			
			ps.setString(1, dto.getTitle());
			ps.setInt(2, dto.getPrice());
			ps.setString(3, dto.getDirector());
			ps.setString(4, dto.getActor());
			ps.setString(5, dto.getPoster());
			ps.setString(6, dto.getSynopsis());
			
			regIns  = ps.executeUpdate();
			
			if(regIns > 0) {
				System.out.println("영화 등록 성공");
				commit(conn);
			}else {
				System.out.println("영화 등록 실패");
				rollback(conn);
			}
			
		}catch(Exception e) {
			System.out.println("[ERR]REGISTER MOVIE FAILED");
			e.printStackTrace();
		}finally {
			try {
				close(conn,ps);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		return regIns;
	}
	
	//영화 정보 수정
	public int updateInfo(MovieDto dto) {
		int upRes	   = 0;
		String upQuery ="UPDATE MOVIE SET TITLE=?,PRICE=?,DIRECTOR=?,ACTOR=?,POSTER=?,SYNOPSIS=? WHERE CODE=?";
		
		try {
			
			conn = getConnection();
			ps   = conn.prepareStatement(upQuery);
			
			ps.setString(1, dto.getTitle());
			ps.setInt(2, dto.getPrice());
			ps.setString(3, dto.getDirector());
			ps.setString(4, dto.getActor());
			ps.setString(5, dto.getPoster());
			ps.setString(6, dto.getSynopsis());
			ps.setInt(7, dto.getCode());
			
			upRes = ps.executeUpdate();
			
			if(upRes > 0) {
				System.out.println("영화 정보 수정 성공");
				commit(conn);
			}else {
				System.out.println("영화 정보 수정 실패");
				rollback(conn);
			}
			
		}catch(Exception e) {
			System.out.println("[ERR]영화 정보 수정 실패");
			e.printStackTrace();
		}finally {
			try {
				close(conn,ps);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return upRes;
	}
	
	public int deleteMovie(int code) {
		int delRes 	   = 0 ;
		String delQuery="DELETE FROM MOVIE WHERE CODE="+code;
		
		try {
			
			conn = getConnection();
			stat = conn.createStatement();
			delRes = stat.executeUpdate(delQuery);
			
			if(delRes > 0) {
				System.out.println("영화 정보 삭제 성공");
				commit(conn);
			}else {
				System.out.println("영화 정보 삭제 실패");
				rollback(conn);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[ERR]delete movie failed");
		}finally {
			try {
				close(conn,stat);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return delRes;
	}
	
}
