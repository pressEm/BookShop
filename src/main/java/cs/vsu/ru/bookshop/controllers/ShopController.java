package cs.vsu.ru.bookshop.controllers;

import cs.vsu.ru.bookshop.entities.CustomerEntity;
import cs.vsu.ru.bookshop.entities.ShopEntity;
import cs.vsu.ru.bookshop.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }
    @GetMapping()
    ResponseEntity<List<ShopEntity>> findAll() {
        final  List<ShopEntity> customers = new ArrayList<>();
        shopService.findAll().forEach(customer -> {
            customers.add(customer);
        });
        System.out.println(customers.size());
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<ShopEntity> add(@RequestBody ShopEntity shop) {
        return new ResponseEntity<>(shopService.create(shop),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<ShopEntity> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        ShopEntity c = shopService.findById(id);
        System.out.println(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        shopService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<ShopEntity> update(@RequestBody ShopEntity shop){
        return new ResponseEntity<>(shopService.update(shop),HttpStatus.OK);
    }


}
