package ci.educhome.web.controllers;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ci.educhome.web.entities.Users;
import ci.educhome.web.execptions.InvalidEduchomeException;
import ci.educhome.web.models.Reponse;
import ci.educhome.web.models.Static;
import ci.educhome.web.services.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController{
	@Autowired
	private UserService userService;

	@Autowired
	private ObjectMapper jsonMapper;
	
	
	@PostMapping("/ajouterUnUser")
	public String creer(@RequestBody Users user) throws JsonProcessingException {
		Reponse<Users> reponse = null;
		try {
			Users usr = userService.creer(user);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été créé avec succes !",usr.getLogin()));
			reponse = new Reponse<Users>(0,messages,usr);
		} catch (InvalidEduchomeException e) {
			reponse = new Reponse<Users>(1,Static.getErreursForException(e),null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}
	
	@PutMapping("/updateUser")
	public String modifier(@RequestBody Users user) throws JsonProcessingException {
		Reponse<Users> reponse =null;
		try {
			Users usr = userService.modifier(user);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été modifié avec succes !",usr.getLogin()));
			reponse = new Reponse<Users>(0,messages,usr);
		} catch (InvalidEduchomeException e) {
			reponse = new Reponse<Users>(1,Static.getErreursForException(e),null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}

	@GetMapping("/allUsers")
	public List<Users> findAll() {
		return userService.findAll();
	}

	@GetMapping("/userById/{id}")
	public Users findById(@PathVariable Long id) {
		return userService.findUserById(id);
	}

	public boolean supprimer(Long id) {
		return userService.supprimer(id);
	}

	public boolean supprimer(List<Users> entites) {
		return userService.supprimer(entites);
	}

	public boolean existe(Long id) {
		return userService.existe(id);
	}
	@GetMapping("/userByLogin/{login}")
	public Users findByUserLogin(@PathVariable String login) {
		return userService.findUserByLogin(login);
	}
	@GetMapping("/userByRoleId/{id}")
	public List<Users> findAllUserByRoleId(@PathVariable Long id) {
		return userService.findAllUserByRoleId(id);
	}

	@GetMapping("/userByCode/{code}")
	public Users findByUserCode(@PathVariable Integer code) {
		return userService.findByUserCode(code);
	}
	
	
}