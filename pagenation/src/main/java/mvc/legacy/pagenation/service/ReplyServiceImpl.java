package mvc.legacy.pagenation.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mvc.legacy.pagenation.dao.ReplyDAO;
import mvc.legacy.pagenation.domain.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
@Inject
private ReplyDAO dao;
	
	//댓글조회
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		return dao.list(bno);
	}


	//댓글쓰기
	@Override
	public void write(ReplyVO vo) throws Exception {
		dao.write(vo);
	}

	//댓글수정
	@Override
	public void modify(ReplyVO vo) throws Exception {
		dao.modify(vo);	
	}

	//댓글삭제
	@Override
	public void delete(ReplyVO vo) throws Exception {
		dao.delete(vo);		
	}


	@Override
	public ReplyVO replySelect(ReplyVO vo) throws Exception {
		return dao.replySelect(vo);
	}

	

}
