package comment;

import java.time.LocalDateTime;

public class CommentDTO {
	private int id;
	private int boardId;
	private String content;
	private String writer;
	private LocalDateTime registerDate;
	private LocalDateTime modifiedDate;
	public CommentDTO() {
	}
	public CommentDTO(String content, String writer) {
		this.content = content;
		this.writer = writer;
	}
	public CommentDTO(int boardId, String content, String writer) {
		this.boardId = boardId;
		this.content = content;
		this.writer = writer;
	}
	public CommentDTO(int id, int boardId, String content, String writer, LocalDateTime registerDate,
			LocalDateTime modifiedDate) {
		this.id = id;
		this.boardId = boardId;
		this.content = content;
		this.writer = writer;
		this.registerDate = registerDate;
		this.modifiedDate = modifiedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		return "CommentDTO [id=" + id + ", boardId=" + boardId + ", content=" + content + ", writer=" + writer
				+ ", registerDate=" + registerDate + ", modifiedDate=" + modifiedDate + "]";
	}
}
