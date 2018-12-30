package ci.educhome.web.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.educhome.web.entities.SitePage;
import ci.educhome.web.execptions.InvalidEduchomeException;
import ci.educhome.web.repositories.PageRepository;
import ci.educhome.web.services.SitePageService;

@Service
public class SitePageServiceImpl implements SitePageService {
	
	@Autowired
	private PageRepository pageRepository;

	@Override
	public SitePage creer(SitePage entity) throws InvalidEduchomeException {
		if(entity.getPage_code()==null || entity.getPage_code()=="") {
			throw new InvalidEduchomeException("Cet champ ne peut pas etre vide !");
		}
		SitePage page=null;
		page= pageRepository.findByPageCode(entity.getPage_code());
		if(page!=null) {
			throw new InvalidEduchomeException("Cette page existe déja !");
		}
		return pageRepository.save(entity);
	}

	@Override
	public SitePage modifier(SitePage entity) throws InvalidEduchomeException {
		SitePage page = null;
		try {
			page = pageRepository.findPageById(entity.getId());
			if (page!=null) {
				if (page.getPage_code()==entity.getPage_code()) {
					throw new InvalidEduchomeException("Vous ne pouvez pas utiliser ce code !");
				}
			}
		} catch (Exception e) {
			throw new InvalidEduchomeException("Problème de connexion !");
		}
		
		return pageRepository.save(entity);
	}

	@Override
	public List<SitePage> findAll() {
		return pageRepository.findAll();
	}

	@Override
	public SitePage findById(Integer id) {
		return pageRepository.findPageById(id);
	}

	@Override
	public boolean supprimer(Integer id) {
		pageRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean supprimer(List<SitePage> entites) {
		return false;
	}

	@Override
	public boolean existe(Integer id) {
		return false;
	}

	@Override
	public SitePage findByPageCode(String code) {
		return pageRepository.findByPageCode(code);
	}

}
