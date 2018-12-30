package ci.educhome.web.services;

import java.util.List;

import ci.educhome.web.execptions.InvalidEduchomeException;

public interface Service<T, U> {
	
	public T creer(T entity) throws InvalidEduchomeException;
	
	public T modifier(T entity) throws InvalidEduchomeException ;
	
	public List<T> findAll();
	
	public T findById(U id);

	public boolean supprimer(U id);
	
	public boolean supprimer(List<T> entites);
	
	public boolean existe(U id);
	

}
