package cs.vsu.ru.bookshop.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "shops", schema = "public")
@Validated
public class ShopEntity implements Serializable {
    public ShopEntity(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Username can not be empty")
    @Size(max = 50, message = "Username length should be between 4 an 20 characters")
    private String name;

    @Column(name = "address")
    @NotEmpty(message = "address can not be empty")
    @Email(message = "address is not valid")
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

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

}
