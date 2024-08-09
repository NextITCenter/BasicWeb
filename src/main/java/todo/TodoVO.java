package todo;

import java.time.LocalDate;

public class TodoVO {
	private int tNo;
	private String title;
	private String writer;
	private boolean complete;
	private LocalDate dueDate;
	public TodoVO(String title, String writer) {
		this.title = title;
		this.writer = writer;
	}
	public TodoVO(int tNo, String title, String writer, boolean complete, LocalDate dueDate) {
		this.tNo = tNo;
		this.title = title;
		this.writer = writer;
		this.complete = complete;
		this.dueDate = dueDate;
	}
	public int gettNo() {
		return tNo;
	}
	public void settNo(int tNo) {
		this.tNo = tNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "TodoVO [tNo=" + tNo + ", title=" + title + ", writer=" + writer + ", complete=" + complete
				+ ", dueDate=" + dueDate + "]";
	}
}
