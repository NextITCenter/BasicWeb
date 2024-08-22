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

@WebServlet("/comment/new")
public class CommentRegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// request의 getParameter() 메소드는 요청 헤더(Request Header)에
		// Content-Type이 application/x-www-form-urlencoded로 되어 있어야 처리 가능
		String paramBoardId = req.getParameter("boardId");
		int boardId = paramBoardId == null || paramBoardId.isEmpty() ? 0 : Integer.parseInt(paramBoardId);
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		System.out.println(boardId + " : " + content + " : " + writer);
		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");
		CommentService service = CommentService.getInstance(session);
		
		CommentDTO comment = new CommentDTO(boardId, content, writer);
		CommentDTO newComment = service.registerComment(comment);
		// 응답을 json 형식으로 해준다.
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		String json = """
			{
				"id":%d,
				"boardId":%d,
				"content":"%s",
				"writer":"%s",
				"registerDate":"%s",
				"modifiedDate":"%s"
			}
			""".formatted(
					newComment.getId(), newComment.getBoardId(),
					newComment.getContent(), newComment.getWriter(),
					newComment.getRegisterDate(), newComment.getModifiedDate()
				);
		out.println(json);
	}
}
