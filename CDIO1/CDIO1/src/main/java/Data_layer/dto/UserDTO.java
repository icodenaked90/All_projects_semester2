package Data_layer.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 4545864587995944260L;
	private int	userId;                     
	private String userName;                
	private String ini;
	private int cpr;
	private String pass;
	private String roles;

	public UserDTO() {
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIni() {
		return ini;
	}
	public void setIni(String ini) {
		this.ini = ini;
	}
	public int getCpr() { return cpr; }
	public void setCpr(int cpr) { this.cpr = cpr; }
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	//Methods for multiple roles in a list. To be implemented when we can save a List in the database with serialization.
//	public List<String> getRoles() {
//		return roles;
//	}
//	public void setRoles(List<String> roles) {
//		this.roles = roles;
//	}
//
//	public void addRole(String role){
//		this.roles.add(role);
//	}

	/**
	 * 
	 * @param //role
	 * @return true if role existed, false if not
	 */
//	public boolean removeRole(String role){
//		return this.roles.remove(role);
//	}

	@Override
	public String toString() {
		return "UserDTO{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", ini='" + ini + '\'' +
				", cpr=" + cpr +
				", pass='" + pass + '\'' +
				", roles=" + roles +
				'}';
	}
}
