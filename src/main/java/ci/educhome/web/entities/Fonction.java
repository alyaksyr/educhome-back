package ci.educhome.web.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="aqi_fonction")
public class Fonction  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false,columnDefinition="INT(5)")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=25)
	private String code;
    
	@Column(length=75)
	private String libelle;

	public Fonction() {
		super();
	
	}
	
	public Fonction(int id, String code, String libelle) {
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
	
	
}
