package ci.educhome.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ci.educhome.web.entities.SitePage;
import ci.educhome.web.execptions.InvalidEduchomeException;
import ci.educhome.web.models.Reponse;
import ci.educhome.web.models.Static;
import ci.educhome.web.services.SitePageService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PageController {
	
	@Autowired
	SitePageService sitePageService;
	
	@Autowired
	private ObjectMapper jsonMapper;

	@PostMapping("/pages")
	public String creer(@RequestBody SitePage page) throws JsonProcessingException{
		Reponse<SitePage> reponse;
		try {
			SitePage pag =sitePageService.creer(page);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("La page %s  a été créé avec succes", pag.getPage_title()));
			reponse = new Reponse<SitePage>(0, messages, pag);
			
		} catch (Exception e) {
			reponse = new Reponse<SitePage>(1, Static.getErreursForException(e), null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}

	@PutMapping("/pages")
	public String modifier(@RequestBody SitePage page) throws JsonProcessingException {
		Reponse<SitePage> reponse=null;
		try {
			SitePage pag = sitePageService.modifier(page);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("La page %s  a été modifié avec succes", pag.getPage_title()));
			reponse = new Reponse<SitePage>(0, messages, pag);
		} catch (Exception e) {
			reponse = new Reponse<SitePage>(1, Static.getErreursForException(e), null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}

	@GetMapping("/pages")
	public String findAll() throws JsonProcessingException,InvalidEduchomeException {
		Reponse<List<SitePage>> reponse=null;
		try {
			List<SitePage> pages= sitePageService.findAll();
			reponse= new Reponse<List<SitePage>>(0,null,pages);
		} catch (Exception e) {
			reponse = new Reponse<>(1, Static.getErreursForException(e), null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}
/*
	@GetMapping("/pages/{id}")
	public String findById(@PathVariable Integer id) throws JsonProcessingException{
		Reponse<SitePage> reponse=null;
		try {
			SitePage page = sitePageService.findById(id);
			if(page==null) {
				List<String> messages = new ArrayList<>();
				messages.add(String.format("La page demandée n'esiste pas !", page));
				reponse = new Reponse<SitePage>(2,messages,null);
			}
			reponse=new Reponse<SitePage>(0,null,page);
		} catch (RuntimeException e) {
			reponse = new Reponse<SitePage>(1, Static.getErreursForException(e),null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}
    
*/
	@DeleteMapping("/page/{id}")
	public String supprimer(@PathVariable Integer id) throws JsonProcessingException {
		Reponse<Boolean> reponse=null;
		try {
			SitePage page = sitePageService.findById(id);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("La page %s a été supprimé avec succès", page.getPage_code()));
			reponse = new Reponse<Boolean>(0,messages,sitePageService.supprimer(id));
		} catch (RuntimeException e) {
			reponse = new Reponse<>(1, Static.getErreursForException(e), null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}

	public boolean supprimer(List<SitePage> entites) {
		return sitePageService.supprimer(entites);
	}

	public boolean existe(Integer id) {
		return sitePageService.existe(id);
	}
/*
	@GetMapping("/pages/{code}")
	public String findByPageCode(@PathVariable String code) throws JsonProcessingException{
		Reponse<SitePage> reponse=null;
		try {
			SitePage page = sitePageService.findByPageCode(code);
			if(page==null) {
				List<String> messages = new ArrayList<>();
				messages.add(String.format("La page demandée n'esiste pas !", page));
				reponse = new Reponse<SitePage>(2,messages,null);
			}
			reponse=new Reponse<SitePage>(0,null,page);
		} catch (RuntimeException e) {
			reponse = new Reponse<SitePage>(1, Static.getErreursForException(e),null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}	
	
*/

	@GetMapping("/pages/{code}")
	public SitePage findByPageCode(@PathVariable String code) {
		return sitePageService.findByPageCode(code);
	}

	@GetMapping("/page/{id}")
	public SitePage findById(@PathVariable Integer id) {
		return sitePageService.findById(id);
	}
	
}
