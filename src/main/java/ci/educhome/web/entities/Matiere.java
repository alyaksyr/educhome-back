package ci.educhome.web.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="aqi_matiere")
public class Matiere implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=4)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true, length=10)
	private String matiere_code;
	
	@Column(length=100)
	private String matiere_libelle;
	
	@Column(columnDefinition="TEXT")
	private String matiere_resume;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_classe")
	private Niveau niveau;

	public Matiere() {
		super();
	}

	public Matiere(int id, String matiere_code, String matiere_libelle, String matiere_resume, Niveau niveau) {
		super();
		this.id = id;
		this.matiere_code = matiere_code;
		this.matiere_libelle = matiere_libelle;
		this.matiere_resume = matiere_resume;
		this.niveau = niveau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatiere_code() {
		return matiere_code;
	}

	public void setMatiere_code(String matiere_code) {
		this.matiere_code = matiere_code;
	}

	public String getMatiere_libelle() {
		return matiere_libelle;
	}

	public void setMatiere_libelle(String matiere_libelle) {
		this.matiere_libelle = matiere_libelle;
	}

	public String getMatiere_resume() {
		return matiere_resume;
	}

	public void setMatiere_resume(String matiere_resume) {
		this.matiere_resume = matiere_resume;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	
}
