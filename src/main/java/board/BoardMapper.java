package board;

import java.util.List;

public interface BoardMapper {
	List<BoardDTO> selectBoards();
	BoardDTO selectBoard(int id);
	int registerBoard(BoardDTO board);
	int modifyBoard(BoardDTO board);
	int removeBoard(int id);
}
