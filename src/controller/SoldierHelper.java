package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Soldier;

public class SoldierHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SoldierLoadoutMenu");

	public void insertSoldier(Soldier s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public void editSoldier (Soldier toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteSoldier (Soldier toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Soldier> typedQuery = em.createQuery("select s from Soldier s where s.name = :selectedName and s.birthdate = :selectedBirthdate", Soldier.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedBirthdate", toDelete.getBirthdate());
		typedQuery.setMaxResults(1);
		Soldier result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Soldier> showAllSoldiers() {
		EntityManager em = emfactory.createEntityManager();
		List<Soldier> allSoldiers = em.createQuery("SELECT s FROM Soldier s").getResultList();
		return allSoldiers;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
