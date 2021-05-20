package co.edu.ufps.huelleritos.util;

import java.util.*;

public interface GenericDAO<T> {
	
	public List<T> list();
	public <E> T find(E id);
	public void insert(T obj);
	public void update(T obj);
	public void delete(T obj);

}
