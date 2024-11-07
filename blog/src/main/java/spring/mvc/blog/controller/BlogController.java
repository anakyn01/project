package spring.mvc.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.blog.service.BlogService;
import spring.mvc.blog.vo.BlogEditRequestVO;
import spring.mvc.blog.vo.BlogListRequestVO;
import spring.mvc.blog.vo.BlogListResponseVO;

@Controller
public class BlogController {
	//컨트롤러에 서비스 주입
	@Autowired
	BlogService blogService;

	@GetMapping("/")//라우팅 
	public String home() {
		return "home";
	}
	
	//create
	@GetMapping("/create")
	public String create() {
		return "blog/create";
	}
	//create 쓰기
	@PostMapping("/create")
	public String postCreate(@RequestParam Map<String, Object>map) {
		//@RequestParam 어노테이션을 통해 HTTP파라미터를 map변수에 자동으로 바인딩 합니다
		int blogContSeq = this.blogService.create(map);
		//주입된 서비스 객체의 메소드를 호출합니다
		//return "redirect:/read/" + String.valueOf(blogContSeq);
		return "redirect:/list";
		//성공하면 보기 페이지로 이동합니다
	}
	//read 메소드 작성하기
	@GetMapping("/read/{blogContSeq}")//라우팅 {blogContSeq}매개변수를 경로로 입력 받는다는 뜻입니다
	//@PathVariable가 같이 사용됩니다
	//@GetMapping 어노테이션은 스프링 버전4.3부터 가능합니다
	public String getRead(@PathVariable("blogContSeq")int blogContSeq, Model model) {
		Map<String, Object> blogCont = this.blogService.read(blogContSeq);
		//서비스의 메소드를 호출하여 데이터를 가져옵니다
		model.addAttribute("blogCont", blogCont);
		//모델에 뷰에 전달할 값을 설정 합니다
		return "blog/read";
	}
	/*
	Model model => 뷰에 데이터를 전달하는 객체입니다
	컨트롤러나 서비스에서 뭔가 처리를 하고 난후에 뷰를 통해 표시를 해줘야 하는 경우가 많습니다
	이때 뷰에 데이터를 전달하는 방법중에 하나가 모델을 사용하는 것입니다
	*/
	
	//edit라우팅
	@GetMapping("/edit/{blogContSeq}")//ModelAndView 모델과 뷰를 합쳐놓은 객체
	public ModelAndView getEdit(@PathVariable("blogContSeq")int blogContSeq) {
		ModelAndView mav = new ModelAndView("/blog/edit");
		//string 리턴하든 model을 사용하든 ModelAndView로 바꿔서 렌더링 합니다
		Map<String, Object> blogCont = this.blogService.read(blogContSeq);
		//수정 프로세스에 첫번째 기존에 글을 읽어 옵니다
		//유의사항
		if (blogCont == null) {//만약 blogcont가 없다면
			mav.setViewName("redirect:/list");
			return mav;
		}
		mav.addObject("blogCont", blogCont);
		//ModelAndView객체를 이용해 뷰에 데이터를 넘길때는 addObject메소드를 사용합니다
		return mav;
	}
	/*HTTP데이터의 수정은PUT메소드를 사용합니다
	다만 웹브라우저는 GET과 POST만 대부분 인식하므로 PUT메소드 처리를 할수 가 없습니다
	그래서 스프링은 이런 경우를 대비해서 HTTP메소드를 애율레이션 하는 기능이 있습니다
	web.xml에 httpmethodFilter추가
	*/
	@PutMapping("/edit/{blogContSeq}")
	public String putEdit(BlogEditRequestVO blogEditRequestVO) {
		boolean isSuccessEdit = this.blogService.edit(blogEditRequestVO);
		if(isSuccessEdit) {
			return "redirect:/edit/" + String.valueOf(blogEditRequestVO.getBlogContSeq());
		}
		return "redirect:/list";
	}
	//delete
	@DeleteMapping("/delete")
	public String delete(int blogContSeq) {
		this.blogService.delete(blogContSeq);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(BlogListRequestVO blogListRequestVO, Model model) {
		model.addAttribute("blogListRequestVO", blogListRequestVO);
		List<BlogListResponseVO> blogListResponseVOList = this.blogService.list(blogListRequestVO);
		model.addAttribute("blogListResponseVOList", blogListResponseVOList);		
		return "/blog/list";
	}
	
	
	
	
	

	
	
	
}
