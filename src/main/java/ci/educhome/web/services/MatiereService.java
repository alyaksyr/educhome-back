package ci.educhome.web.services;

import java.util.List;

import ci.educhome.web.entities.Matiere;

public interface MatiereService extends Service<Matiere, Integer> {
   public Matiere findByCode(String code);
   public Matiere findByLibelle(String libelle);
   public List<Matiere> findAllMatiereByNiveau(Integer idNiveau);
}
