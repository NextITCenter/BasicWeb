package employee;

import java.time.LocalDate;

public class EmployeeVO {
	private int employeeId;
	private String empName;
	private String email;
	private String phoneNumber;
	private LocalDate hireDate;
	public EmployeeVO() {
	}
	// 생성자가 setter를 대신할 수 있기 때문에 현실에서는 setter를 만들지 않는 경우가 많다.
	public EmployeeVO(int employeeId, String empName, String email, String phoneNumber, LocalDate hireDate) {
		this.employeeId = employeeId;
		this.empName = empName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	@Override
	public String toString() {
		return "EmployeeVO [employeeId=" + employeeId + ", empName=" + empName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", hireDate=" + hireDate + "]";
	}
	
}
