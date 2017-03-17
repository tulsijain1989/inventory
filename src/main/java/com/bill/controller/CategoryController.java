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
import com.bill.repository.CategoryRepository;

//SAVE,UPDATE,DELETE

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Category>> getAllCategory() {
		Iterable<Category> allCategory = categoryRepository.findAll();
		return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);

	}

	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public ResponseEntity<?> createCategory(@RequestBody Category category) {
		category = categoryRepository.save(category);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newCategoryUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getCategory_id())
				.toUri();
		responseHeaders.setLocation(newCategoryUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

	}
	
	@RequestMapping(value="categories/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getCategory(@PathVariable Long id){
		Category cat= new Category();
		cat.setCategory_id((long) 1);
		cat.setMeasurement("kg");
		cat.setName("cement");
		//Category p= categoryRepository.findOne(id);
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="categories/{id}", method= RequestMethod.PUT)
	public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable Long id){
		Category p= categoryRepository.save(category);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="categories/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> deleteCategory(@PathVariable Long id){
		categoryRepository.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
