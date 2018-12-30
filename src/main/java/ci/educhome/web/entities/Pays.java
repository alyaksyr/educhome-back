package ci.educhome.web.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="aqi_pays")
public class Pays  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=3, unique=true)
	private String code;
	
	@Column(length=50)
	private String libelle;

	public Pays() {
		super();
	}

	public Pays(int id, String code, String libelle) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/*public Set<Profile> getProfil() {
		return profil;
	}

	public void setProfil(Set<Profile> profil) {
		this.profil = profil;
	}

	public Set<Ecole> getEcole() {
		return ecole;
	}

	public void setEcole(Set<Ecole> ecole) {
		this.ecole = ecole;
	}*/

	
}
