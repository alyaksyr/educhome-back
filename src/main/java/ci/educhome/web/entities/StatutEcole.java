package ci.educhome.web.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="aqi_ecole_statut")
public class StatutEcole {
	@Id
	@Column(unique=true, length=1, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true, length=5,name="code_statut")
	private String codeStatut;
	
	@Column(length=20,name="libelle_statut")
	private String libelleStatut;
	
	@OneToMany(mappedBy="statutEcole",cascade=CascadeType.ALL)
	private Set<Ecole> ecole = new HashSet<>();

	public StatutEcole() {
		super();
	}

	public StatutEcole(int id, String codeStatut, String libelleStatut, Set<Ecole> ecole) {
		super();
		this.id = id;
		this.codeStatut = codeStatut;
		this.libelleStatut = libelleStatut;
		this.ecole = ecole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodeStatut() {
		return codeStatut;
	}

	public void setCodeStatut(String codeStatut) {
		this.codeStatut = codeStatut;
	}

	public String getLibelleStatut() {
		return libelleStatut;
	}

	public void setLibelleStatut(String libelleStatut) {
		this.libelleStatut = libelleStatut;
	}

	public Set<Ecole> getEcole() {
		return ecole;
	}

	public void setEcole(Set<Ecole> ecole) {
		this.ecole = ecole;
	}

}
