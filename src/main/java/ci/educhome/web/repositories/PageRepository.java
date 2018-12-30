package ci.educhome.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ci.educhome.web.entities.SitePage;

public interface PageRepository extends JpaRepository<SitePage, Integer> {
	
	// recherche d'un utilisateur via son identifiant
	@Query("select sp from SitePage sp where sp.id =?1")
	SitePage findPageById(Integer id);
	
	// Recherche d'une page par son code
	@Query("select sp from SitePage sp where sp.page_code =?1")
	SitePage findByPageCode(String code);

}
