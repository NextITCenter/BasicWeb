package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<EmployeeVO> employees = new ArrayList<>();
		try {
//			// 1. 드라이버 로딩
//			Class.forName("oracle.jdbc.OracleDriver");
//
//			// 2. 접속 정보를 가지고 접속
//			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "java", "oracle21c");
			Connection connection = DriverManager.getConnection("jdbc:apache:commons:dbcp:chaper17");
			// 3. 작업 편집기(워크시트)를 생성해준다.
			Statement statement = connection.createStatement();

			// 4. 쿼리 작성
			String sql = "select employee_id, emp_name, email, phone_number, hire_date from employees";

			// 5. 쿼리 실행
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				int employeeId = resultSet.getInt("employee_id");
				String empName = resultSet.getString("emp_name");
				String email = resultSet.getString("email");
				String phoneNumber = resultSet.getString("phone_number");
				Date hireDate = resultSet.getDate("hire_date");
				employees.add(new EmployeeVO(employeeId, empName, email, phoneNumber, hireDate.toLocalDate()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("employees", employees);
//		request.getRequestDispatcher("/employees.jsp").forward(request, response);
		PrintWriter writer = response.getWriter();
		
	}

}







