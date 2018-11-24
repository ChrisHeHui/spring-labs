package com.ok.spring.repository;

import com.ok.spring.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerPageableRepository extends PagingAndSortingRepository<Customer, Long> {


}
