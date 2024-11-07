package mvc.legacy.pagenation.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mvc.legacy.pagenation.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "mvc.legacy.pagenation.mappers.reply";
	
	//댓글조회	
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		return sql.selectList(namespace + ".replyList", bno);
	}
	//댓글쓰기
	@Override
	public void write(ReplyVO vo) throws Exception {
		sql.insert(namespace + ".replyWrite", vo);		
	}
	//댓글수정
	@Override
	public void modify(ReplyVO vo) throws Exception {
		sql.update(namespace + ".replyModify", vo);	
	}
	//댓글삭제
	@Override
	public void delete(ReplyVO vo) throws Exception {
		sql.delete(namespace + ".replyDelete", vo);	
	}
	@Override
	public ReplyVO replySelect(ReplyVO vo) throws Exception {
		return sql.selectOne(namespace + ".replySelect", vo);
	}
}
