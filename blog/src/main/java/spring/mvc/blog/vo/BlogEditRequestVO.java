package spring.mvc.blog.vo;
/*
지금까지 값을 전달하는 방법으로  Map을 사용함
광장히 유연하여 변경에 강하다는 장점이 있습니다
안에 무슨 값이 있는지 실행하기 전까지는 아무도 모른다는 단점이 있습니다

반면 VO(Value Object)는 값의 이름과 타입을 미리정의하려 사용하는 방법입니다
내용물을 파악할수 있는 장점 더 코드를 많이 쓰는 불편함

프로젝트를 진행하다가 원리원칙을 중시하는 AA, PM을 만나면 반드시 VO를 사용하라고 합니다
VO => DTO(DATA Transfer Object)라고 도 불린다
둘다 완전히 동일한 개념은 아니지만 데이터 컨테이너 역활을 한다는 점은 같습니다
현장에서는 VO또는 DTO라고도 합니다
*/
public class BlogEditRequestVO {

	private int blogContSeq;
	private String title;
	private String contBdy;
	
	public int getBlogContSeq() {return blogContSeq;}
	public String getTitle() {return title;}
	public String getContBdy() {return contBdy;}
	
	public void setBlogContSeq(int blogContSeq) {this.blogContSeq = blogContSeq;}
	public void setTitle(String title) {this.title = title;}
	public void setContBdy(String contBdy) {this.contBdy = contBdy;}
	
	
}
