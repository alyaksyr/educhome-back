package ci.educhome.web.entities;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="aqi_roles")
public class Role {
	@Id
	@Column(unique=true, nullable=false, length=2)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(length=60)
	private RoleName name;


	public Role() {
		super();

	}


	public Role(RoleName name) {
		super();
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public RoleName getName() {
		return name;
	}


	public void setName(RoleName name) {
		this.name = name;
	}

	
}
