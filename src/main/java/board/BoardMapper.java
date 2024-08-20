package board;

import java.util.List;

import file.FileDTO;

public interface BoardMapper {
	List<BoardDTO> selectBoards();
	BoardDTO selectBoard(int id);
	int registerBoard(BoardDTO board);
	int modifyBoard(BoardDTO board);
	int removeBoard(int id);
	
	// 첨부파일 저장
	int insertFile(List<FileDTO> file);
}
