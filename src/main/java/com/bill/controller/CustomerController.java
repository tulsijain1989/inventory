package com.bill.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bill.entity.Customer;
import com.bill.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Customer>> getAllSuppliers() {
		Iterable<Customer> allSupplier = customerRepository.findAll();
		return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);

	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public ResponseEntity<?> createSupplier(@RequestBody Customer category) {
		category = customerRepository.save(category);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newSupplierUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getCustomer_id())
				.toUri();
		responseHeaders.setLocation(newSupplierUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

	}
	
	@RequestMapping(value="customers/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getPoll(@PathVariable Long id){
		Customer p= customerRepository.findOne(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="customers/{id}", method= RequestMethod.PUT)
	public ResponseEntity<?> updateSupplier(@RequestBody Customer category, @PathVariable Long id){
		Customer p= customerRepository.save(category);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="customers/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> deleteSupplier(@PathVariable Long id){
		customerRepository.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}


/*[
  {
    "product_id": 1,
    "name": "ACC",
    "category_id": {
      "category_id": 1,
      "name": "Cement",
      "measurement": "KG"
    },
    "quantity": "1",
    "price": "220",
    "description": "ACC normal Cement"
  }
]
*/
