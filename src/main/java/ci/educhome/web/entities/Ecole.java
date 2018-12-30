package ci.educhome.web.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="aqi_ecole")
public class Ecole implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=11)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="pays_id")
	private Pays pays;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="ville_id")
	private Ville ville;
	
	@Column(length=11, unique=true)
	private String code_ecole;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="type_id")
	private TypeEcole typeEcole;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="nature_id")
	private StatutEcole statutEcole;
	
	@OneToMany(mappedBy="ecole",cascade=CascadeType.ALL)
	private Set<Eleve> eleve;
	
	@Column(length=150)
	private String libelle;

	public Ecole() {
		super();
	}

	public Ecole(int id, Adresse adresse, Pays pays, Ville ville, String code_ecole, TypeEcole typeEcole,
			StatutEcole statutEcole, Set<Eleve> eleve, String libelle) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.pays = pays;
		this.ville = ville;
		this.code_ecole = code_ecole;
		this.typeEcole = typeEcole;
		this.statutEcole = statutEcole;
		this.eleve = eleve;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getCode_ecole() {
		return code_ecole;
	}

	public void setCode_ecole(String code_ecole) {
		this.code_ecole = code_ecole;
	}

	public TypeEcole getTypeEcole() {
		return typeEcole;
	}

	public void setTypeEcole(TypeEcole typeEcole) {
		this.typeEcole = typeEcole;
	}

	public StatutEcole getStatutEcole() {
		return statutEcole;
	}

	public void setStatutEcole(StatutEcole statutEcole) {
		this.statutEcole = statutEcole;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
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

	public Set<Eleve> getEleve() {
		return eleve;
	}

	public void setEleve(Set<Eleve> eleve) {
		this.eleve = eleve;
	}
	
	
}
