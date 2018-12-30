package ci.educhome.web.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="aqi_chapitre")
public class Chapitre implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=11)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true, length=10)
	private String chapitre_code;
	
	@Column(length=50)
	private String chapitre_libelle;
	
	@Column(columnDefinition="TEXT")
	private String chapitre_resume;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_matiere")
	private Matiere matiere;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_niveau")
	private Niveau niveau;

	public Chapitre() {
		super();
	}

	public Chapitre(int id, String chapitre_code, String chapitre_libelle, String chapitre_resume, Matiere matiere,
			Niveau niveau) {
		super();
		this.id = id;
		this.chapitre_code = chapitre_code;
		this.chapitre_libelle = chapitre_libelle;
		this.chapitre_resume = chapitre_resume;
		this.matiere = matiere;
		this.niveau = niveau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChapitre_code() {
		return chapitre_code;
	}

	public void setChapitre_code(String chapitre_code) {
		this.chapitre_code = chapitre_code;
	}

	public String getChapitre_libelle() {
		return chapitre_libelle;
	}

	public void setChapitre_libelle(String chapitre_libelle) {
		this.chapitre_libelle = chapitre_libelle;
	}

	public String getChapitre_resume() {
		return chapitre_resume;
	}

	public void setChapitre_resume(String chapitre_resume) {
		this.chapitre_resume = chapitre_resume;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	
	
	
	
	
}
