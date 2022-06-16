package cs.vsu.ru.bookshop.repositories;

import cs.vsu.ru.bookshop.entities.CustomerEntity;
import cs.vsu.ru.bookshop.entities.Shop_book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopBookRepo extends JpaRepository<Shop_book, Integer> {

    Optional<Shop_book> findById(int id);

    List<Shop_book> findAll();

}
