package ci.educhome.web.entities;

import javax.persistence.*;

@Entity
@Table(name="aqi_cours")
public class Cours extends DateAudit {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=10,unique=true, updatable=false, nullable=false)
	private int code_cours;
	
	@Column(length=150)
	private String titre_cours;
	
	@Column(columnDefinition="TEXT")
	private String resume_cours;
	
	@Column(columnDefinition="TEXT")
	private String contenu_cours;
	
	@Column(unique=true)
	private String video_cours;
	
	private double duree_cours;
	
	@Column(unique=true)
	private String image;
	
	@Column(columnDefinition="INT(1)")
	private int locked;
	
	@Column(columnDefinition="INT(1)")
	private int is_valid;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_type_cours")
	private TypeCours type_cours;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_prof")
	private Users prof;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_chapitre")
	private Chapitre chapitre;

	public Cours() {
		super();
	}

	public Cours(Long id, int code_cours, String titre_cours, String resume_cours, String contenu_cours,
			String video_cours, double duree_cours, String image, int locked, int is_valid, TypeCours type_cours,
			Users prof, Chapitre chapitre) {
		super();
		this.id = id;
		this.code_cours = code_cours;
		this.titre_cours = titre_cours;
		this.resume_cours = resume_cours;
		this.contenu_cours = contenu_cours;
		this.video_cours = video_cours;
		this.duree_cours = duree_cours;
		this.image = image;
		this.locked = locked;
		this.is_valid = is_valid;
		this.type_cours = type_cours;
		this.prof = prof;
		this.chapitre = chapitre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCode_cours() {
		return code_cours;
	}

	public void setCode_cours(int code_cours) {
		this.code_cours = code_cours;
	}

	public String getTitre_cours() {
		return titre_cours;
	}

	public void setTitre_cours(String titre_cours) {
		this.titre_cours = titre_cours;
	}

	public String getResume_cours() {
		return resume_cours;
	}

	public void setResume_cours(String resume_cours) {
		this.resume_cours = resume_cours;
	}

	public String getContenu_cours() {
		return contenu_cours;
	}

	public void setContenu_cours(String contenu_cours) {
		this.contenu_cours = contenu_cours;
	}

	public String getVideo_cours() {
		return video_cours;
	}

	public void setVideo_cours(String video_cours) {
		this.video_cours = video_cours;
	}

	public double getDuree_cours() {
		return duree_cours;
	}

	public void setDuree_cours(double duree_cours) {
		this.duree_cours = duree_cours;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public int getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}

	public TypeCours getType_cours() {
		return type_cours;
	}

	public void setType_cours(TypeCours type_cours) {
		this.type_cours = type_cours;
	}

	public Users getProf() {
		return prof;
	}

	public void setProf(Users prof) {
		this.prof = prof;
	}

	public Chapitre getChapitre() {
		return chapitre;
	}

	public void setChapitre(Chapitre chapitre) {
		this.chapitre = chapitre;
	}
		
}
