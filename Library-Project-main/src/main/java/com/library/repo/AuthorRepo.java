package com.library.repo;

import com.library.connection.ConnectionHB;
import com.library.entity.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AuthorRepo {

    private static EntityManager em = ConnectionHB.getConnect();

    public static void addAuthor(Author author){
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
    }

    public static void printAuthorById(Long id){
        Author author = em.find(Author.class,id);
        System.out.println(author);
    }


    public static void printAllAuthor(){
        TypedQuery<Author> query = em.createQuery("select a from Author as a ",Author.class);
        List<Author> authors = query.getResultList();
        for (Author a:authors) {
            System.out.println(a);
        }

    }

    public static void deleteAuthor(Long id){
        em.getTransaction().begin();
        Author author= em.find(Author.class,id);
        em.remove(author);
        em.getTransaction().commit();
    }


    public static Author findById(Long id){return em.find(Author.class,id);}
}
