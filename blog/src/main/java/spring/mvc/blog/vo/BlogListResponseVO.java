package spring.mvc.blog.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BlogListResponseVO {
	//맴버변수
	private int blgContSeq;
	private String title;
	private String contBdy;
	private LocalDateTime insertDt;
	
	//getter
	public int getBlgContSeq() {return blgContSeq;}
	public String getTitle() {return title;}
	public String getContBdy() {return contBdy;}
	public LocalDateTime getInsertDt() {return insertDt;}
	public String getInsertDtFormat() {//add
		return this.insertDt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	//setter
	public void setBlgContSeq(int blgContSeq) {this.blgContSeq = blgContSeq;}
	public void setTitle(String title) {this.title = title;}
	public void setContBdy(String contBdy) {this.contBdy = contBdy;}
	public void setInsertDt(LocalDateTime insertDt) {this.insertDt = insertDt;}

	
	

}
