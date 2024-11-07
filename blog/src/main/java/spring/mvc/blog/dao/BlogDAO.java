package spring.mvc.blog.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.blog.vo.BlogEditRequestVO;

@Repository //DB와 연동하여 사용자가 입력한 데이터나 사용자에게 출력할 데이터를 다룹니다 데이터엑세스 계층 데이터와의 상호 작용을 담당합니다
public class BlogDAO {
	
	@Autowired//객체 지향적으로 언제든 아래 컴포넌트를 재사용하게 설정
	SqlSessionTemplate sqlSessionTemplate;
	/*SQLSessionTemplate타입 맴버변수[특정 객체와 연결된 변수의 하나]선언
	맴버변수 위에 @Autowired 어노테이션을 붙이면 의존성을 주입하라는 얘기 입니다 
	스프링이 미리 만들어 놓은 SqlSessionTemplate 타입객체를 BlogDAO객체에 주입합니다
	이과정은 자동으로 생성되며 개발자가 직적 
	*/
	//insert 매서드
	public int insert(Map<String, Object> map) {
		//의존성 주입으로 생성된 sqlSessionTemplate 객체를 이용해서 매퍼를 실행 {매퍼의 패키지}.{매퍼id}
		int result = this.sqlSessionTemplate.insert("TB_BLG_CONT.insert", map);//영향 받은 행에 수
		//그래서 변수에는 1(입력 성공) 혹은 0(입력실패) 둘중 하나를 남깁니다
		if (result > 0 && map.containsKey("seq_blg_cont")) {
			//따라서 성공적으로 입력이 되었다고 확신하려면 영향받은 행수가 1이상 이어야하고 seq_blg_cont키가 있어야 합니다
			return (int) map.get("seq_blg_cont");//입력에 성공 했다면  PK리턴
		}
		return -1;//실패라면 -1로 돌려서 실패임을 알립니다
	}
	public Map<String, Object> selectOne(int blogContSeq) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("TB_BLG_CONT.selectOne", blogContSeq);
	}
	//edit
	public int update(BlogEditRequestVO blogEditRequestVO) {
		return this.sqlSessionTemplate.update("TB_BLG_CONT.update", blogEditRequestVO);
	}
}
/*
Data Access Object => 데이터에 접근하는 객체
[매퍼 xml에서 작성한 쿼리를 실행시키기 위해서 작성한다 매퍼xml과 한쌍이다]

Data Transfer Object => 데이터를 transfer(이동)하기 위한 객체
- View Layer와 DB Layer의 역활을 분리하기 위해
- Entity객체의 변경을 피하기 위해서
- VIEW통신하는 DTO클래스는 자주 변경된다
- 도메인 모델링을 지키기 위해서
*/
