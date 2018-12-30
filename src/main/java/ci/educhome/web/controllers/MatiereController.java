package ci.educhome.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ci.educhome.web.entities.Matiere;
import ci.educhome.web.execptions.InvalidEduchomeException;
import ci.educhome.web.models.Reponse;
import ci.educhome.web.models.Static;
import ci.educhome.web.services.MatiereService;

public class MatiereController {
	
	@Autowired
	MatiereService matiereService;
	
	@Autowired
	private ObjectMapper jsonMapper;

	@PostMapping("/matieres")
	public String creer(Matiere entity) throws InvalidEduchomeException, JsonProcessingException {
		Reponse<Matiere> reponse=null;
		try {
			Matiere matiere = matiereService.creer(entity); 
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été créé avec succes !",matiere.getMatiere_libelle()));
			reponse= new Reponse<Matiere>(0,messages,matiere);
		} catch (RuntimeException e) {
			reponse = new Reponse<Matiere>(1,Static.getErreursForException(e),null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}

	public String findByCode(String code) throws JsonProcessingException {
		Reponse<Matiere> reponse=null;
		try {
			Matiere matiere = matiereService.findByCode(code);
			if(matiere==null) {
				List<String> messages = new ArrayList<>();
				messages.add(String.format("La matière demandée n'existe pas!",matiere));
				reponse= new Reponse<Matiere>(2,messages,null);
			}
			reponse= new Reponse<Matiere>(0,null,matiere);
		} catch (RuntimeException e) {
			reponse = new Reponse<Matiere>(1,Static.getErreursForException(e),null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}

	public Matiere findByLibelle(String libelle) {
		return matiereService.findByLibelle(libelle);
	}

	public Matiere modifier(Matiere entity) throws InvalidEduchomeException {
		return matiereService.modifier(entity);
	}

	public List<Matiere> findAllMatiereByNiveau(Integer idNiveau) {
		return matiereService.findAllMatiereByNiveau(idNiveau);
	}

	public List<Matiere> findAll() {
		return matiereService.findAll();
	}

	public Matiere findById(Integer id) {
		return matiereService.findById(id);
	}

	public boolean supprimer(Integer id) {
		return matiereService.supprimer(id);
	}

	public boolean supprimer(List<Matiere> entites) {
		return matiereService.supprimer(entites);
	}

	public boolean existe(Integer id) {
		return matiereService.existe(id);
	}
	
	

}
