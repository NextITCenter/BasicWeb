package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boards/remove")
public class BoardRemoveServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId = req.getParameter("id");
		int id = (paramId == null || paramId.isEmpty()) ? 0 : Integer.parseInt(paramId);
		BoardService service = BoardService.getInstance();
		int removeBoard = service.removeBoard(id);
		if (removeBoard > 0) {
			resp.sendRedirect("/boards");
		} else {
			req.setAttribute("msg", "게시글 삭제 실패!");
			req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
		}
	}
	
}
