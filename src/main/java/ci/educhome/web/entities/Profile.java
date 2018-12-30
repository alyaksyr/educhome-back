package ci.educhome.web.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="aqi_users_profile")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Profile extends Users {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_genre",columnDefinition="INT(1)")
	private Genre genre;
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_civilite",columnDefinition="INT(2)")
	private Civilite civilite;
	
	@Column(length=30)
	private String nom;
	
	@Column(length=40)
	private String prenom;
	
	@Column(length=75)
	private String nickname;
	
	@DateTimeFormat(pattern="jj/mm/aaaa")
	private Date dateNais;
	
	@Column(length=150)
	private String lieuNais;
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)//fetch = FetchType.EAGER, cascade = CascadeType.ALL
	@JoinColumn(name="id_piece",columnDefinition="INT(2)")
	private Piece piece;
	
	@Column(length=15)
	private String numPiece;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_fonction",columnDefinition="INT(5)")
	private Fonction fonction;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_pays")
	private Pays pays;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_ville")
	private Ville ville;
	
	@Embedded
	private Adresse adresse;
	
	@Embedded
	private Reseau reseau;
	
	@Column(length=200)
	private String photo;
	
	@Column(columnDefinition="INT(1)")
	private int is_valid;

	public Profile() {
		super();
	
	}

	public Profile(Genre genre, Civilite civilite, String nom, String prenom, String nickname, Date dateNais,
			String lieuNais, Piece piece, String numPiece, Fonction fonction, Pays pays, Ville ville, Adresse adresse,
			Reseau reseau, String photo, int is_valid) {
		super();
		this.genre = genre;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.nickname = nickname;
		this.dateNais = dateNais;
		this.lieuNais = lieuNais;
		this.piece = piece;
		this.numPiece = numPiece;
		this.fonction = fonction;
		this.pays = pays;
		this.ville = ville;
		this.adresse = adresse;
		this.reseau = reseau;
		this.photo = photo;
		this.is_valid = is_valid;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getDateNais() {
		return dateNais;
	}

	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}

	public String getLieuNais() {
		return lieuNais;
	}

	public void setLieuNais(String lieuNais) {
		this.lieuNais = lieuNais;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public String getNumPiece() {
		return numPiece;
	}

	public void setNumPiece(String numPiece) {
		this.numPiece = numPiece;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Reseau getReseau() {
		return reseau;
	}

	public void setReseau(Reseau reseau) {
		this.reseau = reseau;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public int getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}
	
	
}
