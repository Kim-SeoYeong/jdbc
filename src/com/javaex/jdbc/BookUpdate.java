package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookUpdate {

	public static void main(String[] args) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			/*
			update book
			set pubs = '김서영'
			where book_id = 10
			and title = '책 테스트';
			*/
			
			String query = "";
			query += " update book ";
			query += " set pubs = ? ";
			query += " where book_id = ? ";
			query += " and title = ?";
			
			//쿼리문 확인
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, "김서영");
			pstmt.setInt(2, 10);
			pstmt.setString(3, "책 테스트");
			
		    int count = pstmt.executeUpdate();
		    
		    // 4.결과처리
		    System.out.println(count + "건이 처리되었습니다.");

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}

	}

}
