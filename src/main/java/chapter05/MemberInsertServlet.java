package chapter05;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberInsertServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// view 페이지에서 form 태그의 name 속성이 request의 parameter란 이름으로 사용된다.
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		String memName = req.getParameter("memName");
		String memBir = req.getParameter("memBir");
		String memHp = req.getParameter("memHp");
		String memMail = req.getParameter("memMail");
		// 절대로 웹 개발할 때 System.out.println을 사용하면 안된다.
//		System.out.println("memId: " + memId);
		// 받은 데이터를 데이터베이스에 저장
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std225", "oracle21c");
			String sql = """
					insert into member
						(mem_id, mem_pass, mem_name, mem_bir, mem_hp, mem_mail)
					values
						(?, ?, ?, ?, ?, ?)
					""";
			PreparedStatement statement = connection.prepareStatement(sql);
			// ?에 데이터를 넣는 작업
			statement.setString(1, memId);
			statement.setString(2, memPass);
			statement.setString(3, memName);
			statement.setDate(4, Date.valueOf(memBir));
			statement.setString(5, memHp);
			statement.setString(6, memMail);
			// 쿼리 실행
			// select: executeQuery()
			// insert, update, delete: executeUpdate()
			// executeUpdate가 성공하면 성공한 row 수, 실패하면 0을 반환
			int executeUpdate = statement.executeUpdate();
			if (executeUpdate > 0) {
				// 성공시 목록 화면으로 리다이렉트
				resp.sendRedirect("/member/list");
			} else {
				// 실패
				resp.setContentType("text/html;charset=utf-8");
				resp.getWriter().print("등록실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}








