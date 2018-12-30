package ci.educhome.web.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="aqi_abonnement")
public class Abonnement  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_user")
	private Users user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_formule")
	private Formule formule;
	
	private LocalDateTime added;
	
	private LocalDateTime expired;
	
	@Column(columnDefinition="INT(1)")
	private int is_valid;

	public Abonnement() {
		super();
		
	}

	public Abonnement(long id, Users user, Formule formule, LocalDateTime added, LocalDateTime expired, int is_valid) {
		super();
		this.id = id;
		this.user = user;
		this.formule = formule;
		this.added = added;
		this.expired = expired;
		this.is_valid = is_valid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Formule getFormule() {
		return formule;
	}

	public void setFormule(Formule formule) {
		this.formule = formule;
	}

	public LocalDateTime getAdded() {
		return added;
	}

	public void setAdded(LocalDateTime added) {
		this.added = added;
	}

	public LocalDateTime getExpired() {
		return expired;
	}

	public void setExpired(LocalDateTime expired) {
		this.expired = expired;
	}

	public int getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}
	
}
