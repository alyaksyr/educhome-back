package ci.educhome.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ci.educhome.web.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	// rechercher des profiles par la fonction
	@Query("select p from Profile p left join fetch p.fonction pf where pf.id =?1")
	List<Profile> findAllProfileByFonction(Integer id);
	
	// rechercher des profiles par la ville
	@Query("select p from Profile p inner join fetch p.ville pv where pv.id =?1")
	List<Profile> findAllProfileByVille(Integer id);
	
	// rechercher un profile par son identifiant
	@Query("select p from Profile p where p.id =?1")
	Profile findProfileById(Integer id);
		
	// rechercher un profile par son nom
	@Query("select p from Profile p where p.nom =?1")
	Profile findProfileByNom(String nom);
}
