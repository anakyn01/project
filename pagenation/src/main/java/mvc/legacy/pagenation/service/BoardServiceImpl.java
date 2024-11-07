package mvc.legacy.pagenation.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mvc.legacy.pagenation.dao.BoardDAO;
import mvc.legacy.pagenation.domain.BoardVO;

@Service //비즈니스 로직에 대한 정보를 담고 있다
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;

	@Override
	public List<BoardVO> list() throws Exception {
		return dao.list();
	}

	@Override//게시물 작성
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
	}

	@Override//게시물 조회
	public BoardVO view(int bno) throws Exception {
		return dao.view(bno);
	}

	@Override//게시물 수정
	public void modify(BoardVO vo) throws Exception {
		dao.modify(vo);	
	}

	@Override//게시물 삭제
	public void delete(int bno) throws Exception {
		dao.delete(bno);		
	}

	@Override//게시물 총갯수
	public int count() throws Exception {
		return dao.count();
	}

	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
		return dao.listPage(displayPost, postNum);
	}

	@Override
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
		return dao.listPageSearch(displayPost, postNum, searchType, keyword);
	}

	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchCount(searchType, keyword);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
