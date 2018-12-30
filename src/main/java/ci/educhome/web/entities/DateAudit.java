package ci.educhome.web.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"registred", "modified"},allowGetters = true)
public abstract class DateAudit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@CreatedDate
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date registred; //Date d'ajout du membre
	
	@LastModifiedDate
	@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date modified; //Date de la dernière modification

	public Date getRegistred() {
		return registred;
	}

	public void setRegistred(Date registred) {
		this.registred = registred;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
	
	
}
