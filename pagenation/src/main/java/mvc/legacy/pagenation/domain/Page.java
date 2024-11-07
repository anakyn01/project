package mvc.legacy.pagenation.domain;

public class Page {

	//현재 페이지 번호
	private int num;
	
	//게시물 총갯수
	private int count;
	
	//한페이지에 출력할 게시물 갯수
	private int postNum = 10;
	
	//하단 페이징 번호([게시물 총갯수 / 한페이지의 출력할 갯수]의 올림)
	private int pageNum;
	
	//출력할 게시물
	private int displayPost;
	
	//한번에 표시할 페이징 번호의 갯수
	private int pageNumCnt = 10;
	
	//표시되는 페이지 번호 중 마지막 번호
	private int endPageNum;
		
	//표시되는 페이지 번호 중 첫번째 번호
	private int startPageNum;
	
	//다음 이전 표시 여부
	private boolean prev;
	private boolean next;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		dataCalc();
	}
	public void dataCalc() {
		//마지막 번호
		endPageNum = (int)(Math.ceil((double)num / (double)pageNumCnt) * pageNumCnt);
		
		//시작 번호
		startPageNum = endPageNum - (pageNumCnt - 1);
		
		//마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNumCnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		
		prev = startPageNum == 1 ? false : true;
		next = endPageNum * pageNumCnt >= count ? false : true;
		
		displayPost = (num - 1) * postNum;
	}
	
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getDisplayPost() {
		return displayPost;
	}
	public void setDisplayPost(int displayPost) {
		this.displayPost = displayPost;
	}
	public int getPageNumCnt() {
		return pageNumCnt;
	}
	public void setPageNumCnt(int pageNumCnt) {
		this.pageNumCnt = pageNumCnt;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	//검색 타입과 검색어
	public String getSearchTypeKeyword() {
		if(searchType.equals("") || keyword.equals("")) {
			return "";
		}else {
			return "&searchType=" + searchType + "&keyword=" + keyword;
		}
	}
	
	
	private String searchType;
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	
	
	
	
	
	
}
