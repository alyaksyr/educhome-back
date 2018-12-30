package ci.educhome.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ci.educhome.web.entities.Eleve;
import ci.educhome.web.execptions.InvalidEduchomeException;
import ci.educhome.web.models.Reponse;
import ci.educhome.web.models.Static;
import ci.educhome.web.services.EleveService;

@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
@RestController
public class EleveController {
	@Autowired
	private EleveService eleveService;
	
	@Autowired
	private ObjectMapper jsonMapper;

	@PostMapping("/eleves")
	public String register(@RequestBody Eleve eleve) throws JsonProcessingException {
		Reponse<Eleve> reponse = null;
		try {
			Eleve elev = eleveService.creer(eleve);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été créé avec succes !",elev.getLogin()));
			reponse = new Reponse<Eleve>(0,messages,elev);
		} catch (InvalidEduchomeException e) {
			reponse = new Reponse<Eleve>(1,Static.getErreursForException(e),null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}

	//Modifier un eleve 
	@PutMapping("/eleves")
	public String modifier(@PathVariable Eleve entity) throws JsonProcessingException {
		Reponse<Eleve> reponse = null;
		try {
			Eleve eleve = eleveService.modifier(entity);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("La page %s  a été modifié avec succes",eleve.getCode_eleve()));
			reponse = new Reponse<Eleve>(0,messages,eleve);
		} catch (Exception e) {
			reponse = new Reponse<Eleve>(1,Static.getErreursForException(e),null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}

	@GetMapping("/eleves")
	public List<Eleve> findAll() {
		return eleveService.findAll();
	}

	@GetMapping("/listeEleveByClasseId/{id}")
	public List<Eleve> findAllEleveByClasse(@PathVariable Integer id) {
		return eleveService.findAllEleveByClasseId(id);
	}

	public Eleve findById(Long id) {
		return eleveService.findById(id);
	}

	public boolean supprimer(Long id) {
		return eleveService.supprimer(id);
	}

	public boolean supprimer(List<Eleve> entites) {
		return eleveService.supprimer(entites);
	}

	public boolean existe(Long id) {
		return eleveService.existe(id);
	}
	
	
}
