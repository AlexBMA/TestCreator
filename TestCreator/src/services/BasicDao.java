package services;

import java.util.List;

import org.hibernate.SessionFactory;

public interface BasicDao<E> {
	
	
	public E getItem(SessionFactory factory,int id);
	
	public List<E> getAllItems(SessionFactory factory);
	
	public void editItem();
	
	public void deleteItem(SessionFactory factory, int id);
	
	public void createItem(E item);
	
}
