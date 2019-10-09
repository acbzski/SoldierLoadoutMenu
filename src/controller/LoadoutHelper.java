package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Loadout;

public class LoadoutHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SoldierLoadoutMenu");

	public void insertLoadout (Loadout l) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}

	public void editLoadout (Loadout toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteLoadout (Loadout toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Loadout> typedQuery = em.createQuery("select l from Loadout l where l.loadout_name = :selectedName", Loadout.class);
		typedQuery.setParameter("selectedName", toDelete.getLoadout_name());
		typedQuery.setMaxResults(1);
		Loadout result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Loadout> showAllLoadouts() {
		EntityManager em = emfactory.createEntityManager();
		List<Loadout> allLoadouts = em.createQuery("SELECT l FROM Loadout l").getResultList();
		return allLoadouts;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
