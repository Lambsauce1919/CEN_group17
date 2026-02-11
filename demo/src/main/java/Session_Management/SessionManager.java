package Session_Management;

public class SessionManager {
	
	private static SessionManager instance; // Holds the single shared instance of SessionManager.

	public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
	
	private boolean isAuthenticated;
	private String session_token;

	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	public String getSession_token() {
		return session_token;
	}
	public void setSession_token(String session_token) {
		this.session_token = session_token;
	}
	
}
