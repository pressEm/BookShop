package cs.vsu.ru.bookshop.controllers;

import cs.vsu.ru.bookshop.entities.BookEntity;
import cs.vsu.ru.bookshop.entities.Order_book;
import cs.vsu.ru.bookshop.services.BookService;
import cs.vsu.ru.bookshop.services.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order_book")
public class BookOrderController {


    private final OrderBookService service;

    @Autowired
    public BookOrderController(OrderBookService service) {
        this.service = service;
    }
    @GetMapping()
    ResponseEntity<List<Order_book>> findAll() {
        final  List<Order_book> entities = new ArrayList<>();
        service.findAll().forEach(customer -> {
            entities.add(customer);
        });
        System.out.println(entities.size());
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<Order_book> add(@RequestBody Order_book entity) {
        return new ResponseEntity<>(service.create(entity),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Order_book> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        Order_book c = service.findById(id);
        System.out.println(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        service.deleteById(id);
    }

    @PutMapping
    ResponseEntity<Order_book> update(@RequestBody Order_book entity){
        return new ResponseEntity<>(service.update(entity),HttpStatus.OK);
    }


}

