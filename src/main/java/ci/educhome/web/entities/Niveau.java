package ci.educhome.web.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="aqi_classe")
public class Niveau {
	@Id
	@Column(unique=true, nullable=false, length=3)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true, length=10)
	private String niveau_code;
	
	@Column(length=50)
	private String niveau_libelle;
	
	private String niveau_description;
	
	@Column(columnDefinition="TEXT")
	private String niveau_resume;
	
	@OneToMany(mappedBy="niveau",cascade=CascadeType.ALL)
	private Set<Eleve> eleve;
	
	public Niveau() {
		super();
	}

	public Niveau(int id, String niveau_code, String niveau_libelle, String niveau_description, String niveau_resume,
			Set<Eleve> eleve) {
		super();
		this.id = id;
		this.niveau_code = niveau_code;
		this.niveau_libelle = niveau_libelle;
		this.niveau_description = niveau_description;
		this.niveau_resume = niveau_resume;
		this.eleve = eleve;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNiveau_code() {
		return niveau_code;
	}

	public void setNiveau_code(String niveau_code) {
		this.niveau_code = niveau_code;
	}

	public String getNiveau_libelle() {
		return niveau_libelle;
	}

	public void setNiveau_libelle(String niveau_libelle) {
		this.niveau_libelle = niveau_libelle;
	}

	public String getNiveau_description() {
		return niveau_description;
	}

	public void setNiveau_description(String niveau_description) {
		this.niveau_description = niveau_description;
	}

	public String getNiveau_resume() {
		return niveau_resume;
	}

	public void setNiveau_resume(String niveau_resume) {
		this.niveau_resume = niveau_resume;
	}

	public Set<Eleve> getEleve() {
		return eleve;
	}

	public void setEleve(Set<Eleve> eleve) {
		this.eleve = eleve;
	}
	
}
