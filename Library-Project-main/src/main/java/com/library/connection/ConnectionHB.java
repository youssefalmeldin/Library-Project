package com.library.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionHB {

    private final static EntityManagerFactory emf= Persistence.createEntityManagerFactory("library");
    private final static EntityManager em = emf.createEntityManager();

    public static EntityManager getConnect(){
        return em;
    }


}
