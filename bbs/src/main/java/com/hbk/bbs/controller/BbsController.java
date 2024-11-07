package com.hbk.bbs.controller;
/*web
client | server
spring(model(�ڹ�) controller(�����ϴ�) view(ȭ��))
model(dao(sql���ø� ������)), service(������,�������̽�[���� ����Ͻ� ����]) sql(mybatis) db(mysql) 
dao(slq���ø� autowired), impl(dao�� autowired), interface(�ñ״�ó)
controller(interface�� �ҷ��ͼ� view �ѷ��ش�)
*/

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hbk.bbs.service.BookService;

//������Ʈ�� �����ڷ� �Ӹ�
/*�������� �������� ��û(request)�� �޾Ƶ��̴� ��Ʈ�ѷ��� �����ؼ� �ڹ� ��
(java bean)���� ����ؼ� �����Ѵ�
�ڹٺ�
��к��� �����ڸ� Java Bean�� Ư�� ������ Ŭ������ ����Ű�� ������ ���ȴ�.
DTO Ȥ�� VO�� ���°� Java Bean�̶�� �����ϸ� ����.
�ʵ�� private�� �����Ǿ� getter�� setter�� ���ؼ��� ������ �� �ְ�,
���� ���ڰ� ���� �����ڸ� ������ ������ Ŭ�����̴�.

getter / setter
public�� no-argument ������
��� �ʵ�� private�� getter�� setter�� ���ؼ��� ���� ����

Spring������ Bean�� ������ IoC�����̳ʰ� �����ϴ� Java ��ü�� ���Ѵ�.
�Ϲ� Java ��ü�� �ٸ� ���� ����. �׳� ������ IoC�����̳ʿ��� �����Ǵ� ��ü�� Bean�̶�� �θ��� ���̴�.
������ IoC�� �����ϴ� ��ü������ �������� ���� �����ǰ�, ������ ����Ŭ�� �����ϰ�, ������ ������ �Ͼ�� ��ü���� ���Ѵ�.
��, �����ڰ� �����ϴ� ��ü�� �ƴ� ���������� ������� �ѱ� ��ü�� ���������� Bean�̶�� �θ���.
*/

@Controller
public class BbsController {
	
	@Autowired//�޼ҵ� �ñ״�ó ȣ���� ���ؼ� 
	BookService bookService;
	
	
	//Ȩ���� �����(url) ����
	@GetMapping(value="/")
	public String home() {
		return "home";
	}
	//create page ����
	/*ModelAndView ��Ʈ�ѷ��� ��ȯ�� �����͸� ����ϴ� ��(model) and 
	 * ȭ���� ����ϴ� ��(view)�� ��θ� ���ĳ��� ��ü
ModelAndView�� �����ڿ� ���ڿ�Ÿ�� (String type)�Ķ���Ͱ� �ԷµǸ� ���� ��ζ�� �����Ѵ�
*/
	//@RequestMapping(value="/create", method=RequestMethod.GET)
	@GetMapping(value="/create")//����� ����
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}
	
	//@RequestMapping(value="/create", method=RequestMethod.POST)
	@PostMapping(value="/create")
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
	
	ModelAndView mav = new ModelAndView();//��ü ����
	
	String bookId = this.bookService.create(map);
	
	if(bookId == null) {//�������� ������
		mav.setViewName("redirect:/create");//�ٽ� ����
	}else {
		mav.setViewName("redirect:/detail?bookId=" + bookId);
		//�������� �׼������� ������url�� ������ �Կ��� ����
	}	
		return mav;//��Ȳ�� �°� ���� mav
		
	}
	
	//read
	@GetMapping(value="/detail")
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.bookService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		
		String bookId = map.get("bookId").toString();
		mav.addObject("bookId", bookId);
		mav.setViewName("/book/detail");
		return mav;
	}
	//수정 1)
	@GetMapping(value="/update")//가영이 때문
	public ModelAndView update(@RequestParam Map<String, Object>map) {
		Map <String, Object> detailMap = this.bookService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",detailMap);
		mav.setViewName("/book/update");
		return mav;
	}
	//수정 2)
	@PostMapping("/update")
	public ModelAndView updatePost(@RequestParam Map<String, Object>map) {
		ModelAndView mav = new ModelAndView();
		
		boolean isUpdateSuccess = this.bookService.edit(map);
		if(isUpdateSuccess) {
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId="+bookId);
		}else {
		mav = this.update(map);
		}
		return mav;
	}
	
	//삭제기능
	@PostMapping("/delete")
	public ModelAndView deletePost(@RequestParam Map<String, Object>map) {
		ModelAndView mav = new ModelAndView();
		
		boolean isDeleteSuccess = this.bookService.remove(map);//삭제가 성공했는지 확인한다
		if(isDeleteSuccess) {//삭제하면 해당글이 사라지기 때문에 리스트로 이동한다
			mav.setViewName("redirect:/list");//목록으로 리다이렉트 한다
		}else {//삭제가 실패할경우 뒤로 돌린다
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId="+bookId);
		}
		return mav;//상황에 맞게 둘중에 하나를 실행한다
	}
	
	//list
	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		List<Map<String, Object>> list = this.bookService.list(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list);//데이터를 뷰에 전달할 수 있게 mav 객체에 넣는다.
		//검색
		if(map.containsKey("keyword")) {//파라미터가 있다면 뷰에 키워드를 전달한다
			mav.addObject("keyword", map.get("keyword"));
		}
		
		mav.setViewName("/book/list");///book/list 뷰를 리턴한다.
		return mav;
	}
	
	//스프링레퍼런스
	@GetMapping("/ref/maven")
	public String maven() {
		return "/ref/maven";
	}
	
	
	
	
	
	
	
	

}
