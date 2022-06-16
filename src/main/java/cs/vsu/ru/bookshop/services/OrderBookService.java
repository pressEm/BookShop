package cs.vsu.ru.bookshop.services;

import cs.vsu.ru.bookshop.entities.Order_book;
import cs.vsu.ru.bookshop.repositories.OrderBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderBookService {
    OrderBookRepo orderBookRepo;

    @Autowired
    public OrderBookService(OrderBookRepo orderBookRepo) {
        this.orderBookRepo = orderBookRepo;
    }
    public OrderBookService() {

    }

    public Order_book create(Order_book orderBook) {
        orderBookRepo.save(orderBook);
        return orderBook;
    }

    public List<Order_book> findAll() {
        List<Order_book> customers = null;
        customers = orderBookRepo.findAll();
        if (customers != null){
        }
        return customers;
    }

    public Order_book findById(int id) {
        Optional<Order_book> customer = orderBookRepo.findById(id);
        if (customer.isPresent()){
            return customer.get();
        }
        return null;
    }

    public Order_book update(Order_book orderBook) {
        orderBookRepo.save(orderBook);
        return orderBook;
    }

    public void deleteById(int id) {
        orderBookRepo.deleteById(id);
    }
}
