package cs.vsu.ru.bookshop.controllers;

import cs.vsu.ru.bookshop.entities.BookEntity;
import cs.vsu.ru.bookshop.entities.CustomerEntity;
import cs.vsu.ru.bookshop.services.BookService;
import cs.vsu.ru.bookshop.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping()
    ResponseEntity<List<BookEntity>> findAll() {
        final  List<BookEntity> entities = new ArrayList<>();
        bookService.findAll().forEach(customer -> {
            entities.add(customer);
        });
        System.out.println(entities.size());
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<BookEntity> add(@RequestBody BookEntity book) {
        return new ResponseEntity<>(bookService.create(book),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<BookEntity> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        BookEntity c = bookService.findById(id);
        System.out.println(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        bookService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<BookEntity> update(@RequestBody BookEntity book){
        return new ResponseEntity<>(bookService.update(book),HttpStatus.OK);
    }


}
