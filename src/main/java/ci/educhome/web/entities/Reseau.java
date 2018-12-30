package ci.educhome.web.entities;

import javax.persistence.*;

@Embeddable
public class Reseau {
	private String facebook;
	private String twitter;
	private String linkedin;
	private String gplus;
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getGplus() {
		return gplus;
	}
	public void setGplus(String gplus) {
		this.gplus = gplus;
	}
	
}
