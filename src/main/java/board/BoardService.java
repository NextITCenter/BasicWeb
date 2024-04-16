package board;

import java.util.List;

import javax.sql.DataSource;

public class BoardService {
	BoardDAO dao;
	public BoardService(DataSource dataSource) {
		this.dao = new BoardDAO(dataSource); 
	}
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}
	public BoardVO getBoard(int searchNo) {
		return dao.getBoard(searchNo);
	}
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
	}
	public void deleteBoard(int deleteNo) {
		dao.deleteBoard(deleteNo);
	}
}
