package com.M2I.gc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.M2I.gc.beans.Clients;
import com.M2I.gc.beans.Facture;
import com.M2I.gc.beans.FactureDetails;
import com.M2I.gc.beans.Article;

public class LanceJPA {

	public static void main(String[] args) {
		EntityTransaction tx=null;
	    try {

	    	//Crï¿½ation de la Factory pour la persistence
	        EntityManagerFactory emf = EntityManagerHelper.getEntityManagerFactory();
	        //Rï¿½cupï¿½ration ï¿½ partir de la Factory d'un EntityManager
	        EntityManager em = emf.createEntityManager();

	        //Sï¿½lectionne le client dont l'id est 1
	        Clients client = (Clients) em.find(Clients.class, 1);
	        Article article1 = (Article) em.find(Article.class, 1);
	        Article article2 = (Article) em.find(Article.class, 2);
	        Clients client3 = (Clients) em.find(Clients.class, 6);
	        

	        if(client != null)
	        {
	        	  //Si le client a ï¿½tï¿½ trouvï¿½ on affiche des informations
	        	System.out.println("Trouvé :) !");
		        System.out.println(String.format("Nom Client: %s, Adresse: %s", client.getNom(), client.getAdresse()));
		        System.out.println(String.format("Désignation: %s, Tarif Unitaire: %s", article1.getDesignation(), article1.getTarifUnitaire()));
		        System.out.println(String.format("Désignation: %s, Tarif Unitaire: %s", article2.getDesignation(), article2.getTarifUnitaire()));
	        
		        
		        
		        //TypedQuery<Article> query = em.createQuery("SELECT * FROM tarticle");
		        //List<Article> results = query.getResultList();
		        Query q1 = em.createQuery("SELECT designation FROM Article");
		        System.out.println(q1.getResultList());
		        
		        ///////////////////////////////////////////////////
		        ///////////////////////////////////////////////////
		        ///////////////////////////////////////////////////
	        	//System.out.println("Création test d'un client");
	        	//tx=em.getTransaction();
	        	//Rï¿½cupï¿½ration d'une Transaction
	        	//tx.begin();//Début de la transaction
	        	//Instanciation d'une entitï¿½ client
	        	//Clients client2 = new Clients();
	        	//Mise à jour des donnï¿½es du client
	        	//client2.setDatecreation();
	        	//em.persist(client2);//insert
	        	//tx.commit();
		        ////EXEMPLE UPDATE ET MERGE///////////////////////
		        System.out.println("Mise à jour de client1...");
		        tx=em.getTransaction();
		        tx.begin();//début de la transactionclient
		        client3.setVille("Perpignan");
		        em.merge(client3);
		        em.persist(client3);
		        tx.commit();   
	        	/////////////////////////////////////////////////////
	        	/////////////////////////////////////////////////////
	        	/////////////////////////////////////////////////////
		        Facture facture1 = new Facture();
		        System.out.println("Creation facture...");
		        tx = em.getTransaction();
		        tx.begin();
		        facture1.setIdClient(3);
		        facture1.setAdresseFacture("3 rue des Tourterelles 75000 Paris");
		        facture1.setMontantFacture(250);
		        facture1.setDescriptionFacture("Embrayage");
		        em.persist(facture1);
		        tx.commit();
		        /////////////////////////////////////////////////////
		        FactureDetails factDet = new FactureDetails();
		        System.out.println("Creation facture détails...");
		        tx = em.getTransaction();
		        tx.begin();
		        factDet.setIdArticle(8);
		        factDet.setIdFact(1);
		        factDet.setQteFact(1);
		        factDet.setTxTva(20);
		        em.persist(factDet);
		        tx.commit();
		        
		        
		        
		        
	        
	        
	        
	        
	        }
	        else
	        {
	        	//Si pas trouvï¿½ alors on crï¿½e un client
	        	//c'est le SGBDR qui gï¿½re les id !!
	        	System.out.println("Création");
	        	tx=em.getTransaction();
	        	//Rï¿½cupï¿½ration d'une Transaction
	        	tx.begin();//Début de la transaction

	        	//Instanciation d'une entitï¿½ client
	        	client = new Clients();
	        	//Affectation des donnï¿½es du client
	        	client.setAdresse("rue de la vie");
	        	client.setCdp("13000");
	        	client.setNom("Client 1");
	        	client.setVille("Marseille");
	        	em.persist(client);//insert
	        	tx.commit();//Valide la transaction + close en mÃªme temps la transaction

	        }
	        em.close();//ferme l'entitï¿½ manager

	    } catch (Exception e) {
	        e.printStackTrace();
	        if(tx!=null) tx.rollback();
	        //s'il y a eu une transaction on fait un roolback
	        //pour annuler toutes commandes orphelines
	    }


	}

}
