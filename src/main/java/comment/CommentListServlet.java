package comment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/comment/list")
public class CommentListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramBoardId = req.getParameter("boardId");
		int boardId = paramBoardId == null || paramBoardId.isEmpty() ? 0 : Integer.parseInt(paramBoardId);
		ServletContext context = req.getServletContext();
		SqlSession sqlSession = (SqlSession) context.getAttribute("sqlSession");
		CommentService service = CommentService.getInstance(sqlSession);
		List<CommentDTO> comments = service.selectComments(boardId);
		req.setAttribute("commentlist", comments);
	}
}
