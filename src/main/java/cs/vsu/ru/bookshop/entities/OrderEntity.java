package cs.vsu.ru.bookshop.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orders", schema = "public")
@Validated
public class OrderEntity implements Serializable {
    public OrderEntity(){};

    public void setOrd_date(Date ord_date) {
        this.ord_date = ord_date;
    }

    public void setCust_id(CustomerEntity cust_id) {
        this.cust_id = cust_id;
    }

    public void setShop_id(ShopEntity shop_id) {
        this.shop_id = shop_id;
    }

    public Date getOrd_date() {
        return ord_date;
    }

    public CustomerEntity getCust_id() {
        return cust_id;
    }

    public ShopEntity getShop_id() {
        return shop_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @NotEmpty(message = "ord_date  can not be empty")
    @Column(name = "ord_date")
    private Date ord_date;

    @ManyToOne()
    @JoinColumn(name = "cust_id")
    @NotNull(message = "Cust_id can not be empty")
    private CustomerEntity cust_id;


    @ManyToOne()
    @JoinColumn(name = "shop_id")
    @NotNull(message = "shop_id can not be empty")
    private ShopEntity shop_id;

//
//    @Column(name = "name")
//    @NotEmpty(message = "Username can not be empty")
//    @Size(max = 50, message = "Username length should be between 4 an 20 characters")
//    private String name;
//
//    @Column(name = "email")
//    @NotEmpty(message = "Email can not be empty")
//    @Email(message = "Email is not valid")
//    private String email;
//
//    @Column(name = "phone_num")
//    @NotEmpty(message = "Phone number can not be empty")
//    @Email(message = "Phone number is not valid")
//    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
