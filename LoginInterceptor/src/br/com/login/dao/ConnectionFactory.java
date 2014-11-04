package br.com.login.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private EntityManager em = null;
	
	public EntityManager openConnection(){
		if (em == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
			em = emf.createEntityManager();
		}
		
		return em;
	}
}
