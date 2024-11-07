package com.md.shop.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.md.shop.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	//누락
	@Inject
	private SqlSession sql;
	
	//누락
	private static String namespace = "com.md.shop.mappers.memberMapper";

	@Override
	public void signup(MemberVO vo) throws Exception {
			sql.insert(namespace + ".signup", vo);
	}

	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return sql.selectOne(namespace+".signin", vo);
	}

}
