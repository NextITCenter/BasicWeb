package login;

import org.apache.ibatis.session.SqlSession;

import chapter05.MemberDTO;
import common.MySqlSession;

public class LoginService {
	private static LoginMapper mapper;
	private static LoginService instance = new LoginService();
	private LoginService() {
//		SqlSession session = MySqlSession.getSqlSession();
//		mapper = session.getMapper(LoginMapper.class);
	}
	public static LoginService getInstance(SqlSession session) {
		mapper = session.getMapper(LoginMapper.class);
		return instance;
	}
	
	public MemberDTO findMemberById(String id, String password) {
		/*
		 *  로그인 처리 방식의 변화
		 *  초창기: 아이디와 비밀번호가 일치하는 사용자가 존재여부
		 *  최근: 아이디로 사용자 정보를 가져온 뒤 비밀번호를 비교해서
		 *  비밀번호가 일치하면 로그인
		 */
		MemberDTO member = mapper.findMemberById(id);
		if (member.getMemPass().equals(password)) {
			return member;
		}
		return null;
	}
}
