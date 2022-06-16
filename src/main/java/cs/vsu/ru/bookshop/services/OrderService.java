package cs.vsu.ru.bookshop.services;

import cs.vsu.ru.bookshop.entities.OrderEntity;
import cs.vsu.ru.bookshop.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
    public OrderService() {

    }

    public OrderEntity create(OrderEntity order) {
        orderRepo.save(order);
        return order;
    }

    public List<OrderEntity> findAll() {
        List<OrderEntity> orderEntities = null;
        orderEntities = orderRepo.findAll();
        if (orderEntities != null){
        }
        return orderEntities;
    }

    public OrderEntity findById(int id) {
        Optional<OrderEntity> orderEntity = orderRepo.findById(id);
        if (orderEntity.isPresent()){
            return orderEntity.get();
        }
        return null;
    }

    public OrderEntity update(OrderEntity order) {
        orderRepo.save(order);
        return order;
    }

    public void deleteById(int id) {
        orderRepo.deleteById(id);
    }
}
