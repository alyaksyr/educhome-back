package ci.educhome.web.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ci.educhome.web.entities.Eleve;
import ci.educhome.web.execptions.InvalidEduchomeException;
import ci.educhome.web.repositories.EleveRepository;
import ci.educhome.web.services.EleveService;

@Service
public class EleveServiceImpl implements EleveService {
	
	@Autowired
	private EleveRepository eleveRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Eleve creer(Eleve eleve) throws InvalidEduchomeException {
		Eleve user = null;
		try {
			user = eleveRepository.findByEleveLogin(eleve.getLogin());
			if(user!=null) {
				throw new InvalidEduchomeException("Ce login n'est pas disponible !");
		    }
		}catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		try {
			user=eleveRepository.findByEleveByEmail(eleve.getEmail());
			if(user!=null) {
				throw new InvalidEduchomeException("Cette adresse email est déja utilisé par un autre compte");
			}
		} catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890[()-_]/$"; 
	    String pass = "";
	    for(int x=0;x<60;x++)
	    {
	       int i = (int)Math.floor(Math.random() * 70);
	       pass += chars.charAt(i);
	    }
	    try {
			user=eleveRepository.findEleveByKey(pass);
			if(user!=null) {
				throw new InvalidEduchomeException("Une erreur inattendue est survenue !");
			}
		} catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
	    
		String codeUser="";
		for (int i = 0; i < 8; i++) {
			codeUser+=(int) (Math.random()*(10));
		}
		try {
			user=eleveRepository.findEleveByCode(codeUser);
			if(user!=null) {
				throw new InvalidEduchomeException("Une erreur inattendue est survenue !");
			}
		} catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		
		String hshPW = bCryptPasswordEncoder.encode(eleve.getPassword());
		eleve.setPassword(hshPW);
		eleve.setActivation_key(pass);
		eleve.setCode(codeUser);
		return eleveRepository.save(eleve);
	}

	@Override
	public Eleve modifier(Eleve entity) throws InvalidEduchomeException {
		Eleve eleve =null;
		try {
			eleve = eleveRepository.findEleveById(entity.getId());
			if (eleve!=null) {
				if (eleve.getLogin()==entity.getLogin()) {
					throw new InvalidEduchomeException("Vous ne pouvez pas utilisez ce login !");
				}
				if (eleve.getCode_eleve()==entity.getCode_eleve()) {
					throw new InvalidEduchomeException("Ce numéro matricule es déjà utilisé !");
				}
				if (eleve.getCode()==entity.getCode()) {
					throw new InvalidEduchomeException("Veuillez choisir un autre code !");
				}
			}
		} catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		return eleveRepository.save(entity);
	}

	@Override
	public List<Eleve> findAll() {
		return eleveRepository.findAll();
	}

	@Override
	public Eleve findById(Long id) {
		return eleveRepository.findEleveById(id);
	}

	@Override
	public boolean supprimer(Long id) {
		eleveRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean supprimer(List<Eleve> entites) {
		return false;
	}

	@Override
	public boolean existe(Long id) {
		return false;
	}

	@Override
	public List<Eleve> findAllEleveByClasseId(Integer id) {
		return eleveRepository.findAllEleveByClasse(id);
	}

	@Override
	public Eleve findEleveByMatricule(String code) {
		return eleveRepository.findEleveByCode(code);
	}

	@Override
	public Eleve findEleveByLogin(String login) {
		return eleveRepository.findByEleveLogin(login);
	}

	@Override
	public Eleve findEleveByEmail(String email) {
		return eleveRepository.findByEleveByEmail(email);
	}

	@Override
	public List<Eleve> findAllEleveByVilleId(Integer id) {
		return eleveRepository.findAllEleveByVille(id);
	}

	@Override
	public List<Eleve> findAllEleveByPaysId(Integer id) {
		return eleveRepository.findAllEleveByPays(id);
	}

	@Override
	public Eleve findEleveByKey(String key) {
		return eleveRepository.findEleveByKey(key);
	}

	@Override
	public Eleve findEleveByCode(String code) {
		return eleveRepository.findEleveByCode(code);
	}

	@Override
	public Eleve findEleveByMobile(String mobile) {
		return eleveRepository.findEleveByMobile(mobile);
	}

}
