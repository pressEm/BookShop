package cs.vsu.ru.bookshop.controllers;

import cs.vsu.ru.bookshop.entities.CustomerEntity;
import cs.vsu.ru.bookshop.entities.OrderEntity;
import cs.vsu.ru.bookshop.services.CustomerService;
import cs.vsu.ru.bookshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping()
    ResponseEntity<List<OrderEntity>> findAll() {
        final  List<OrderEntity> entities = new ArrayList<>();
        orderService.findAll().forEach(customer -> {
            entities.add(customer);
        });
        System.out.println(entities.size());
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<OrderEntity> add(@RequestBody OrderEntity order) {
        return new ResponseEntity<>(orderService.create(order),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<OrderEntity> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        OrderEntity c = orderService.findById(id);
        System.out.println(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        orderService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<OrderEntity> update(@RequestBody OrderEntity order){
        return new ResponseEntity<>(orderService.update(order),HttpStatus.OK);
    }


}
