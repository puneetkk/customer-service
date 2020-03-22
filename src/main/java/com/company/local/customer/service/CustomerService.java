package com.company.local.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.local.customer.domain.Customer;
import com.company.local.customer.domain.CustomerDTO;
import com.company.local.customer.repo.CustomerRepository;

@Service
public class CustomerService {

	public static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(CustomerDTO customerDTO) {
		Customer con = new Customer();
		con.setFullName(customerDTO.getFullName());
		con.setPolicyNumber(customerDTO.getPolicyNumber());
		con.setAddress(customerDTO.getAddress());
		con.setEmail(customerDTO.getEmail());
		con.setMobilePhoneNumber(customerDTO.getMobilePhoneNumber());
		customerRepository.insert(con);
		return con;
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public void updateCustomer(CustomerDTO customerDTO) {
		List<Customer> customer = new ArrayList<Customer>();
		Customer con = new Customer();
		con.setFullName(customerDTO.getFullName());
		con.setPolicyNumber(customerDTO.getPolicyNumber());
		con.setAddress(customerDTO.getAddress());
		con.setEmail(customerDTO.getEmail());
		con.setMobilePhoneNumber(customerDTO.getMobilePhoneNumber());
		customer.add(con);
		customerRepository.saveAll(customer);
	}

	public Customer getCustomerByFullName(String fullName) {
		return customerRepository.findByFullName(fullName);
	}

	public boolean deleteCustomer(String id) {
		customerRepository.deleteById(id);
		return true;
	}

	public List<Customer> findByPolicyNumber(String policyNumber) {
		return customerRepository.findByPolicyNumber(policyNumber);
	}

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

}