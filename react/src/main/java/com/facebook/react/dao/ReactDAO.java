package com.facebook.react.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReactDAO {
	@Autowired	
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map <String, Object> map) {
		int result = this.sqlSessionTemplate.insert("TB_BLG_CONT.insert", map);
		if(result > 0 && map.containsKey("seq_blg_cont")) {
			return (int) map.get("seq_blg_cont");
		}
		return -1;
	}
}
