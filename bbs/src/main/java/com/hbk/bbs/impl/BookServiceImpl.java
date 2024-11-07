package com.hbk.bbs.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbk.bbs.dao.BookDao;
import com.hbk.bbs.service.BookService;

//���� Ŭ������ ����Ͻ� Ŭ������ ��ġ�ϴ°� ������ MVC�������� ���� Ŭ������ ��Ʈ�ѷ��� DAO�����ϴ� ��Ȱ�� �մϴ� 
@Service//���� Ŭ������ �Ӹ�
public class BookServiceImpl implements BookService{
	@Autowired//������ �����̳ʿ� ����� �󿡰� �������������� �ʿ��Ҷ� DI(������ ����)�����ִ� ������̼�
	BookDao bookDao;
	
	@Override//Ŭ���� ������ ���� �������̽����� ���ǵȰ��� ������
	public String create(Map<String, Object> map) {
		int affectRowCount = this.bookDao.insert(map);
		//������ ���� �� = �ϴٿ�.�μ�Ʈ(map)
		if(affectRowCount == 1) {//�Ѱ��� ���� �����Ѵٸ�
			return map.get("book_id").toString();
		}
		return null;
	}
	
	//read ���ʸ� ������� ���س��� ����
	@Override
	public Map<String, Object> detail(Map<String, Object> map){
		return this.bookDao.selectDetail(map);
	}
	
	//edit ������ �ʿ���� 1���� ���� ����� ������ �޾Ҵ��� �˻�
	@Override
	public boolean edit(Map<String, Object> map) {
		int affectRowCount = this.bookDao.update(map);
		return affectRowCount == 1;
	}
	
	//delete 수정과 동일하게 한개의 행이 제대로 영향받았는지 검사한다
	@Override
	public boolean remove(Map<String, Object>map) {
		int affectRowCount = this.bookDao.delete(map);
		return affectRowCount == 1;
	}
	
	//목록
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		return this.bookDao.selectList(map);
	}
	
	
	
	
	
	
	
	

}
