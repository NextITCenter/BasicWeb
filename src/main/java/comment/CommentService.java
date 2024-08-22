package comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class CommentService {
	private static CommentService instance = new CommentService();
	private static CommentMapper mapper;
	private CommentService() {
	}
	public static CommentService getInstance(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(CommentMapper.class);
		return instance;
	}
	
	public List<CommentDTO> selectComments(int boardId) {
		return mapper.selectComments(boardId);
	}
	// 댓글 한개 가져오기(댓글 등록시 사용할 예정)
	public CommentDTO selectComment(int id) {
		return mapper.selectComment(id);
	}
	// 댓글 등록하기
	public CommentDTO registerComment(CommentDTO comment) {
		mapper.registerComment(comment);
		return mapper.selectComment(comment.getId());
	}
	// 댓글 수정하기
	public int modifyComment(CommentDTO comment) {
		return mapper.modifyComment(comment);
	}
	// 댓글 삭제
	public int removeComment(int id) {
		return mapper.removeComment(id);
	}
}
