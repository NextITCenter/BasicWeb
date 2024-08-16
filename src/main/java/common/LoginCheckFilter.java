package common;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chapter05.MemberDTO;
@WebFilter("/boards/register")
public class LoginCheckFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 요청 정보에서 url 정보 확인
		System.out.println("요청 url: " + req.getRequestURI());
		
		// 세션에서 로그인 정보 확인
		HttpSession session = req.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if (member != null) {
			// 로그인 정보가 존재하기 때문에 그다음 메소드 실행
			// 다음 필터가 실행되거나 원래 실행하려고 했던 서블릿 실행
			super.doFilter(req, res, chain);
		} else {
			session.setAttribute("retUrl", req.getRequestURI());
			res.sendRedirect("/login");
		}
	}
}





