package ci.educhome.web.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="aqi_cours_favorite")
public class CoursFavorite implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime added;
	
	@Column(columnDefinition="INT(1)")
	private int is_favori;
	
	@Column(columnDefinition="INT(1)")
	private int loved;
	
	@Column(columnDefinition="INT(1)")
	private int disabled;
	
	@Column(columnDefinition="INT(1)")
	private int is_payed;
	
	private LocalDateTime payed_at;
	
	private LocalDateTime payed_expired;
	
	@Column(columnDefinition="INT(6)")
	private int play_time;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_eleve")
	private Users user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_cours")
	private Cours cours;

	public CoursFavorite() {
		super();
	}

	public CoursFavorite(Long id, LocalDateTime added, int is_favori, int loved, int disabled, int is_payed,
			LocalDateTime payed_at, LocalDateTime payed_expired, int play_time, Users user, Cours cours) {
		super();
		this.id = id;
		this.added = added;
		this.is_favori = is_favori;
		this.loved = loved;
		this.disabled = disabled;
		this.is_payed = is_payed;
		this.payed_at = payed_at;
		this.payed_expired = payed_expired;
		this.play_time = play_time;
		this.user = user;
		this.cours = cours;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getAdded() {
		return added;
	}

	public void setAdded(LocalDateTime added) {
		this.added = added;
	}

	public int getIs_favori() {
		return is_favori;
	}

	public void setIs_favori(int is_favori) {
		this.is_favori = is_favori;
	}

	public int getLoved() {
		return loved;
	}

	public void setLoved(int loved) {
		this.loved = loved;
	}

	public int getDisabled() {
		return disabled;
	}

	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}

	public int getIs_payed() {
		return is_payed;
	}

	public void setIs_payed(int is_payed) {
		this.is_payed = is_payed;
	}

	public LocalDateTime getPayed_at() {
		return payed_at;
	}

	public void setPayed_at(LocalDateTime payed_at) {
		this.payed_at = payed_at;
	}

	public LocalDateTime getPayed_expired() {
		return payed_expired;
	}

	public void setPayed_expired(LocalDateTime payed_expired) {
		this.payed_expired = payed_expired;
	}

	public int getPlay_time() {
		return play_time;
	}

	public void setPlay_time(int play_time) {
		this.play_time = play_time;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}
	
}
