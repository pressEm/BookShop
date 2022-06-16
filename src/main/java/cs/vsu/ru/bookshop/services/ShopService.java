package cs.vsu.ru.bookshop.services;

import cs.vsu.ru.bookshop.entities.ShopEntity;
import cs.vsu.ru.bookshop.repositories.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ShopService {
    private ShopRepo shopRepo;

    @Autowired
    public ShopService(ShopRepo shopRepo) {
        this.shopRepo = shopRepo;
    }

    public ShopEntity create(ShopEntity shopEntity) {
        shopRepo.save(shopEntity);
        return shopEntity;
    }

    public List<ShopEntity> findAll() {
        List<ShopEntity> customers = null;
        customers = shopRepo.findAll();
        if (customers != null){
        }
        return customers;
    }

    public ShopEntity findById(int id) {
        Optional<ShopEntity> customer = shopRepo.findById(id);
        if (customer.isPresent()){
            return customer.get();
        }
        return null;
    }

    public ShopEntity update(ShopEntity shopEntity) {
        shopRepo.save(shopEntity);
        return shopEntity;
    }

    public void deleteById(int id) {
        shopRepo.deleteById(id);
    }
}

