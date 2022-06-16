package cs.vsu.ru.bookshop.repositories;

import cs.vsu.ru.bookshop.entities.CustomerEntity;
import cs.vsu.ru.bookshop.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {

    Optional<OrderEntity> findById(int id);

    List<OrderEntity> findAll();

}
