package ci.educhome.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ci.educhome.web.entities.Users;

public interface UserRepository extends  JpaRepository<Users, Long>{
	// recherche d'un utilisateur via son login
	@Query("select u from Users u where u.login =?1")
	Users findByUserLogin(String login);
	
	// recherche d'un utilisateur via son identifiant
	@Query("select u from Users u where u.id =?1")
	Users findUserById(Long id);
	
	// recherche d'un utilisateur via son code
	@Query("select u from Users u where u.code =?1")
	Users findByUserCode(long code);
	
	// recherche d'un utilisateur par son adresse email
	@Query("select u from Users u where u.email =?1")
	Users findByUserEmail(String email);
	
	
}