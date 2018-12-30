package ci.educhome.web.services;

import ci.educhome.web.entities.Niveau;

public interface NiveauService extends Service<Niveau, Integer> {
	public Niveau findNiveauByCode(String code);
	public Niveau findNiveauByLibelle(String libelle);
}
