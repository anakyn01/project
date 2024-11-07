package mvc.legacy.pagenation.dao;

import java.util.List;

import mvc.legacy.pagenation.domain.ReplyVO;

public interface ReplyDAO {

	//댓글조회
	public List<ReplyVO> list(int bno) throws Exception;
	//댓글쓰기
	public void write(ReplyVO vo) throws Exception;
	//댓글수정
	public void modify(ReplyVO vo) throws Exception;
	//댓글삭제
	public void delete(ReplyVO vo) throws Exception;
	//
	public ReplyVO replySelect(ReplyVO vo)throws Exception;
}
