package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelectALL {

	public static void main(String[] args) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			/*
			select  book.book_id,
			        book.title,
			        book.pubs,
			        book.pub_date,
			        author.author_id,
			        author.author_name,
			        author.author_desc
			from book, author
			where book.author_id = author.author_id;
			*/
			String query = "";
			query += " select  book.book_id,      ";
			query += "         book.title,        ";
			query += "         book.pubs,         ";
			query += "         book.pub_date,     ";
			query += "         author.author_id,  ";
			query += "         author.author_name,";
			query += "         author.author_desc ";
			query += " from book, author          ";
			query += " where book.author_id = author.author_id";
			
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
		    
		    // 4.결과처리
			while (rs.next()) {
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pub_date = rs.getString("pub_date");
				int author_id = rs.getInt("author_id");
				String author_name = rs.getString("author_name");
				String author_desc = rs.getString("author_desc");
				
				System.out.println(book_id + ", " + title + ", " + pubs + ", " + 
								   pub_date + ", " + author_id + ", " + author_name + ", " +
								   author_desc);
			}

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (rs != null) {
		            rs.close();
		        }                
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
