package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.MySqlSession;

public class BoardService {
	private static BoardService instance = new BoardService();
	private static BoardMapper mapper;
	private BoardService() {
//		SqlSession session = MySqlSession.getSqlSession();
//		mapper = session.getMapper(BoardMapper.class);
	}
	public static BoardService getInstance(SqlSession session) {
		mapper = session.getMapper(BoardMapper.class);
		return instance;
	}
	List<BoardDTO> selectBoards() {
		return mapper.selectBoards();
	}
	BoardDTO selectBoard(int id) {
		return mapper.selectBoard(id);
	}
	int registerBoard(BoardDTO board) {
		mapper.registerBoard(board);
		return mapper.insertFile(board.getFileList());
	}
	int modifyBoard(BoardDTO board) {
		return mapper.modifyBoard(board);
	}
	int removeBoard(int id) {
		return mapper.removeBoard(id);
	}
	
}



