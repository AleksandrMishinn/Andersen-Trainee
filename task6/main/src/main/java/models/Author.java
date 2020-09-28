package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "authors_to_books",
            joinColumns =
            @JoinColumn(name = "author_id"),
            inverseJoinColumns =
            @JoinColumn(name = "book_id",
                    nullable = false))
    private List<Book> books;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
