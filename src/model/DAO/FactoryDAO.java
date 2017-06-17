package model.DAO;

import java.awt.List;

public interface FactoryDAO <T>{
	public void insert(Object obj);
	public void update(Object obj);
	public List findAll(Class<?> classe);
}
