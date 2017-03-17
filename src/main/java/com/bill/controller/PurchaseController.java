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

import com.bill.entity.Purchase;
import com.bill.repository.PurchaseRepository;

@RestController
public class PurchaseController {
	
	@Autowired
	private PurchaseRepository purchaseRepository;

	@RequestMapping(value = "/purchases", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Purchase>> getAllProducts() {
		Iterable<Purchase> allPurchase = purchaseRepository.findAll();
		return new ResponseEntity<>(purchaseRepository.findAll(), HttpStatus.OK);

	}

	@RequestMapping(value = "/purchases", method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@RequestBody Purchase category) {
		category = purchaseRepository.save(category);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newProductUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getPurchase_id())
				.toUri();
		responseHeaders.setLocation(newProductUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

	}
	
	@RequestMapping(value="purchases/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getPurchase(@PathVariable Long id){
		Purchase p= purchaseRepository.findOne(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="purchases/{id}", method= RequestMethod.PUT)
	public ResponseEntity<?> updatePurchase(@RequestBody Purchase category, @PathVariable Long id){
		Purchase p= purchaseRepository.save(category);
		//logic to update stock
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="purchases/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> deletePurchase(@PathVariable Long id){
		purchaseRepository.delete(id);
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
