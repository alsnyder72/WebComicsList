package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

/**
 * @author AlSnyder - asnyder7 CIS175 - SPRING 2022 Feb 17, 2022
 */

public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebComicsList");

	public void insertItem(ListItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListItem> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<ListItem> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allItems;
	}

	public void deleteItem(ListItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.publisher = :selectedPublisher and li.title = :selectedTitle and li.volume = :selectedVolume and li.issue = :selectedIssue", ListItem.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedPublisher", toDelete.getPublisher());
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedVolume", toDelete.getVolume());
		typedQuery.setParameter("selectedIssue", toDelete.getIssue());
		
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		ListItem result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void updateItem(ListItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListItem> searchForItemByPublisher(String publisherName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.publisher = :selectedPublisher", ListItem.class);
		typedQuery.setParameter("selectedPublisher", publisherName);
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<ListItem> searchForItemByTitle(String titleName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.title = :selectedTitle", ListItem.class);
		typedQuery.setParameter("selectedTitle", titleName);
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public ListItem searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, idToEdit);
		em.close();
		return found;
	}

	public void cleanUp() {
		emfactory.close();
	}

}
