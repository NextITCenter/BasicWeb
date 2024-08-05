package chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<form action=\"/login\" method=\"post\">");
		out.print("	<div>");
		out.print("		<label>");
		out.print("			<input type=\"text\" placeholder=\"아이디\">");
		out.print("		</label>");
		out.print("	</div>");
		out.print("	<div>");
		out.print("		<label>");
		out.print("			<input type=\"password\" placeholder=\"패스워드\">");
		out.print("		</label>");
		out.print("	</div>");
		out.print("	<div>");
		out.print("		<button>로그인</button>");
		out.print("		<button type=\"button\">취소</button>");
		out.print("	</div>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

}














