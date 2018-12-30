package ci.educhome.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ci.educhome.web.entities.Niveau;

public interface NiveauRepository extends JpaRepository<Niveau, Integer> {

	// recherche d'une classe via son identifiant
	@Query("select n from Niveau n where n.id =?1")
	Niveau findNiveauById(Integer id);
		
	// Recherche d'une classe par son code
	@Query("select n from Niveau n where n.niveau_code =?1")
	Niveau findNiveauBycode(String code);

	// Recherche d'une classe par son libelle
	@Query("select n from Niveau n where n.niveau_libelle =?1")
	Niveau findNiveauByLibelle(String libelle);
}
