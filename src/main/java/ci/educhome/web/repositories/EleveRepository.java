package ci.educhome.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ci.educhome.web.entities.Eleve;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Long>{
	// recherche d'un utilisateur via son identifiant
	@Query("select u from Eleve u where u.id =?1")
	Eleve findEleveById(Long id);
		
	// recherche d'un utilisateur via son login
	@Query("select u from Eleve u where u.login =?1")
	Eleve findByEleveLogin(String login);
	
	// recherche d'un utilisateur via son email
	@Query("select u from Eleve u where u.email =?1")
	Eleve findByEleveByEmail(String email);
		
	// rechercher des eleves par la classe
	@Query("select e from Eleve e left join fetch e.niveau en where en.id =?1")
	List<Eleve> findAllEleveByClasse(Integer id);
	
	// rechercher des eleves par la ville
	@Query("select e from Eleve e left join fetch e.ville ev where ev.id =?1")
	List<Eleve> findAllEleveByVille(Integer id);
	
	// rechercher des eleves par un pays
	@Query("select e from Eleve e left join fetch e.pays ep where ep.id =?1")
	List<Eleve> findAllEleveByPays(Integer id);
	
	// rechercher un eleve par son code unique
	@Query("select e from Eleve e where e.code =?1")
	Eleve findEleveByCode(String code);
	
	// rechercher un eleve par son numero de telephone
	@Query("select e from Eleve e where e.adresse.mobile =?1")
	Eleve findEleveByMobile(String mobile);
	
	// rechercher un eleve par sa clé d'activation
	@Query("select e from Eleve e where e.activation_key =?1")
	Eleve findEleveByKey(String key);
	
	// rechercher un eleve par son numéro de matricule
	@Query("select e from Eleve e where e.code_eleve =?1")
	Eleve findEleveByMatricule(String matricule);

}
