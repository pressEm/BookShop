package cs.vsu.ru.bookshop.controllers;

import cs.vsu.ru.bookshop.entities.BookEntity;
import cs.vsu.ru.bookshop.entities.Shop_book;
import cs.vsu.ru.bookshop.services.BookService;
import cs.vsu.ru.bookshop.services.ShopBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assortment")
public class BookShopController {

    private final ShopBookService service;

    @Autowired
    public BookShopController(ShopBookService service) {
        this.service = service;
    }
    @GetMapping()
    ResponseEntity<List<Shop_book>> findAll() {
        final  List<Shop_book> entities = new ArrayList<>();
        service.findAll().forEach(entity -> {
            entities.add(entity);
        });
        System.out.println(entities.size());
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<Shop_book> add(@RequestBody Shop_book entity) {
        return new ResponseEntity<>(service.create(entity),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Shop_book> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        Shop_book c = service.findById(id);
        System.out.println(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        service.deleteById(id);
    }

    @PutMapping
    ResponseEntity<Shop_book> update(@RequestBody Shop_book entity){
        return new ResponseEntity<>(service.update(entity),HttpStatus.OK);
    }


}
