package com.md.shop.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.md.shop.domain.CategoryVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "com.md.shop.mappers.adminMapper";

	@Override//카테고리
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}

}
