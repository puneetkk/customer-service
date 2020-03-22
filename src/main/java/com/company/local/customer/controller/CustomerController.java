package com.company.local.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.local.customer.domain.Customer;
import com.company.local.customer.domain.CustomerDTO;
import com.company.local.customer.service.CustomerService;

@RestController
@RequestMapping(path = "/customerservice")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	protected CustomerController() {
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customerList = customerService.getAllCustomers();
		if (customerList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}

	@RequestMapping(value = "/details/{fullName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Customer> getAddressByIdRestApi(@PathVariable("fullName") String fullName) {
		Customer add = customerService.getCustomerByFullName(fullName);
		if (null == add) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(add, HttpStatus.OK);
	}

	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseEntity<Customer> createNewCustomer(@RequestBody @Validated CustomerDTO customerDTO) {
		Customer customer = customerService.addCustomer(customerDTO);
		if (null == customer) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseEntity<?> deleteCustomer(@PathVariable("id") String id) {
		boolean add = customerService.deleteCustomer(id);

		if (false == add) {
			return new ResponseEntity<>(add, HttpStatus.BAD_REQUEST);

		} else {
			return new ResponseEntity<>(add, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/searchByPolicyNumber/{policyNumber}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseEntity<List<Customer>> searchByPolicyNumbe(
			@PathVariable("policyNumber") String policyNumber) {

		List<Customer> add = customerService.findByPolicyNumber(policyNumber);

		if (null == add) {
			return new ResponseEntity<>(add, HttpStatus.BAD_REQUEST);

		} else {
			return new ResponseEntity<>(add, HttpStatus.OK);
		}

	}

}
