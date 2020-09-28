package service;

import dao.BookDAO;
import models.Author;
import models.Book;

public class BookService {

    private BookDAO bookDAO = new BookDAO();

    public void printTitleById(int id) {
        bookDAO.printTitleById(id);
    }

    public void printBooksByAuthorId(int id) {
        bookDAO.printTitleByAuthorId(id);
    }

    public Book create(String title, Author author){
        return bookDAO.create(title, author);
    }

    public void changeTitle(int id, String newTitle){
        bookDAO.changeTitle(id, newTitle);
    }
}
