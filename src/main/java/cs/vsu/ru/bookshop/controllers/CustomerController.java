package cs.vsu.ru.bookshop.controllers;

import cs.vsu.ru.bookshop.entities.CustomerEntity;
import cs.vsu.ru.bookshop.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping()
    ResponseEntity<List<CustomerEntity>> findAll() {
        final  List<CustomerEntity> customers = new ArrayList<>();
        customerService.findAll().forEach(customer -> {
            customers.add(customer);
        });
        System.out.println(customers.size());
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<CustomerEntity> add(@RequestBody CustomerEntity customer) {
        return new ResponseEntity<>(customerService.create(customer),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<CustomerEntity> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        CustomerEntity c = customerService.findById(id);
        System.out.println(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        customerService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<CustomerEntity> update(@RequestBody CustomerEntity customer){
        return new ResponseEntity<>(customerService.update(customer),HttpStatus.OK);
    }


}
