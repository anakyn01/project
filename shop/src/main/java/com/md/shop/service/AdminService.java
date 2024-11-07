package com.md.shop.service;

import java.util.List;

import com.md.shop.domain.CategoryVO;

public interface AdminService {

	public List<CategoryVO> category() throws Exception;
}
