package profile_management.pObject_JSON;
// - Brenden
public class LoginData {

	private String userName;
	private String passWord;
	
	private boolean authenticated;
	private String token;
	
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public LoginData(String userName, String passWord) { // This is for the initial API call, information from the user is sent over.
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public LoginData(boolean authenticated, String token) { // This is on-reponse information from the back-end.
		super();
		this.authenticated = authenticated;
		this.token = token;
	}
	
	
	
}
