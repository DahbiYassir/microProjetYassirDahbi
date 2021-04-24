package com.microProjet.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.microProjet.beans.Article;
import com.microProjet.beans.Categorie;
import com.microProjet.beans.Inscription;

public class JpaConnection {
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("namePersistence");
		EntityManager entitymanager = emfactory.createEntityManager();
		return entitymanager;
	}
	
	public static String jpaRegister(Inscription inscription) {
		
			EntityManager entitymanager = getEntityManager();
			entitymanager.getTransaction().begin();
			entitymanager.persist(inscription);
			entitymanager.getTransaction().commit();
			entitymanager.close();
			return "inserted";			
		}
	
	public static boolean loginJpa(Inscription inscription) {
		EntityManager entitymanager = getEntityManager();
		try {
					entitymanager.createQuery("SELECT c FROM Inscription as c WHERE c.email = :email and c.motPasse= :mdp",Inscription.class)
					.setParameter("email", inscription.getEmail()).setParameter("mdp", inscription.getMotDePasse()).getSingleResult();
			return true;
		}catch (Exception e) {
			return false;
		}

	}
	
	public static ArrayList<Article> listeProduitJpa(String categorie) {
		
		EntityManager entityManager= getEntityManager();
		try {
			Categorie categ = entityManager.createQuery("select a from Categorie as a where a.id= :refcat", Categorie.class)
				 .setParameter("refcat", Integer.parseInt(categorie)).getSingleResult();
			String cat = categ.getCategorie();
			ArrayList<Article> listArticles = (ArrayList<Article>) entityManager.createQuery("select c from Article as c where c.categorie= :cat", Article.class)
					 .setParameter("cat", cat).getResultList();
			return listArticles;
		}catch (Exception e) {
			 return null;
		}
		
	}
	
	public static ArrayList<Categorie> listCategoriesJpa() {
		EntityManager entityManager = getEntityManager();
        return (ArrayList<Categorie>) entityManager.createQuery("from Categories",Categorie.class).getResultList();
    }
	
	public static Article ArticleDisplayJpa(Article article) throws SQLException {
		int id = article.getCodeArticle();
		EntityManager entityManager= getEntityManager();
		return entityManager.createQuery("select a from Article as a where a.codeArticle=:id",Article.class).setParameter("id",id).getSingleResult();
			
		
	}
	

}
