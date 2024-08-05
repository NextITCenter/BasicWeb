package chapter05;

// 우리나라 웹 개발에서는 DTO보다는 VO(Value Object)를 많이 사용
public class MemberDTO {
	private String memId;
	private String memName;
	private String memHp;
	private String memMail;
	// 생성자
	public MemberDTO(String memId, String memName, String memHp, String memMail) {
		this.memId = memId;
		this.memName = memName;
		this.memHp = memHp;
		this.memMail = memMail;
	}
	// getter and setter
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemHp() {
		return memHp;
	}
	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	// toString()
	@Override
	public String toString() {
		return "MemberDTO [memId=" + memId + ", memName=" + memName + ", memHp=" + memHp + ", memMail=" + memMail + "]";
	}
	
}
