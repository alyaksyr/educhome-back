package ci.educhome.web.services;

import java.util.List;

import ci.educhome.web.entities.Profile;

public interface ProfileService extends Service<Profile, Integer> {
	    
	public List<Profile> findAllProfileByVille(Integer id);
	
	public List<Profile> findAllProfileByFonction(Integer id);
	
	public Profile findProfileById(Integer id);
		
	public Profile findProfileByNom(String nom);

}
