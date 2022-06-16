package cs.vsu.ru.bookshop.repositories;

import cs.vsu.ru.bookshop.entities.CustomerEntity;
import cs.vsu.ru.bookshop.entities.Order_book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderBookRepo extends JpaRepository<Order_book, Integer> {

    Optional<Order_book> findById(int id);

    List<Order_book> findAll();
}
