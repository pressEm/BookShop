package cs.vsu.ru.bookshop.repositories;

import cs.vsu.ru.bookshop.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {

    Optional<BookEntity> findById(int id);

    List<BookEntity> findAll();

}
