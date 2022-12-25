package com.example.bookcataloger.repository;

import com.example.bookcataloger.HibernateUtil;
import com.example.bookcataloger.model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

//@Repository
public class BookRepository {
    public static BookRepository bookRepository = new BookRepository();

    public Book findByIdBook(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }
    public void saveBook(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        transaction.commit();
        session.close();
    }

    public void deleteBook(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Book book = session.get(Book.class, id);
        session.remove(book);
        session.close();
    }

    public List<Book> findAllBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = (List<Book>) session.createQuery("FROM Book").list();
        session.close();
        return books;
    }
}