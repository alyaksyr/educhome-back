package ci.educhome.web.services;

import java.util.List;

import ci.educhome.web.entities.Ecole;

public interface EcoleService extends Service<Ecole, Integer> {
	
	public List<Ecole> findByVilleId(Integer idVille);
	public List<Ecole> findByVilleIdAndTypeEcole(Integer idType,Integer idVille);
	public List<Ecole> findByTypeEcoleType(Integer idType);
	public List<Ecole> findByVilleIdAndStatutEcole(Integer idStatut,Integer idVille);
	public List<Ecole> findByTypeEcoleStatut(Integer idStatut);
	public List<Ecole> findByTypeAndStatut(Integer idStatut,Integer idType);
	public List<Ecole> findByVilleIdAndStatutAndType(Integer idStatut,Integer idVille,Integer idType);

}
