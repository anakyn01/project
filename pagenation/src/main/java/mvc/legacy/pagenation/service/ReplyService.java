package mvc.legacy.pagenation.service;

import java.util.List;

import mvc.legacy.pagenation.domain.ReplyVO;

public interface ReplyService {

	//댓글조회
	public List<ReplyVO> list(int bno) throws Exception;
	//댓글쓰기
	public void write(ReplyVO vo) throws Exception;
	//댓글수정
	public void modify(ReplyVO vo) throws Exception;
	//댓글삭제
	public void delete(ReplyVO vo) throws Exception;
	//조회
	public ReplyVO replySelect(ReplyVO vo)throws Exception;
}
