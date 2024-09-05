package com.library.repo;

import com.library.connection.ConnectionHB;
import com.library.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BookRepo {

    private static EntityManager em = ConnectionHB.getConnect();

    public static void addBook(com.library.entity.Book book){
        em.getTransaction().begin();
        if(book.getAuthor()==null){
            throw new IllegalArgumentException("Add author to this book");
        }
        em.persist(book);
        em.getTransaction().commit();
    }





    public static void printBook(Long id){
        TypedQuery<Book> query= em.createQuery("select b from BookRepo as b where b.id ="+id+"", Book.class);
        com.library.entity.Book book= query.getSingleResult();
        System.out.println(book);
    }

    public static void printAllBooks(){
        TypedQuery<Book> query= em.createQuery("select b from BookRepo as b ", com.library.entity.Book.class);
        List<Book> books= query.getResultList();

        System.out.println(books);

    }

    public static void deleteById(Long id){
        em.getTransaction().begin();
        Book book=em.find(Book.class,id);
        if(book==null)
            throw new IllegalArgumentException("Not found , this already deleted");
        em.remove(book);
        em.getTransaction().commit();
    }

    public static com.library.entity.Book findById(Long id){
        return em.find(Book.class,id);
    }

}
