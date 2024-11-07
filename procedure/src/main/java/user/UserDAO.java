package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	private Connection conn;//자바와 데이터 베이스 [연결]
	private PreparedStatement pstmt;//퀴리문 대기 및 [설정 및 실행]
	private ResultSet rs;//[결과값] 받아오기
	
	//기본 생성자
	public UserDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbID = "TEST_USER";
			String dbPassword = "1234";
			Class.forName("oracle.jdbc.OracleDriver");
			//ojdbc연결 클래스를 String타입으로 불러옵니다
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//로그인 구현영역 성공실패를 뭘로 구분하냐면 숫자로 구분 
	//로그인 성공(1) 패스워드틀림(0), 아이디 없음(-1), -2(오류)
	public int login(String userID, String userPassword) {
		String sql = "select userPassword from usr where userID = ?";
		//실제로 db에서 입력할 쿼리문을 'sql'변수에 미리 담아둡니다
		//선택된 유저아이디에 패스워드를 선택
		try {
			pstmt = conn.prepareStatement(sql); //sql쿼리문을 대기
			pstmt.setString(1, userID);// 첫번째 '?'에 매개변수로 받아온 'userID'를 대입
			rs=pstmt.executeQuery();//쿼리 실행한 결과를 rs에 저장
			if(rs.next()) {//결과값이 존재한다면 해당 결과값을 얻을수 있다
				if(rs.getString(1).equals(userPassword)) {
					return 1;//로그인 성공
				}else
					return 0;//비밀번호 틀림
			}
			return -1; //아이디 없음
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2;//오류
	}
	
	//회원가입
	public int join(Usr user) {
		String sql = "insert into usr values(?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  user.getUserID());
			pstmt.setString(2,  user.getUserPassword());
			pstmt.setString(3,  user.getUserName());
			pstmt.setString(4,  user.getUserGender());
			pstmt.setString(5,  user.getUserEmail());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
	
	
}
