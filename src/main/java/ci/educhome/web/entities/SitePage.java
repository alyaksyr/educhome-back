package ci.educhome.web.entities;

import javax.persistence.*;

@Entity
@Table(name="aqi_page")
public class SitePage extends DateAudit {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false,columnDefinition="INT(5)")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=35)
	private String page_code;
	
	@Column(length=200)
	private String page_title;
	
	@Column(length=200)
	private String page_subtitle;
	
	@Column(length=200)
	private String page_header;
	
	@Column(columnDefinition="TEXT")
	private String page_content;
	
	@Column(columnDefinition="INT(1)")
	private int locked;

	@Column(length=50)
	private String page_position;
	
	public SitePage() {
		super();
	}

	public SitePage(int id, String page_code, String page_title, String page_subtitle, String page_header,
			String page_content, int locked) {
		super();
		this.id = id;
		this.page_code = page_code;
		this.page_title = page_title;
		this.page_subtitle = page_subtitle;
		this.page_header = page_header;
		this.page_content = page_content;
		this.locked = locked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPage_code() {
		return page_code;
	}

	public void setPage_code(String page_code) {
		this.page_code = page_code;
	}

	public String getPage_title() {
		return page_title;
	}

	public void setPage_title(String page_title) {
		this.page_title = page_title;
	}

	public String getPage_subtitle() {
		return page_subtitle;
	}

	public void setPage_subtitle(String page_subtitle) {
		this.page_subtitle = page_subtitle;
	}

	public String getPage_header() {
		return page_header;
	}

	public void setPage_header(String page_header) {
		this.page_header = page_header;
	}

	public String getPage_content() {
		return page_content;
	}

	public void setPage_content(String page_content) {
		this.page_content = page_content;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}
	

}
