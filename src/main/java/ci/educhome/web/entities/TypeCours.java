package ci.educhome.web.entities;

import javax.persistence.*;

@Entity
@Table(name= "aqi_cours_type")
public class TypeCours {
	@Id
	@Column(unique=true, nullable=false, length=2)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true, length=10)
	private String type_cours_code;
	
	@Column(length=50)
	private String type_cours_libelle;

}
