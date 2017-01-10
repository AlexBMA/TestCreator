package services;

import java.util.List;

import org.hibernate.SessionFactory;

public interface BasicService<E> {
	
	
	public E getItem(SessionFactory factory,int id);
	
	public List<E> getAllItems(SessionFactory factory);
	
	public List<E> getSimilarItems(SessionFactory factory,int idSimilar);
	
	public void editItem(SessionFactory factory);
	
	public void deleteItem(SessionFactory factory, int id);
	
	public void createItem(SessionFactory factory,E item);
	
}
