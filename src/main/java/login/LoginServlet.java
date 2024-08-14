package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chapter05.MemberDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		LoginService service = LoginService.getInstance();
		MemberDTO member = service.findMemberById(userId, userPw);
		// session: req에서 가져옴
		// cookie: resp에 저장
		if (member != null) {
			// 로그인 처리
			HttpSession session = req.getSession();
			session.setAttribute("member", member);
			// 로그인 끝났을 때 이동할 페이지를 리다이렉트 해줌
			resp.sendRedirect("/boards");
		} else {
			// 로그인 실패
			req.setAttribute("msg", "아이디 또는 비밀번호가 일치하는 사용자가 없습니다.");
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}
	}
}






