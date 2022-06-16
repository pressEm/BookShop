package cs.vsu.ru.bookshop.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "books", schema = "public")
@Validated
public class BookEntity implements Serializable {
    public BookEntity(){};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Username can not be empty")
    @Size(max = 50, message = "Username length should be between 4 an 20 characters")
    private String name;

    @Column(name = "author")
    @NotEmpty(message = "author can not be empty")
    @Email(message = "author is not valid")
    private String author;

    @Column(name = "category")
    @NotEmpty(message = "category can not be empty")
    @Email(message = "category is not valid")
    private String category;

    @NotNull(message = "rate price can not be empty")
    @Column(name = "rate")
    private int rate;

    @NotEmpty(message = "date_publish  can not be empty")
    @Column(name = "date_publish")
    private Date date_publish;

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setDate_publish(Date date_publish) {
        this.date_publish = date_publish;
    }

    public void setPublishing_house(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public int getRate() {
        return rate;
    }

    public Date getDate_publish() {
        return date_publish;
    }

    public String getPublishing_house() {
        return publishing_house;
    }

    @Column(name = "publishing_house")
    @NotEmpty(message = "publishing_house can not be empty")
    @Email(message = "publishing_house is not valid")
    private String publishing_house;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }




    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }
}

