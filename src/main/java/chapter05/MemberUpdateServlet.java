package chapter05;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 조회할 member의 아이디
		String id = req.getParameter("id");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		MemberDTO memberDTO = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std225", "oracle21c");
			String sql = """
					SELECT
						MEM_ID,
						MEM_NAME,
						MEM_BIR,
						MEM_HP,
						MEM_MAIL,
						MEM_ZIP,
						MEM_ADD1,
						MEM_ADD2
					FROM
						MEMBER
					WHERE
						MEM_ID = ?
					""";
			statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String memId = resultSet.getString("mem_id");
				String memName = resultSet.getString("mem_name");
				Date memBir = resultSet.getDate("mem_bir");
				String memHp = resultSet.getString("mem_hp");
				String memMail = resultSet.getString("mem_mail");
				String memZip = resultSet.getString("mem_zip");
				String memAdd1 = resultSet.getString("mem_add1");
				String memAdd2 = resultSet.getString("mem_add2");
				memberDTO = new MemberDTO(memId, memName, memBir.toLocalDate(), memZip, memAdd1, memAdd2, memHp, memMail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		req.setAttribute("member", memberDTO);
		req.getRequestDispatcher("/WEB-INF/views/member/update.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		String memName = req.getParameter("memName");
		String memBir = req.getParameter("memBir");
		String memHp = req.getParameter("memHp");
		String memMail = req.getParameter("memMail");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std225", "oracle21c");
			String sql = """
					update
						member
					set
						mem_pass = ?,
						mem_name = ?,
						mem_bir = ?,
						mem_hp = ?,
						mem_mail = ?
					where
						mem_id = ?
					""";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, memPass);
			statement.setString(2, memName);
			statement.setDate(3, Date.valueOf(memBir));
			statement.setString(4, memHp);
			statement.setString(5, memMail);
			statement.setString(6, memId);
			
			int executeUpdate = statement.executeUpdate();
			if (executeUpdate > 0) {
				resp.sendRedirect("/member/list");
			} else {
				resp.sendRedirect("/member/detail?id=" + memId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






