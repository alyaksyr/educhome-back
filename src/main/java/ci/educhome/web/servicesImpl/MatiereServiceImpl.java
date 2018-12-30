package ci.educhome.web.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ci.educhome.web.entities.Matiere;
import ci.educhome.web.execptions.InvalidEduchomeException;
import ci.educhome.web.repositories.MatiereRepository;
import ci.educhome.web.services.MatiereService;

public class MatiereServiceImpl implements MatiereService {
	
	@Autowired
	MatiereRepository matiereRepository;

	@Override
	public Matiere creer(Matiere entity) throws InvalidEduchomeException {
		if (entity.getMatiere_code()==null || entity.getMatiere_code()=="") {
			throw new InvalidEduchomeException("Le code ne peut etre vide !");
		}
		Matiere matiere = matiereRepository.findByCodeMatiere(entity.getMatiere_code());
		if(matiere!=null) {
			throw new InvalidEduchomeException("Cette matiere existe déjà !");
		}
		if (entity.getMatiere_libelle()==null || entity.getMatiere_libelle()=="") {
			throw new InvalidEduchomeException("Le libellé ne peut etre vide !");
		}
		Matiere matieres = matiereRepository.findByLibelleMatiere(entity.getMatiere_libelle());
		if(matieres!=null) {
			throw new InvalidEduchomeException("Cette matière existe déjà !");
		}
		return matiereRepository.save(entity);
	}

	@Override
	public Matiere modifier(Matiere entity) throws InvalidEduchomeException {
		Matiere matiere = null;
		try {
			matiere=matiereRepository.findByCodeMatiere(entity.getMatiere_code());
			if (matiere!=null) {
				throw new InvalidEduchomeException("Cet code existe deja pour une matiere!");
			}
		} catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		try {
			matiere=matiereRepository.findByLibelleMatiere(entity.getMatiere_libelle());
			if (matiere!=null) {
				throw new InvalidEduchomeException("Cet libellé existe deja pour une classe!");
			}
		} catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		return matiereRepository.save(entity);
	}

	@Override
	public List<Matiere> findAll() {
		return matiereRepository.findAll();
	}

	@Override
	public Matiere findById(Integer id) {
		return matiereRepository.findByIdMatiere(id);
	}

	@Override
	public boolean supprimer(Integer id) {
		matiereRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean supprimer(List<Matiere> entites) {
		return false;
	}

	@Override
	public boolean existe(Integer id) {
		return false;
	}

	@Override
	public Matiere findByCode(String code) {
		return matiereRepository.findByCodeMatiere(code);
	}

	@Override
	public Matiere findByLibelle(String libelle) {
		return matiereRepository.findByLibelleMatiere(libelle);
	}

	@Override
	public List<Matiere> findAllMatiereByNiveau(Integer idNiveau) {
		return matiereRepository.findByIdNiveau(idNiveau);
	}

}
