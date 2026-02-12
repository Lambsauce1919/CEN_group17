package profile_management.pObject_JSON;

// This JSON holds all required data for registration.

// REQ: user pass
// OPT: name, email, home address

// Brenden

public class RGData {

	private String username;
	private String password;
	
	private String hAddress;
	private String eMail;
	private String name;

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String gethAddress() {
		return hAddress;
	}
	public void sethAddress(String hAddress) {
		this.hAddress = hAddress;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public RGData(String username, String password, String hAddress, String eMail, String name) {
		super();
		this.username = username;
		this.password = password;
		this.hAddress = hAddress;
		this.eMail = eMail;
		this.name = name;
	}

}
