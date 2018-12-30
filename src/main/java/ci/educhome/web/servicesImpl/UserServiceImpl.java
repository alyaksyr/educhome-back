package ci.educhome.web.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ci.educhome.web.entities.Users;
import ci.educhome.web.execptions.InvalidEduchomeException;
import ci.educhome.web.repositories.UserRepository;
import ci.educhome.web.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Users creer(Users user) throws InvalidEduchomeException {
		Users usr = null;
		try {
			usr = userRepository.findByUserLogin(user.getLogin());
		}catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		if(usr!=null)
			throw new InvalidEduchomeException("Ce login n'est pas disponible !");
		
		try {
			usr = userRepository.findByUserEmail(user.getEmail());
		}catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		if(usr!=null)
			throw new InvalidEduchomeException("Cet email est déjà utilisé !");

		String hshPW = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hshPW);
		return userRepository.save(user);
	}

	@Override
	public Users modifier(Users user) throws InvalidEduchomeException {
		Users usr = userRepository.findUserById(user.getId());
		if(usr!=null) {
			if(usr.getCode()==user.getCode()) {
				throw new InvalidEduchomeException("Vous ne pouvez pas utiliser ce code !");
			}
			if(usr.getEmail()==user.getEmail()) {
				throw new InvalidEduchomeException("Vous ne pouvez pas utiliser cet email");
			}
			if(usr.getLogin()==user.getLogin()) {
				throw new InvalidEduchomeException("Vous ne pouvez pas utiliser ce login");
			}
		}
		
		return userRepository.save(user);
	}

	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Users findById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public boolean supprimer(Long id) {
		userRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean supprimer(List<Users> user) {
		return false;
	}

	@Override
	public boolean existe(Long id) {
		return userRepository.existsById(id);
	}

	@Override
	public Users findUserByLogin(String login) {
		return userRepository.findByUserLogin(login);
	}

	@Override
	public Users findUserById(Long id) {
		return userRepository.findUserById(id);
	}

	/*@Override
	public List<Users> findAllUserByRoleId(Long id){
		return userRepository.findAllUserByRoleId(id);
	}*/

	@Override
	public Users findByUserCode(Integer code) {
		return userRepository.findByUserCode(code);
	}

	@Override
	public Users findByUserMail(String email) {
		return userRepository.findByUserEmail(email);
	}

	@Override
	public List<Users> findAllUserByRoleId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
