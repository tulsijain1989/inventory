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

import com.bill.entity.Supplier;
import com.bill.entity.Supplier;
import com.bill.repository.SupplierRepository;

@RestController
public class SupplierController {
	
	@Autowired
	private SupplierRepository supplierRepository;

	@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Supplier>> getAllSuppliers() {
		Iterable<Supplier> allSupplier = supplierRepository.findAll();
		return new ResponseEntity<>(supplierRepository.findAll(), HttpStatus.OK);

	}

	@RequestMapping(value = "/suppliers", method = RequestMethod.POST)
	public ResponseEntity<?> createSupplier(@RequestBody Supplier category) {
		category = supplierRepository.save(category);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newSupplierUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getSupplier_id())
				.toUri();
		responseHeaders.setLocation(newSupplierUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

	}
	
	@RequestMapping(value="suppliers/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getPoll(@PathVariable Long id){
		Supplier p= supplierRepository.findOne(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="suppliers/{id}", method= RequestMethod.PUT)
	public ResponseEntity<?> updateSupplier(@RequestBody Supplier category, @PathVariable Long id){
		Supplier p= supplierRepository.save(category);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="suppliers/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> deleteSupplier(@PathVariable Long id){
		supplierRepository.delete(id);
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
