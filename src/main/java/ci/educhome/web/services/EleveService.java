package ci.educhome.web.services;

import java.util.List;

import ci.educhome.web.entities.Eleve;

public interface EleveService extends Service<Eleve, Long> {
	
	public List<Eleve> findAllEleveByClasseId(Integer id);
	public List<Eleve> findAllEleveByVilleId(Integer id);
	public List<Eleve> findAllEleveByPaysId(Integer id);
	public Eleve findEleveByMatricule(String matricule);
	public Eleve findEleveByKey(String key);
	public Eleve findEleveByCode(String code);
	public Eleve findEleveByLogin(String login);
	public Eleve findEleveByEmail(String email);
	public Eleve findEleveByMobile(String mobile);
	
}
