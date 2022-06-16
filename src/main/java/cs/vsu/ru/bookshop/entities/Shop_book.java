package cs.vsu.ru.bookshop.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "shop_book", schema = "public")
@Validated
public class Shop_book implements Serializable {
    public Shop_book(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    @NotNull(message = "book_id can not be empty")
    private BookEntity book_id;


    @ManyToOne()
    @JoinColumn(name = "shop_id")
    @NotNull(message = "shop_id can not be empty")
    private ShopEntity shop_id;

    @NotNull(message = "count price can not be empty")
    @Column(name = "count")
    private int count;


    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setBook_id(BookEntity book_id) {
        this.book_id = book_id;
    }

    public void setShop_id(ShopEntity shop_id) {
        this.shop_id = shop_id;
    }

    public BookEntity getBook_id() {
        return book_id;
    }

    public ShopEntity getShop_id() {
        return shop_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
