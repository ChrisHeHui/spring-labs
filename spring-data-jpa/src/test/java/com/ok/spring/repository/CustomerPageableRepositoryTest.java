package com.ok.spring.repository;

import com.ok.spring.entity.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerPageableRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerPageableRepositoryTest.class);

    @Autowired
    private CustomerPageableRepository repositoryPageable;

    @Autowired
    private CustomerRepository repository;

    @Test
    public void simpleTest() {
        List<Customer> allCustomers = repository.findAll();
        Assert.assertNotNull(allCustomers);
        Assert.assertTrue(allCustomers.size() > 0);
        Page<Customer> customerPage =  repositoryPageable.findAll(new PageRequest(0, 2));
        Assert.assertNotNull(customerPage);
        Assert.assertTrue(customerPage.getTotalElements() == allCustomers.size());
    }
}
