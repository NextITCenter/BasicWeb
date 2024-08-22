package comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/comment/rem")
public class CommentRemoveServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId = req.getParameter("id");
		int id = paramId == null || paramId.isEmpty() ? 0 : Integer.parseInt(paramId);
		// 해당 데이터 삭제
		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");
		CommentService service = CommentService.getInstance(session);
		int removeComment = service.removeComment(id);
		
		// 응답을 json으로 한다.
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String json;
		if (removeComment > 0) {
			json = "{\"result\":\"success\"}";// 성공시
		} else {
			json = "{\"result\":\"failure\"}";// 실패시
		}
		out.println(json);
	}
}
