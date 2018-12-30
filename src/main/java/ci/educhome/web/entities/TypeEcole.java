package ci.educhome.web.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="aqi_ecole_type")
public class TypeEcole {
	@Id
	@Column(unique=true, length=1, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true, length=5)
	private String code_type;
	
	@Column(length=20)
	private String type_ecole;
	
	@OneToMany(mappedBy="typeEcole",cascade=CascadeType.ALL)
	private Set<Ecole> ecole = new HashSet<>();

	public TypeEcole() {
		super();
	}

	public TypeEcole(int id, String code_type, String type_ecole, Set<Ecole> ecole) {
		super();
		this.id = id;
		this.code_type = code_type;
		this.type_ecole = type_ecole;
		this.ecole = ecole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode_type() {
		return code_type;
	}

	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}

	public String getType_ecole() {
		return type_ecole;
	}

	public void setType_ecole(String type_ecole) {
		this.type_ecole = type_ecole;
	}

	public Set<Ecole> getEcole() {
		return ecole;
	}

	public void setEcole(Set<Ecole> ecole) {
		this.ecole = ecole;
	}

	
}
