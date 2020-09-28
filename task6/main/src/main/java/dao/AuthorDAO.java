package dao;

import demo.HibernateDemo;
import models.Author;
import models.Book;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.logging.Logger;

public class AuthorDAO {

    private final Logger LOGGER = Logger.getLogger(HibernateDemo.class.getName());
    private Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    public void printNameById(int id) {
        Author author = session.get(Author.class, id);
        LOGGER.info("Автор с id = " + id + ", это : " + author.getName());
    }

    public void printAuthorsOfBook(int id) {
        Book book = session.get(Book.class, id);
        LOGGER.info("Книга с id = " + id + ", это книга: " + book.getTitle() + ", её авторы: ");
        List<Author> authors = book.getAuthors();
        for (Author currentAuthor : authors) {
            LOGGER.info(currentAuthor.getName() + "\n");
        }
    }

    public void printAuthorWithMaxNumberOfBooks() {

        String query = "WITH number_of_books AS" +
                                "(SELECT COUNT(book_id) AS number" +
                                " FROM authors_to_books" +
                                " GROUP BY author_id)" +
                        "SELECT author_id, COUNT(book.id)" +
                        "FROM authors_to_books" +
                        "GROUP BY authors_to_books.author_id" +
                        "HAVING COUNT(book.id) = (SELECT MAX(number) " +
                        "                         FROM number_of_books)";

        System.out.println(session.createSQLQuery(query).getFirstResult());
    }

    public Author getById(int id) {
        return session.get(Author.class, id);
    }
}
