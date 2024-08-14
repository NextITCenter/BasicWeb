package login;

import chapter05.MemberDTO;

public interface LoginMapper {
	MemberDTO findMemberById(String id);
}
