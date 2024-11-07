package mvc.legacy.pagenation.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.legacy.pagenation.domain.ReplyVO;
import mvc.legacy.pagenation.service.ReplyService;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Inject
	private ReplyService replyService;
	
	//댓글 작성
	@PostMapping(value="/write")
	public String posttWrite(ReplyVO vo)throws Exception{
		replyService.write(vo);
		return "redirect:/board/view?bno="+vo.getBno();
	}	
	//댓글 수정	
	@GetMapping(value="/modify")
	public void getModify(@RequestParam("bno") int bno, @RequestParam("rno") int rno, Model model)throws Exception{
		ReplyVO vo = new ReplyVO();
		vo.setBno(bno);
		vo.setRno(rno);
		ReplyVO reply = replyService.replySelect(vo);
		model.addAttribute("reply", reply);
	}
	@PostMapping(value="/modify")
	public String postModify(ReplyVO vo)throws Exception{
		replyService.modify(vo);
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	
	
	
	
	
	
	
	
	
	
	//댓글 삭제
}
