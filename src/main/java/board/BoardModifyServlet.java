package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boards/modify")
public class BoardModifyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId = req.getParameter("id");
		int id = (paramId == null || paramId.isEmpty()) ? 0 : Integer.parseInt(paramId);
		BoardService service = BoardService.getInstance();
		BoardDTO board = service.selectBoard(id);
		req.setAttribute("board", board);
		req.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수정, 삭제시 필요
		String paramId = req.getParameter("id");
		int id = (paramId == null || paramId.isEmpty()) ? 0 : Integer.parseInt(paramId);
		// 수정, 등록시 필요
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardDTO board = new BoardDTO(id, title, content, writer);
		BoardService service = BoardService.getInstance();
		int modifyBoard = service.modifyBoard(board);
		if (modifyBoard > 0) {
			resp.sendRedirect("/boards");
		} else {
			req.setAttribute("msg", "게시글 수정 실패!");
			req.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(req, resp);
		}
	}
}



