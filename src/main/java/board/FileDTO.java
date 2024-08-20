package board;

import java.time.LocalDateTime;

// FileVO
public class FileDTO {
	private int id;
	private int boardId;
	private String filePath;
	private String fileName;
	private String originalName;
	private long fileSize;
	private LocalDateTime registerDate;
	public FileDTO() {
	}
	public FileDTO(String filePath, String fileName, String originalName, long fileSize) {
		this.filePath = filePath;
		this.fileName = fileName;
		this.originalName = originalName;
		this.fileSize = fileSize;
	}
	public FileDTO(int id, int boardId, String filePath, String fileName, String originalName, long fileSize,
			LocalDateTime registerDate) {
		this.id = id;
		this.boardId = boardId;
		this.filePath = filePath;
		this.fileName = fileName;
		this.originalName = originalName;
		this.fileSize = fileSize;
		this.registerDate = registerDate;
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "FileDTO [id=" + id + ", boardId=" + boardId + ", filePath=" + filePath + ", fileName=" + fileName
				+ ", originalName=" + originalName + ", fileSize=" + fileSize + ", registerDate=" + registerDate + "]";
	}
	
}
