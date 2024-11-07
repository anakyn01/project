package com.hbk.bbs.service;

import java.util.List;
import java.util.Map;

public interface BookService {

	String create(Map<String, Object> map);//create 시그니처

	Map<String, Object> detail(Map<String, Object> map);//read 시그니처

	boolean edit(Map<String, Object> map);//edit 시그니처

	boolean remove(Map<String, Object> map);//delete 시그니처

	List<Map<String, Object>> list(Map<String, Object> map);//목록 시그니처

}
