package ci.educhome.web.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="aqi_users",uniqueConstraints= 
	{@UniqueConstraint(columnNames= {"login"}),
	@UniqueConstraint(columnNames= {"login"})
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Users extends DateAudit{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length=11, unique=true, updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name="aqi_users_role",joinColumns=@JoinColumn(name="id_roles"),
	inverseJoinColumns=@JoinColumn(name="id_users"))
	private Set<Role> roles = new HashSet<>();
	@Column(length=10,nullable=false,unique=true)
	private String code;
	
	@Column(unique=true,nullable=false,length=40)
	private String login;
	
	private String password;
	@Column(length=100)
	private String email;
	@Column(length=100)
	private String url;
	@Column(length=100)
	private String activation_key;
	private String token;
	private int lastvisit; //La dernière fois que l'utilisateur a effectué une action
	private boolean online;//Pour savoir si l'utilisateur est en ligne
	private boolean validate; //Si l'utilisateur a valider son compte
	private boolean locked; //Si le compte de l'utilisateur est suspendu
	@Column(name="parrain")
	private int added_by; //Le parrain de l'utilisateur
	
	public Users() {
		super();
	}

	public Users(Set<Role> roles, String code, String login, String password, String email, String url,
			String activation_key, String token, int lastvisit, boolean online, boolean validate, boolean locked,
			int added_by) {
		super();
		this.roles = roles;
		this.code = code;
		this.login = login;
		this.password = password;
		this.email = email;
		this.url = url;
		this.activation_key = activation_key;
		this.token = token;
		this.lastvisit = lastvisit;
		this.online = online;
		this.validate = validate;
		this.locked = locked;
		this.added_by = added_by;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getActivation_key() {
		return activation_key;
	}

	public void setActivation_key(String activation_key) {
		this.activation_key = activation_key;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getLastvisit() {
		return lastvisit;
	}

	public void setLastvisit(int lastvisit) {
		this.lastvisit = lastvisit;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getAdded_by() {
		return added_by;
	}

	public void setAdded_by(int added_by) {
		this.added_by = added_by;
	}

	
}