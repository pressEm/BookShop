package cs.vsu.ru.bookshop.services;

import cs.vsu.ru.bookshop.entities.BookEntity;
import cs.vsu.ru.bookshop.entities.CustomerEntity;
import cs.vsu.ru.bookshop.repositories.BookRepo;
import cs.vsu.ru.bookshop.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    public BookService() {

    }

    public BookEntity create(BookEntity book) {
        bookRepo.save(book);
        return book;
    }

    public List<BookEntity> findAll() {
        List<BookEntity> bookEntities = null;
        bookEntities = bookRepo.findAll();
        if (bookEntities != null){
        }
        return bookEntities;
    }

    public BookEntity findById(int id) {
        Optional<BookEntity> customer = bookRepo.findById(id);
        if (customer.isPresent()){
            return customer.get();
        }
        return null;
    }

    public BookEntity update(BookEntity book) {
        bookRepo.save(book);
        return book;
    }

    public void deleteById(int id) {
        bookRepo.deleteById(id);
    }
}
