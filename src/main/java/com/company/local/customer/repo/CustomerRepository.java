/**
 * 
 */
package com.company.local.customer.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.company.local.customer.domain.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	@Query("{ 'policyNumber' : ?0 }")
	List<Customer> findByPolicyNumber(String policyNumber);

	@Query(value = "{ 'id' : ?0}")
	void deleteById(String id);

	@Query("{ 'fullName' : ?0}")
	Customer findByFullName(String fullName);
}
