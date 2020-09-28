package service;

import dao.AuthorDAO;
import models.Author;

public class AuthorService {

    private AuthorDAO authorDAO = new AuthorDAO();

    public void printAuthorNameById(int id) {
        authorDAO.printNameById(id);
    }

    public void printAuthorsOfBook(int id) {
        authorDAO.printAuthorsOfBook(id);
    }

    public void printAuthorWithMaxNumberOfBooks() {
        authorDAO.printAuthorWithMaxNumberOfBooks();
    }

    public Author getById(int id){
        return authorDAO.getById(id);
    }
}
