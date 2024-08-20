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
		// 게시글을 등록한 뒤에 방금 등록된 게시글 번호를 가져와서
		// 첨부파일 내용을 등록할 때 함께 넣어줘야 한다.
		int boardId = board.getId();
		List<FileDTO> fileList = board.getFileList();
		for (FileDTO file : fileList) {
			file.setBoardId(boardId);
		}
		return mapper.insertFile(fileList);
	}
	int modifyBoard(BoardDTO board) {
		return mapper.modifyBoard(board);
	}
	int removeBoard(int id) {
		return mapper.removeBoard(id);
	}
	
}



