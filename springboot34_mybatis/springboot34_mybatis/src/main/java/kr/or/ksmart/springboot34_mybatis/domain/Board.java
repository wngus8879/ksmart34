package kr.or.ksmart.springboot34_mybatis.domain;

public class Board {
	
	private String boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardUser;
	private String boardDate;
	
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardUser() {
		return boardUser;
	}
	public void setBoardUser(String boardUser) {
		this.boardUser = boardUser;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardUser=" + boardUser + ", boardDate=" + boardDate + ", getBoardNo()=" + getBoardNo()
				+ ", getBoardTitle()=" + getBoardTitle() + ", getBoardContent()=" + getBoardContent()
				+ ", getBoardUser()=" + getBoardUser() + ", getBoardDate()=" + getBoardDate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
