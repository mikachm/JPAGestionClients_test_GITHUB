package com.M2I.gc;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
    private static EntityManagerFactory entityManagerFactory;

    static //bloc static, permet de charger "automatiquement" le bloc pour permettre son éxecution
    {
        try {
        	//Chargement de persistence.xml avec <persistence-unit name="hsql" ..>
            entityManagerFactory= Persistence.createEntityManagerFactory("hsql");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
    
}