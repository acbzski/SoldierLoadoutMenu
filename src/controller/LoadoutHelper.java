package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Loadout;

public class LoadoutHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SoldierLoadoutMenu");

	public void insertLoadout(Loadout l) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}

	public List<Loadout> showAllLoadout() {
		EntityManager em = emfactory.createEntityManager();
		List<Loadout> allLoadouts = em.createQuery("SELECT l FROM Loadout l").getResultList();
		return allLoadout;
	}

	public Loadout searchForLoadoutByName(String LoadoutName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Loadout> typedQuery = em.createQuery("select l from Loadout l where l.LoadoutName = :selectedName",
				Loadout.class);
		typedQuery.setParameter("selectedName", LoadoutName);
		typedQuery.setMaxResults(1);

		Loadout found = typedQuery.getSingleResult();
		em.close();
		return found;
	}
}
