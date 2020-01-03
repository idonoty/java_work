package WanZheng.java.utils.httpclient;

import com.github.crab2died.annotation.ExcelField;

public class ParameterBean {
	@ExcelField(title = "username")
	private String username;
	@ExcelField(title = "password")
	private String password;
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ParameterBean [username=" + username + ", password=" + password + "]";
	}
}
