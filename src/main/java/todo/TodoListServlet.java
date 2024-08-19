package todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import common.MySqlSession;

@WebServlet("/todo/list")
public class TodoListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		SqlSession sqlSession = (SqlSession) context.getAttribute("sqlSession");
		TodoService service = TodoService.getInstance(sqlSession);
		List<TodoVO> todoList = service.selectTodoList();
		
		req.setAttribute("todoList", todoList);
		req.getRequestDispatcher("/WEB-INF/views/todo/list.jsp").forward(req, resp);
	}
}









