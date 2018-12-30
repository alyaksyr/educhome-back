package ci.educhome.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ci.educhome.web.entities.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Integer> {
	
	// Recuperer une matière par son identifiant
	@Query("select m from Matiere m where m.id=?1")
	Matiere findByIdMatiere(Integer id);
	
	// Recuperer une matière par son code
	@Query("select m from Matiere m where m.matiere_code=?1")
	Matiere findByCodeMatiere(String code);
	
	// Recuperer une matière par son libelle
	@Query("select m from Matiere m where m.matiere_libelle=?1")
	Matiere findByLibelleMatiere(String libelle);
	
	// Recuperer toutes les  matière d'une classe
	@Query("select m from Matiere m left join fetch m.niveau mn where mn.id=?1")
	List<Matiere> findByIdNiveau(Integer id);
}
