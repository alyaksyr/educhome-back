package ci.educhome.web.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ci.educhome.web.entities.Niveau;
import ci.educhome.web.execptions.InvalidEduchomeException;
import ci.educhome.web.repositories.NiveauRepository;
import ci.educhome.web.services.NiveauService;

public class NiveauServiceImpl implements NiveauService {
	
	@Autowired
	private NiveauRepository niveauRepository;
	
	@Override
	public Niveau creer(Niveau entity) throws InvalidEduchomeException {
		if (entity.getNiveau_code()==null || entity.getNiveau_code()=="") {
			throw new InvalidEduchomeException("Le code de la classe ne peut etre vide !");
		}
		Niveau niveau = niveauRepository.findNiveauBycode(entity.getNiveau_code());
		if(niveau!=null) {
			throw new InvalidEduchomeException("Cette classe existe déjà !");
		}
		if (entity.getNiveau_libelle()==null || entity.getNiveau_libelle()=="") {
			throw new InvalidEduchomeException("Le libellé de la classe ne peut etre vide !");
		}
		Niveau niveaux = niveauRepository.findNiveauByLibelle(entity.getNiveau_libelle());
		if(niveaux!=null) {
			throw new InvalidEduchomeException("Cette classe existe déjà !");
		}
		return niveauRepository.save(entity);
	}

	@Override
	public Niveau modifier(Niveau entity) throws InvalidEduchomeException {
		Niveau niveau = null;
		try {
			niveau=niveauRepository.findNiveauBycode(entity.getNiveau_code());
			if (niveau!=null) {
				throw new InvalidEduchomeException("Cet code existe deja pour une classe!");
			}
		} catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		try {
			niveau=niveauRepository.findNiveauBycode(entity.getNiveau_libelle());
			if (niveau!=null) {
				throw new InvalidEduchomeException("Cet libellé existe deja pour une classe!");
			}
		} catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		return niveauRepository.save(entity);
	}

	@Override
	public List<Niveau> findAll() {

		return niveauRepository.findAll();
	}

	@Override
	public Niveau findById(Integer id) {
		
		return niveauRepository.findNiveauById(id);
	}

	@Override
	public boolean supprimer(Integer id) {
		niveauRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean supprimer(List<Niveau> entites) {
		return false;
	}

	@Override
	public boolean existe(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Niveau findNiveauByCode(String code) {
		return niveauRepository.findNiveauBycode(code);
	}

	@Override
	public Niveau findNiveauByLibelle(String libelle) {
		return niveauRepository.findNiveauByLibelle(libelle);
	}

}
