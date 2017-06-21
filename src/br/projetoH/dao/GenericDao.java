package br.projetoH.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class GenericDao<T extends Serializable>{
	
	@PersistenceContext(unitName = "agenda")
	protected
    final EntityManager entityManager; //conexao com bd
    private final Class<T> persistentClass;
    
    public GenericDao() {
        this.entityManager = EntityManagerUtil.getEntityManager();
        this.persistentClass = (Class<T>) ((ParameterizedType) 
			getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
   
	public EntityManager getEntityManager(){
    	return entityManager;
    }
    
    protected void save(T entity){
    	EntityTransaction tx = getEntityManager().getTransaction();
    	
    	try{
    		tx.begin();
    		getEntityManager().persist(entity); //pega o bd
    		tx.commit(); //comita
    	}catch(Throwable t){
    		t.printStackTrace();
    		tx.rollback();
    	}finally{
    		close();//fecha bd
    	}
    }
    
    protected void update(T entity){
    	EntityTransaction tx = getEntityManager().getTransaction();
    	
    	try{
    		tx.begin();
    		getEntityManager().merge(entity);
    		tx.commit();
    	}catch(Throwable t){
    		t.printStackTrace();
    		tx.rollback();
    	}finally{
    		close();
    	}
    }
    
    protected void delete(T entity){
    	EntityTransaction tx = getEntityManager().getTransaction();
    	try{
    		tx.begin();
    		getEntityManager().remove(entity);
    		tx.commit();
    		JOptionPane.showMessageDialog(null, "Dado Removido!");
    	}catch(Throwable t){
    		 t.printStackTrace();
    		 tx.rollback();
             JOptionPane.showMessageDialog(null, "Erro ao remover dado!");
    	}finally{
    		close();
    	}
    }
    
    public List<T> findAll() throws Exception {
    	ArrayList<T> l = new ArrayList<T>();
    	try{
    		Session session = (Session) getEntityManager().getDelegate();
    		l= (ArrayList<T>) session.createCriteria(persistentClass).list();
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null,"Problemas ao Listar!");
    	}finally{
    		close();
    	}
		return l;
		
	}
    
    public T findByName(String nome){
    	Session session = (Session) getEntityManager().getDelegate();
    	return (T) session.createCriteria(persistentClass).add(Restrictions.eq("nome", nome).ignoreCase()).uniqueResult();
    }
    
    public T findById(int id){
  
    	Session session = (Session) getEntityManager().getDelegate();
    	return (T) session.createCriteria(persistentClass).add(Restrictions.eq("id", id)).uniqueResult();
    }
    
    public List<Entity> listarItensP(){
    	Query query = getEntityManager().createQuery("FROM" + persistentClass.getCanonicalName());
    	return query.getResultList();
    }
    
    private void close() {
        if (getEntityManager().isOpen()) {
            getEntityManager().close();
        }
        
    }
    
    
 

}
