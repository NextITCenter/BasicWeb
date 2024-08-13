package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boards/register")
public class BoardRegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수정, 등록시 필요
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardDTO board = new BoardDTO(title, content, writer);
		BoardService service = BoardService.getInstance();
		
		int modifyBoard = service.registerBoard(board);
		if (modifyBoard > 0) {
			resp.sendRedirect("/boards");
		} else {
			req.setAttribute("msg", "게시글 등록 실패!");
			req.getRequestDispatcher("/WEB-INF/views/board/register.jsp").forward(req, resp);
		}

	}
}