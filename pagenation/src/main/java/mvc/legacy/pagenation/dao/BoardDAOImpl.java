package mvc.legacy.pagenation.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mvc.legacy.pagenation.domain.BoardVO;

@Repository //db에 접근하는 객체
public class BoardDAOImpl implements BoardDAO {
	@Inject //컴포넌트로 만들어 제활용 싱글톤
	private SqlSession sql;
	
	private static String namespace = "mvc.legacy.pagenation.mappers.board";//xml에서 id를 불러오기 위해서
	
	@Override
	public List<BoardVO> list() throws Exception {
		return sql.selectList(namespace + ".list");
	}

	@Override
	public void write(BoardVO vo) throws Exception {
		sql.insert(namespace + ".write", vo);		
	}

	@Override//게시물 조회
	public BoardVO view(int bno) throws Exception {
		return sql.selectOne(namespace + ".view", bno);
	}

	@Override//게시물 수정
	public void modify(BoardVO vo) throws Exception {
	    sql.update(namespace + ".modify", vo);
		
	}

	@Override//게시물 삭제
	public void delete(int bno) throws Exception {
		sql.delete(namespace + ".delete", bno);
	}

	@Override//게시물 총갯수
	public int count() throws Exception {
		return sql.selectOne(namespace + ".count");
	}

	@Override//게시물 목록 + 페이징
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return sql.selectList(namespace + ".listPage", data);
	}

	@Override
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {

		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return sql.selectList(namespace+".listPageSearch", data);
	}

	@Override
	public int searchCount(String searchType, String keyword) throws Exception {

		HashMap data = new HashMap();
		
		data.put("searchType", searchType);
		data.put("keyword", keyword);

		return sql.selectOne(namespace + ".searchCount", data);
	}

	
}
/*
싱글톤(Singleton)
특정 클래스의 인스턴스를 1개만 생성되는것을 보장하는 디자인패턴
생성자를 통해서 여러 번 호출이 되더라도 인스턴스를 새로 생성하지 않고 
최초 호출시에 만들어 두었던 인스턴스 재활용하는 패턴

1초에 10번 똑같은 요청을 보내면 요청을 처리하기 위한 똑같은 객체를 1초에 10번 생성하고 소멸하는
메모리 낭비 문제가 발생합니다

그래서 싱글톤 패턴을 사용하면 객체한번 생성후 여러번 재사용하기에 메모리 낭비를 방지 할수 있다

싱글톤 단점
- 의존성이 높아진다(높은 결합[클래스 사이에 의존성])
- private생성자 때문에 상속이 어렵다 => 상속을 통한 자식 클래스로 만들수 없다
- 테스트하기가 힘들다 
싱글톤 패턴의 인스턴스는 자원을 공유하고 있다는 특징을 가집니다
서로 독립적이어야 하는 단위 테스트에 문제가 발생합니다

그래서 안티패턴이라고 얘기 합니다
*/
/*
@Resource : 필드명 또는 생성자 마파미터 변수의 이름과  Bean객체의 ID를 매핑시켜서 먼저 찾는 방식
name="ID"로 ID를 강제 지정할수 있습니다
@Resource(name="SqlSessionFactory")

@Inject : 타입이 같은 빈을 먼저 찾습니다
@Inject
@Named("SqlSessionFactory")

@Autowired : 스프링에서 제공해 주는 어노테이션 입니다
@Autowired 
@Qualifier("SqlSessionFactory")
*/