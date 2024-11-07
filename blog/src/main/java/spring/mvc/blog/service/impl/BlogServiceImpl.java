package spring.mvc.blog.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.blog.dao.BlogDAO;
import spring.mvc.blog.mapper.BlogMapper;
import spring.mvc.blog.service.BlogService;
import spring.mvc.blog.vo.BlogEditRequestVO;
import spring.mvc.blog.vo.BlogListRequestVO;
import spring.mvc.blog.vo.BlogListResponseVO;

@Service //빈을 등록하기 위해 @Service 어노테이션을 붙여 줍니다
public class BlogServiceImpl implements BlogService{
	private BlogDAO blogDAO;
	private BlogMapper blogMapper;
	
	@Autowired//선택한 빈을 재사용하기 위해 autowired설정
	public BlogServiceImpl(BlogDAO blogDAO, BlogMapper blogMapper) {
		this.blogDAO = blogDAO;
		this.blogMapper = blogMapper;
		//생성자의 매개변수를 클래스이 맴버변수에 바인딩 합니다
		//생성자가 하나만 있으면 생성자메소드위에 @Autowired 안붙여도 되지만 코드의 명확성을 위해 @Autowired어노테이션을 붙여 줍니다 
	}
	/*
	생성자를 통해 의존성을 주입하는것을 생성자 주입이라 고 합니다
	생성자의 매개변수로 빈으로 관리되는 클래스를 정의해 두면
	스프링이 빈 인스턴스를 생성하고 클래스를 생성할때 생성자의
	매개변수로 전달해 줍니다
	*/
	

	@Override
	public int create(Map<String, Object> map) {
		int seq = this.blogDAO.insert(map);
		return seq;
	}


	@Override //read 메서드 구현
	public Map<String, Object> read(int blogContSeq) {
		Map<String, Object> blogCont = this.blogDAO.selectOne(blogContSeq);
		return blogCont;
	}
	
	//edit
	@Override
	public boolean edit(BlogEditRequestVO blogEditRequestVO) {
		int affectRowsCount = this.blogDAO.update(blogEditRequestVO);
		return affectRowsCount > 0;
	}
	
	@Override//list
	public List<BlogListResponseVO> list(BlogListRequestVO blogListRequestVO){
		List<BlogListResponseVO> result = this.blogMapper.selectList(blogListRequestVO);
		return result;
	}


	@Override//delete
	public boolean delete(int blogContSeq) {
		return this.blogMapper.delete(blogContSeq) > 0;
		
	}
	
	
	
	
	
	
	



}
