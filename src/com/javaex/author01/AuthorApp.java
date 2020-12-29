package com.javaex.author01;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		List<AuthorVO> authorList = authorDao.getAuthorList();
		
		//int count = authorDao.AuthorInsert("테스트", "경북 영양"); //작가테이블에 추가
		//System.out.println(count + "건 등록되었습니다.");
		
		
		//등록(insert)
		AuthorVO authorVo1 = new AuthorVO("이문열", "경북 영양");
		authorDao.AuthorInsert(authorVo1);
		
		AuthorVO authorVo2 = new AuthorVO("박경리", "경상남도 통영");
		authorDao.AuthorInsert(authorVo2);
		
		AuthorVO authorVo3 = new AuthorVO("유시민", "17대 국회의원");
		authorDao.AuthorInsert(authorVo3);
		/*
		authorDao.AuthorInsert("이문열", "경북 영양"); //작가테이블에 추가
		authorDao.AuthorInsert("박경리", "경상남도 통영"); //작가테이블에 추가
		authorDao.AuthorInsert("유시민", "17대 국회의원"); //작가테이블에 추가
		*/
		
		//리스트(select)
		authorList = authorDao.getAuthorList();
		
		//for() 이용해서 리스트 전체 출력
		System.out.println("=============작가리스트=============");
		for(int i = 0; i < authorList.size(); i++) {
			AuthorVO vo = authorList.get(i);
			System.out.println(vo.getAuthorId() + ", " + vo.getAuthorName()
								+ ", " + vo.getAuthorDesc());
		}
		
		//삭제(delete)
		authorDao.authorDelete(3);
		
		//리스트 출력
		authorList = authorDao.getAuthorList();
		//for() 이용해서 리스트 출력
		
		System.out.println("=============작가리스트=============");
		for(int i = 0; i < authorList.size(); i++) {
			AuthorVO vo = authorList.get(i);
			System.out.println(vo.getAuthorId() + ", " + vo.getAuthorName()
								+ ", " + vo.getAuthorDesc());
		}
	
		//수정(update)
		AuthorVO authorVo4 = new AuthorVO(2, "김경리", "제주도");
		authorDao.authorUpdate(authorVo4);

		//리스트(select)
		authorList = authorDao.getAuthorList();
				
		//for() 이용해서 리스트 전체 출력
		System.out.println("=============작가리스트=============");
		for(int i = 0; i < authorList.size(); i++) {
			AuthorVO vo = authorList.get(i);
			System.out.println(vo.getAuthorId() + ", " + vo.getAuthorName()
								+ ", " + vo.getAuthorDesc());
		}
	}

}
