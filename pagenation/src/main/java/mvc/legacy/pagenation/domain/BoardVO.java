package mvc.legacy.pagenation.domain;

import java.util.Date;

public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int viewCnt;
	
	public String getTitle() {return title;}
	public String getContent() {return content;}
	public String getWriter() {return writer;}
	public Date getRegDate() {return regDate;}
	public int getViewCnt() {return viewCnt;}
	public int getBno() {return bno;}
	
	public void setBno(int bno) {this.bno = bno;}	
	public void setTitle(String title) {this.title = title;}
	public void setContent(String content) {this.content = content;}
	public void setWriter(String writer) {this.writer = writer;}
	public void setRegDate(Date regDate) {this.regDate = regDate;}
	public void setViewCnt(int viewCnt) {this.viewCnt = viewCnt;}
	
	
/*
bno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(50) NOT NULL,
content TEXT NOT NULL,
writer VARCHAR(30) NOT NULL,
regDate TIMESTAMP DEFAULT NOW(),
viewCnt INT DEFAULT 0
*/	
	

}
