package com.esg.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	  Customer findByCustomerRef(String customerRef);
}