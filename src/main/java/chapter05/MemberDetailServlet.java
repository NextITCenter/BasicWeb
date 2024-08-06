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

public class MemberDetailServlet extends HttpServlet {
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
		req.getRequestDispatcher("/WEB-INF/views/member/detail.jsp").forward(req, resp);
	}
}








