package ci.educhome.web.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.educhome.web.entities.Role;
import ci.educhome.web.entities.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName roleName);
}
