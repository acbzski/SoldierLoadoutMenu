package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.LoadItems;

public class LoadItemsHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SoldierLoadoutMenu");

	public void insertItem (LoadItems l) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}

	public void editItem (LoadItems toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteItem (LoadItems toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LoadItems> typedQuery = em.createQuery("select l from LoadItems l where l.description = :selectedDescription and l.weight = :selectedWeight", LoadItems.class);
		typedQuery.setParameter("selectedDescription", toDelete.getDescription());
		typedQuery.setParameter("selectedWeight", toDelete.getWeight());
		typedQuery.setMaxResults(1);
		LoadItems result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public LoadItems searchForLoadItemsById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		LoadItems found = em.find(LoadItems.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<LoadItems> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<LoadItems> allItems = em.createQuery("SELECT l FROM LoadItems l").getResultList();
		return allItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
