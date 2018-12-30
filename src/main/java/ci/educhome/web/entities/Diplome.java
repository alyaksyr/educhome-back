package ci.educhome.web.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="aqi_diplome")
public class Diplome implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=4)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true, length=10)
	private String diplome_code;
	
	@Column(length=50)
	private String diplome_libelle;
}
