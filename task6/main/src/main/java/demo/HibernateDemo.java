package demo;

import models.Author;
import models.Book;
import service.AuthorService;
import service.BookService;

public class HibernateDemo {
    public static void main(String[] args) {

        BookService bookService = new BookService();
        AuthorService authorService = new AuthorService();

        bookService.printTitleById(4);
        bookService.printTitleById(5);

        authorService.printAuthorNameById(2);
        authorService.printAuthorNameById(1);

        bookService.printBooksByAuthorId(5);
        authorService.printAuthorsOfBook(3);

        authorService.printAuthorWithMaxNumberOfBooks();
        Author author = authorService.getById(2);

        Book newBook = bookService.create("Братья Карамазовы", author);
        System.out.println("Создана новая книга. Название: " + newBook.getTitle());

        bookService.changeTitle(4, "new Title");
    }
}
