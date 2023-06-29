package Bean;

public class SiginBean {
	private String nameSignIn;
	private String userNameSignIn;
	private String emailSignIn;
	private String passWordSignIn;
	private String confirmPasswordSignIn;
	private String rulesSignIn;
	public SiginBean(String nameSignIn, String userNameSignIn, String emailSignIn, String passWordSignIn,
			String confirmPasswordSignIn, String rulesSignIn) {
		super();
		this.nameSignIn = nameSignIn;
		this.userNameSignIn = userNameSignIn;
		this.emailSignIn = emailSignIn;
		this.passWordSignIn = passWordSignIn;
		this.confirmPasswordSignIn = confirmPasswordSignIn;
		this.rulesSignIn = rulesSignIn;
	}
	public SiginBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNameSignIn() {
		return nameSignIn;
	}
	public void setNameSignIn(String nameSignIn) {
		this.nameSignIn = nameSignIn;
	}
	public String getUserNameSignIn() {
		return userNameSignIn;
	}
	public void setUserNameSignIn(String userNameSignIn) {
		this.userNameSignIn = userNameSignIn;
	}
	public String getEmailSignIn() {
		return emailSignIn;
	}
	public void setEmailSignIn(String emailSignIn) {
		this.emailSignIn = emailSignIn;
	}
	public String getPassWordSignIn() {
		return passWordSignIn;
	}
	public void setPassWordSignIn(String passWordSignIn) {
		this.passWordSignIn = passWordSignIn;
	}
	public String getConfirmPasswordSignIn() {
		return confirmPasswordSignIn;
	}
	public void setConfirmPasswordSignIn(String confirmPasswordSignIn) {
		this.confirmPasswordSignIn = confirmPasswordSignIn;
	}
	public String getRulesSignIn() {
		return rulesSignIn;
	}
	public void setRulesSignIn(String rulesSignIn) {
		this.rulesSignIn = rulesSignIn;
	}
	
	
	
}
