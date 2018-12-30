package ci.educhome.web.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="aqi_cours_prix")
public class TarifCours implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=100)
	private String libelle_prix;
	
	@Column(length=50)
	private String prix_option;
	
	private double prix_montant;
	
	@Column(columnDefinition="INT(1)")
	private int is_valid;
	
	@Column(columnDefinition="INT(3)")
	private int valid_date;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_cours")
	private Cours cours;

	public TarifCours() {
		super();
		
	}

	public TarifCours(int id, String libelle_prix, String prix_option, double prix_montant, int is_valid,
			int valid_date, Cours cours) {
		super();
		this.id = id;
		this.libelle_prix = libelle_prix;
		this.prix_option = prix_option;
		this.prix_montant = prix_montant;
		this.is_valid = is_valid;
		this.valid_date = valid_date;
		this.cours = cours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle_prix() {
		return libelle_prix;
	}

	public void setLibelle_prix(String libelle_prix) {
		this.libelle_prix = libelle_prix;
	}

	public String getPrix_option() {
		return prix_option;
	}

	public void setPrix_option(String prix_option) {
		this.prix_option = prix_option;
	}

	public double getPrix_montant() {
		return prix_montant;
	}

	public void setPrix_montant(double prix_montant) {
		this.prix_montant = prix_montant;
	}

	public int getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}

	public int getValid_date() {
		return valid_date;
	}

	public void setValid_date(int valid_date) {
		this.valid_date = valid_date;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

}
