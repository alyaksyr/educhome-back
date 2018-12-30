package ci.educhome.web.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="aqi_formule")
public class Formule implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=100)
	private String formule_libelle;
	
	@Column(length=50)
	private String formule_option;
	
	private double formule_tarif;
	
	@Column(columnDefinition="INT(3)")
	private int formule_duree;
	
	@Column(columnDefinition="TEXT")
	private String formule_contenu;
	
	@Column(columnDefinition="INT(1)")
	private int is_free;

	public Formule() {
		super();
	
	}

	public Formule(int id, String formule_libelle, String formule_option, double formule_tarif, int formule_duree,
			String formule_contenu, int is_free) {
		super();
		this.id = id;
		this.formule_libelle = formule_libelle;
		this.formule_option = formule_option;
		this.formule_tarif = formule_tarif;
		this.formule_duree = formule_duree;
		this.formule_contenu = formule_contenu;
		this.is_free = is_free;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormule_libelle() {
		return formule_libelle;
	}

	public void setFormule_libelle(String formule_libelle) {
		this.formule_libelle = formule_libelle;
	}

	public String getFormule_option() {
		return formule_option;
	}

	public void setFormule_option(String formule_option) {
		this.formule_option = formule_option;
	}

	public double getFormule_tarif() {
		return formule_tarif;
	}

	public void setFormule_tarif(double formule_tarif) {
		this.formule_tarif = formule_tarif;
	}

	public int getFormule_duree() {
		return formule_duree;
	}

	public void setFormule_duree(int formule_duree) {
		this.formule_duree = formule_duree;
	}

	public String getFormule_contenu() {
		return formule_contenu;
	}

	public void setFormule_contenu(String formule_contenu) {
		this.formule_contenu = formule_contenu;
	}

	public int getIs_free() {
		return is_free;
	}

	public void setIs_free(int is_free) {
		this.is_free = is_free;
	} 
	
	
}
