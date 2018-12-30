package ci.educhome.web.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ci.educhome.web.entities.Profile;
import ci.educhome.web.entities.Users;
import ci.educhome.web.execptions.InvalidEduchomeException;
import ci.educhome.web.repositories.ProfileRepository;
import ci.educhome.web.repositories.UserRepository;
import ci.educhome.web.services.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Profile creer(Profile profile) throws InvalidEduchomeException{
		Users user = null;
		try {
			user = userRepository.findByUserLogin(profile.getLogin());
		}catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		if(user!=null)
			throw new InvalidEduchomeException("Ce login n'est pas disponible !");
		
		try {
			user = userRepository.findByUserEmail(profile.getEmail());
		}catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		if(user!=null)
			throw new InvalidEduchomeException("Cet email est déjà utilisé !");

		String hshPW = bCryptPasswordEncoder.encode(profile.getPassword());
		profile.setPassword(hshPW);
		return profileRepository.save(profile);
	}

	@Override
	public Profile modifier(Profile profile) {
		return profileRepository.save(profile);
	}

	@Override
	public List<Profile> findAll() {
		return profileRepository.findAll();
	}

	@Override
	public Profile findById(Integer id) {
		return profileRepository.getOne(id);
	}

	@Override
	public boolean supprimer(Integer id) {
		return false;
	}

	@Override
	public boolean supprimer(List<Profile> profile) {
		return false;
	}

	@Override
	public boolean existe(Integer id) {
		return false;
	}

	@Override
	public List<Profile> findAllProfileByVille(Integer id) {
		return profileRepository.findAllProfileByVille(id);
	}

	@Override
	public Profile findProfileByNom(String nom) {
		return profileRepository.findProfileByNom(nom);
	}

	@Override
	public List<Profile> findAllProfileByFonction(Integer id) {
		return profileRepository.findAllProfileByFonction(id);
	}

	@Override
	public Profile findProfileById(Integer id) {
		return profileRepository.findProfileById(id);
	}

}
