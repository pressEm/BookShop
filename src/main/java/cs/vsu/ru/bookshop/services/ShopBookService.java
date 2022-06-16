package cs.vsu.ru.bookshop.services;

import cs.vsu.ru.bookshop.entities.Shop_book;
import cs.vsu.ru.bookshop.repositories.ShopBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopBookService {
    ShopBookRepo shopBookRepo;

    @Autowired
    public ShopBookService(ShopBookRepo shopBookRepo) {
        this.shopBookRepo = shopBookRepo;
    }
    public ShopBookService() {

    }

    public Shop_book create(Shop_book customer) {
        shopBookRepo.save(customer);
        return customer;
    }

    public List<Shop_book> findAll() {
        List<Shop_book> customers = null;
        customers = shopBookRepo.findAll();
        if (customers != null){
        }
        return customers;
    }

    public Shop_book findById(int id) {
        Optional<Shop_book> customer = shopBookRepo.findById(id);
        if (customer.isPresent()){
            return customer.get();
        }
        return null;
    }

    public Shop_book update(Shop_book customer) {
        shopBookRepo.save(customer);
        return customer;
    }

    public void deleteById(int id) {
        shopBookRepo.deleteById(id);
    }
}
