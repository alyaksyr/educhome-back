package ci.educhome.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ci.educhome.web.entities.Niveau;
import ci.educhome.web.execptions.InvalidEduchomeException;
import ci.educhome.web.models.Reponse;
import ci.educhome.web.models.Static;
import ci.educhome.web.services.NiveauService;

public class NiveauController {
	@Autowired
	NiveauService niveauService;
	
	@Autowired
	private ObjectMapper jsonMapper;

	/*
	 * 
	 */
	@GetMapping("/niveaux/{code}")
	public String findNiveauByCode(@PathVariable String code) throws JsonProcessingException {
		Reponse<Niveau> reponse = null;
		try {
			Niveau niveau =niveauService.findNiveauByCode(code);
			if (niveau==null) {
				List<String> messages = new ArrayList<>();
				messages.add(String.format("La classe demandée n'esiste pas !", niveau));
				reponse = new Reponse<Niveau>(2,messages,null);
			}
			reponse=new Reponse<Niveau>(0,null,niveau);
		} catch (RuntimeException e) {
			reponse=new Reponse<Niveau>(1,Static.getErreursForException(e),null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}

	/*
	 *  
	 */
	@PostMapping("/niveaux")
	public String ajouterNiveau(@RequestBody Niveau entity) throws JsonProcessingException {
		Reponse<Niveau> reponse = null;
		try {
			Niveau niveau = niveauService.creer(entity);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été créé avec succes !",niveau.getNiveau_libelle()));
			reponse = new Reponse<Niveau>(0,messages,niveau);
		} catch (InvalidEduchomeException e) {
			reponse = new Reponse<Niveau>(1,Static.getErreursForException(e),null);
		}
		
		return jsonMapper.writeValueAsString(reponse);
	}

	/*
	 * recherche de la classe par libelle
	 */
	@GetMapping("/niveaux/{libelle}")
	public String findNiveauByLibelle(@PathVariable String libelle) throws JsonProcessingException {
		Reponse<Niveau> reponse = null;
		try {
			Niveau niveau =niveauService.findNiveauByLibelle(libelle);
			if (niveau==null) {
				List<String> messages = new ArrayList<>();
				messages.add(String.format("La classe demandée n'esiste pas !", niveau));
				reponse = new Reponse<Niveau>(2,messages,null);
			}
			reponse=new Reponse<Niveau>(0,null,niveau);
		} catch (RuntimeException e) {
			reponse=new Reponse<Niveau>(1,Static.getErreursForException(e),null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}

	/*
	 * Modifier un niveau
	 */
	@PutMapping("/niveaux")
	public String modifier(@RequestBody Niveau entity) throws JsonProcessingException {
		Reponse<Niveau> reponse = null;
		try {
			Niveau niveau = niveauService.modifier(entity);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été modifié avec succes !",niveau.getNiveau_libelle()));
			reponse = new Reponse<Niveau>(0,messages,niveau);
		} catch (InvalidEduchomeException e) {
			reponse = new Reponse<Niveau>(1,Static.getErreursForException(e),null);
		}
		
		return jsonMapper.writeValueAsString(reponse);
	}

	@GetMapping("/niveaux")
	public String findAll() throws JsonProcessingException {
		Reponse<List<Niveau>> reponse=null;
		try {
			List<Niveau> niveaux =niveauService.findAll();
			reponse= new Reponse<List<Niveau>>(0,null, niveaux);
		} catch (Exception e) {
			reponse = new Reponse<>(1, Static.getErreursForException(e), null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}

	@GetMapping("/niveaux/{id}")
	public String findById(@PathVariable Integer id) throws JsonProcessingException {
		Reponse<Niveau> reponse = null;
		try {
			Niveau niveau =niveauService.findById(id);
			if (niveau==null) {
				List<String> messages = new ArrayList<>();
				messages.add(String.format("La classe demandée n'esiste pas !", niveau));
				reponse = new Reponse<Niveau>(2,messages,null);
			}
			reponse=new Reponse<Niveau>(0,null,niveau);
		} catch (RuntimeException e) {
			reponse=new Reponse<Niveau>(1,Static.getErreursForException(e),null);
		}
		return jsonMapper.writeValueAsString(reponse); 
	}

	@DeleteMapping("/niveaux/{id}")
	public String supprimer(@PathVariable Integer id) throws JsonProcessingException {
		Reponse<Boolean> reponse=null;
		try {
			Niveau niveau =niveauService.findById(id);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("La classe %s a été supprimé avec succès", niveau.getNiveau_libelle()));
			reponse = new Reponse<Boolean>(0,messages,niveauService.supprimer(id));
		} catch (RuntimeException e) {
			reponse=new Reponse<Boolean>(1,Static.getErreursForException(e),null);
		}
		return jsonMapper.writeValueAsString(reponse); 
	}

	public boolean supprimer(List<Niveau> entites) {
		return niveauService.supprimer(entites);
	}

	public boolean existe(Integer id) {
		return niveauService.existe(id);
	}

	
}
