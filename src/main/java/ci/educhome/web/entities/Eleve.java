package ci.educhome.web.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="aqi_eleve")
public class Eleve extends Profile {
	
	private static final long serialVersionUID = 1L;

	@Column(length=15,name="matricule")
	private String code_eleve;
	
    @ManyToOne()
	@JoinColumn(name="id_classe")
	private Niveau niveau;
	
    @ManyToOne()
	@JoinColumn(name="id_ecole")
	private Ecole ecole; 
	
	@Column()
	private boolean status;

	public Eleve() {
		super();
	}

	public Eleve(String code_eleve, Niveau niveau, Ecole ecole, boolean status) {
		super();
		this.code_eleve = code_eleve;
		this.niveau = niveau;
		this.ecole = ecole;
		this.status = status;
	}
	
	public Eleve(Genre genre, Civilite civilite, String nom, String prenom, String nickname, Date dateNais,
			String lieuNais, Piece piece, String numPiece, Fonction fonction, Pays pays, Ville ville, Adresse adresse,
			Reseau reseau, String photo, int is_valid) {
		super(genre, civilite, nom, prenom, nickname, dateNais, lieuNais, piece, numPiece, fonction, pays, ville, adresse,
				reseau, photo, is_valid);
	}

	public String getCode_eleve() {
		return code_eleve;
	}

	public void setCode_eleve(String code_eleve) {
		this.code_eleve = code_eleve;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
