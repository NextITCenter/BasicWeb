package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		session.removeAttribute("member");
		// 세션에서 모든 데이터를 삭제할 때는 invalidate()를 사용한다.
		// 주로 세션을 제거할 때는 속성 값을 하나하나 지정하는 것보다는
		// invalidate() 함수를 이용해서 모든 값을 지우는 방법을 많이 사용한다.
		session.invalidate();
		resp.sendRedirect("/boards");
	}
}



