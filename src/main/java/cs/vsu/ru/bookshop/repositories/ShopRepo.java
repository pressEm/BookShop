package cs.vsu.ru.bookshop.repositories;

import cs.vsu.ru.bookshop.entities.CustomerEntity;
import cs.vsu.ru.bookshop.entities.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepo extends JpaRepository<ShopEntity, Integer> {

    Optional<ShopEntity> findById(int id);

    List<ShopEntity> findAll();

}
