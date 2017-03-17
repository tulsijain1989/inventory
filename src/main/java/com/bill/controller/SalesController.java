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

import com.bill.entity.Sales;
import com.bill.repository.SalesRepository;

@RestController
public class SalesController {
	
	@Autowired
	private SalesRepository salesRepository;

	@RequestMapping(value = "/sales", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Sales>> getAllProducts() {
		Iterable<Sales> allSales = salesRepository.findAll();
		return new ResponseEntity<>(salesRepository.findAll(), HttpStatus.OK);

	}

	@RequestMapping(value = "/sales", method = RequestMethod.POST)
	public ResponseEntity<?> createSales(@RequestBody Sales category) {
		category = salesRepository.save(category);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newProductUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getSales_id())
				.toUri();
		responseHeaders.setLocation(newProductUri);
		//logic to delete stock
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

	}
	
	@RequestMapping(value="sales/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getSales(@PathVariable Long id){
		Sales p= salesRepository.findOne(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="sales/{id}", method= RequestMethod.PUT)
	public ResponseEntity<?> updateSales(@RequestBody Sales category, @PathVariable Long id){
		Sales p= salesRepository.save(category);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="sales/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> deleteSales(@PathVariable Long id){
		salesRepository.delete(id);
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
