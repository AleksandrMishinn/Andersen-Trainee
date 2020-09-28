package dao;

import demo.HibernateDemo;
import models.Author;
import models.Book;
import utils.EntityManagerFactoryUtil;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.logging.Logger;

public class BookDAO {

    private final Logger LOGGER = Logger.getLogger(HibernateDemo.class.getName());
    private Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    public void printTitleById(int id) {
        Book book = session.get(Book.class, id);
        LOGGER.info("Книга с id = " + id + ", это книга: " + book.getTitle());
    }

    public void printTitleByAuthorId(int id) {
        Author author = session.get(Author.class, id);
        LOGGER.info("Автор с id = " + id + ", это : " + author.getName() + ", его книги: ");
        List<Book> books = author.getBooks();
        for (Book currentBook : books) {
            LOGGER.info(currentBook.getTitle() + "\n");
        }
    }

    public Book create(String title, Author author) {

        if (title.isEmpty() || author == null) {
            return null;
        }

        Book newBook = new Book(title, author);

        Transaction tx = session.beginTransaction();

        try {
            session.save(newBook);
        } catch (Exception e) {
            tx.rollback();
            session.close();
            return null;
        }

        tx.commit();
        session.close();

        return newBook;
    }

    public void changeTitle(int id, String newTitle) {

        Book book = session.get(Book.class, id);

        EntityManagerFactory factory = EntityManagerFactoryUtil.getFactory();
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        book.setTitle(newTitle);
        entityManager.merge(book);
        entityManager.getTransaction().commit();

        LOGGER.info("Название книги изменено на " + book.getTitle());
    }
}
