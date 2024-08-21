package board;

import java.time.LocalDateTime;
import java.util.List;

import comment.CommentDTO;
import file.FileDTO;

public class BoardDTO {
	private int id;
	private String title;
	private String content;
	private String writer;
	private int hits;
	private LocalDateTime registerDate;
	private LocalDateTime modifiedDate;
	
	private List<FileDTO> fileList;
	private List<CommentDTO> commentList;
	
	public BoardDTO(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public BoardDTO(int id, String title, String content, String writer) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public BoardDTO(int id, String title, String content, String writer, int hits, LocalDateTime registerDate,
			LocalDateTime modifiedDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hits = hits;
		this.registerDate = registerDate;
		this.modifiedDate = modifiedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
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
	public List<FileDTO> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileDTO> fileList) {
		this.fileList = fileList;
	}
	public List<CommentDTO> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<CommentDTO> commentList) {
		this.commentList = commentList;
	}
	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer + ", hits="
				+ hits + ", registerDate=" + registerDate + ", modifiedDate=" + modifiedDate + ", fileList=" + fileList
				+ ", commentList=" + commentList + "]";
	}
}
