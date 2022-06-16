package cs.vsu.ru.bookshop.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "order_book", schema = "public")
@Validated
public class Order_book implements Serializable {
    public Order_book(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    @NotNull(message = "book_id can not be empty")
    private BookEntity book_id;


    @ManyToOne()
    @JoinColumn(name = "order_id")
    @NotNull(message = "order_id can not be empty")
    private OrderEntity order_id;

    @NotNull(message = "count price can not be empty")
    @Column(name = "count")
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public void setBook_id(BookEntity book_id) {
        this.book_id = book_id;
    }

    public BookEntity getBook_id() {
        return book_id;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setOrder_id(OrderEntity order_id) {
        this.order_id = order_id;
    }

    public OrderEntity getOrder_id() {
        return order_id;
    }
}
