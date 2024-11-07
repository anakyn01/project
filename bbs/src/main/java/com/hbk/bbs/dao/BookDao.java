package com.hbk.bbs.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("book.insert", map);
	}
	//read
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return this.sqlSessionTemplate.selectOne("book.select_detail", map);
	}
	
	//update
	public int update(Map<String, Object> map){
		return this.sqlSessionTemplate.update("book.update", map);
	}
	//삭제 기능
	public int delete(Map<String, Object> map) {
		return this.sqlSessionTemplate.delete("book.delete", map);
	}
	
	//목록 첫번째 파라미터 쿼리 ID, 두번째 ID는 쿼리 파라미터
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return this.sqlSessionTemplate.selectList("book.select_list", map);
		//sqlSessionTemplate.selectList는 Map<String, Object>를 List타입으로 읽을수 있다
	}
	
	
	
	
	
	
	
}

