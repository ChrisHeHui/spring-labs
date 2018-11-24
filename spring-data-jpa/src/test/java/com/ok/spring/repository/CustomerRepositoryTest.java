package com.ok.spring.repository;

import com.ok.spring.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @Autowired
    private CustomerRepository repository;

    @Test
    public void simpleTest() {
        // save a couple of customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

        // fetch all customers
        LOG.info("Customers found with findAll():");
        LOG.info("-------------------------------");
        for (Customer customer : repository.findAll()) {
            LOG.info(customer.toString());
        }
        LOG.info("");

        // fetch an individual customer by ID
        repository.findById(1L)
                .ifPresent(customer -> {
                    LOG.info("Customer found with findById(1L):");
                    LOG.info("--------------------------------");
                    LOG.info(customer.toString());
                    LOG.info("");
                });

        // fetch customers by last name
        LOG.info("Customer found with findByLastName('Bauer'):");
        LOG.info("--------------------------------------------");
        repository.findByLastName("Bauer").forEach(bauer -> {
            LOG.info(bauer.toString());
        });
        // for (Customer bauer : repository.findByLastName("Bauer")) {
        // 	log.info(bauer.toString());
        // }
        LOG.info("");
    }
}
