package ci.educhome.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ci.educhome.web.entities.Profile;
import ci.educhome.web.execptions.InvalidEduchomeException;
import ci.educhome.web.models.Reponse;
import ci.educhome.web.models.Static;
import ci.educhome.web.services.ProfileService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	private ObjectMapper jsonMapper;

	@PostMapping("/profiles")
	public String register(@RequestBody Profile profile) throws JsonProcessingException {
		Reponse<Profile> reponse = null;
		try {
			Profile profil = profileService.creer(profile);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été créé avec succes !",profil.getLogin()));
			reponse = new Reponse<Profile>(0,messages,profil);
		} catch (InvalidEduchomeException e) {
			reponse = new Reponse<Profile>(1,Static.getErreursForException(e),null);
		}
		
		return jsonMapper.writeValueAsString(reponse);
	}

	@PutMapping("/profiles")
	public Profile modifier(Profile profile) throws InvalidEduchomeException {
		return profileService.modifier(profile);
	}

	public List<Profile> findAll() {
		return profileService.findAll();
	}

	@GetMapping("/listeProfileByVilleId/{id}")
	public List<Profile> findAllProfileByVille(@PathVariable Integer id) {
		return profileService.findAllProfileByVille(id);
	}

	@GetMapping("/listeProfileByFonctionId/{id}")
	public List<Profile> findAllProfileByFonction(@PathVariable Integer id) {
		return profileService.findAllProfileByFonction(id);
	}

	@GetMapping("/profiles/{id}")
	public Profile findProfileById(@PathVariable Integer id) {
		return profileService.findProfileById(id);
	}

	public boolean supprimer(Integer id) {
		return false;
	}

	@GetMapping("/profiles/{nom}")
	public Profile findProfileByNom(@PathVariable String nom) {
		return profileService.findProfileByNom(nom);
	}

	public boolean supprimer(List<Profile> profile) {
		return profileService.supprimer(profile);
	}

	public boolean existe(Integer id) {
		return false;
	}
	
	
}
