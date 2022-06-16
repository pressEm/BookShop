package cs.vsu.ru.bookshop.services;

import cs.vsu.ru.bookshop.entities.CustomerEntity;
import cs.vsu.ru.bookshop.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    public CustomerService() {

    }

    public CustomerEntity create(CustomerEntity customer) {
        customerRepo.save(customer);
        return customer;
    }

    public List<CustomerEntity> findAll() {
        List<CustomerEntity> customers = null;
        customers = customerRepo.findAll();
        if (customers != null){
        }
        return customers;
    }

    public CustomerEntity findById(int id) {
        Optional<CustomerEntity> customer = customerRepo.findById(id);
        if (customer.isPresent()){
            return customer.get();
        }
        return null;
    }

    public CustomerEntity update(CustomerEntity customer) {
        customerRepo.save(customer);
        return customer;
    }

    public void deleteById(int id) {
        customerRepo.deleteById(id);
    }
}

