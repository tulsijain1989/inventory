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

import com.bill.entity.Category;
import com.bill.entity.Product;
import com.bill.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Product>> getAllProducts() {
		Iterable<Product> allProduct = productRepository.findAll();
		return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);

	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@RequestBody Product category) {
		category = productRepository.save(category);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newProductUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getProduct_id())
				.toUri();
		responseHeaders.setLocation(newProductUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

	}
	
	@RequestMapping(value="products/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getPoll(@PathVariable Long id){
		Product p= productRepository.findOne(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="products/{id}", method= RequestMethod.PUT)
	public ResponseEntity<?> updateProduct(@RequestBody Product category, @PathVariable Long id){
		Product p= productRepository.save(category);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="products/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@PathVariable Long id){
		productRepository.delete(id);
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
