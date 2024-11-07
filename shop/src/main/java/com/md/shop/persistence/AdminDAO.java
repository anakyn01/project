package com.md.shop.persistence;

import java.util.List;

import com.md.shop.domain.CategoryVO;

public interface AdminDAO {

	//카테고리
	public List<CategoryVO> category() throws Exception;
}
