package com.library;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.repo.AuthorRepo;
import com.library.repo.BookRepo;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        //create Author
        Author author= new Author();
        author.setName("Ahmed");
        author.setEmail("ahmed@gmail.com");
        author.setPhone("0156120145");

        //add author
        AuthorRepo.addAuthor(author);

        //return author from database
        AuthorRepo.printAuthorById(1l);

        //return all authors
        AuthorRepo.printAllAuthor();

        //delete
        AuthorRepo.deleteAuthor(2l);
        System.out.println("After");
        AuthorRepo.printAllAuthor();

        //add book
        Book book = new Book();
        book.setTittle("Hibernate");
        book.setVersion(5);
        book.setPublish_dateTime(LocalDateTime.now());
        book.setAuthor(AuthorRepo.findById(1l));
        BookRepo.addBook(book);

        //update
        Book book2 = BookRepo.findById(52l);
        book2.setTittle("OOP");
        book2.setVersion(3);
        BookRepo.addBook(book2);

        //return book
        BookRepo.printBook(1l);

        //return all books
        BookRepo.printAllBooks();

        //delete
        BookRepo.deleteById(1l);


    }
}
