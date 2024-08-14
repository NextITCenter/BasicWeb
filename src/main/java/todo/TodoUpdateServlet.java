package todo;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo/update")
public class TodoUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String updateTNo = req.getParameter("tNo");
		int tNo = updateTNo == null || updateTNo.isEmpty() ? 0 : Integer.parseInt(updateTNo);
		
		TodoService service = TodoService.getInstance();
		TodoVO todo = service.selectTodo(tNo);
		
		req.setAttribute("todo", todo);
		req.getRequestDispatcher("/WEB-INF/views/todo/update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramTNo = req.getParameter("tNo");
		int tNo = paramTNo == null || paramTNo.isEmpty() ? 0 : Integer.parseInt(paramTNo);
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String paramDueDate = req.getParameter("dueDate");
		LocalDate dueDate = paramDueDate == null || paramDueDate.isEmpty()
				? null : LocalDate.parse(paramDueDate);
		TodoVO todo = new TodoVO(tNo, title, writer, false, dueDate);
		
		TodoService service = TodoService.getInstance();
		int updateTodo = service.updateTodo(todo);
		
		if (updateTodo > 0) {
			resp.sendRedirect("/todo/list");
		} else {
			req.setAttribute("msg", "할일 수정을 실패했습니다.");
			req.getRequestDispatcher("/WEB-INF/views/todo/update.jsp").forward(req, resp);
		}
	}
}







