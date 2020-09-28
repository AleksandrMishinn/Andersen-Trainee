package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "authors_to_books",
            joinColumns =
            @JoinColumn(name = "book_id"),
            inverseJoinColumns =
            @JoinColumn(name = "author_id",
                    nullable = false))
    private List<Author> authors;

    private String title;

    public Book() {
    }

    public Book(String title, Author author) {
        this.title = title;
        this.authors = List.of(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
