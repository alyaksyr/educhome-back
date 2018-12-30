package ci.educhome.web.entities;

import javax.persistence.*;

@Entity
@Table(name="aqi_enseignant")
public class Enseignant extends Profile{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, length=11)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=3)
	private int experience;
	
	@Column(length=100)
	private String cv;
	
	@ManyToOne()
	@JoinColumn(name="id_diplome")
	private Diplome diplome;
	
	@ManyToOne()
	@JoinColumn(name="id_ecole")
	private Ecole ecole;
	
	@ManyToOne()
	@JoinColumn(name="id_matiere")
	private Matiere matiere;
	
	@Column(length=150)
	private String matieres;
	
	@Column(length=150)
	private String dispo_id;
	
	@Column()
	private String biographie;
	
	@Column(length=1)
	private int is_accepet;
	
	@Column(length=1)
	private int is_valid;
}
