package procedure;

import lombok.Data;

@Data//생성자,게터,세터,해시코드,이퀄,투스트링 자동생성
public class User {

	private String userId;
	private String userName;
	private String userPassword;
	private int userAge;
	private String userEmail;
}
