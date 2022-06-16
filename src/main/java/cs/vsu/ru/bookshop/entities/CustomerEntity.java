package cs.vsu.ru.bookshop.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "customers", schema = "public")
@Validated
public class CustomerEntity implements Serializable {
    public CustomerEntity(){};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Username can not be empty")
    @Size(max = 50, message = "Username length should be between 4 an 20 characters")
    private String name;

    @Column(name = "email")
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Email is not valid")
    private String email;

    @Column(name = "phone_num")
    @NotEmpty(message = "Phone number can not be empty")
    @Email(message = "Phone number is not valid")
    private String phone;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
