package ci.educhome.web.services;

import java.util.List;

import ci.educhome.web.entities.Users;

public interface UserService extends Service<Users, Long>{

	public Users findUserByLogin(String login);
	
	public Users findUserById(Long id);
	
	public List<Users> findAllUserByRoleId(Long id);
	
	public Users findByUserCode(Integer code);
	
	public Users findByUserMail(String email);
	
}
