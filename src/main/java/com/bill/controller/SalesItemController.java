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

import com.bill.entity.SalesItem;
import com.bill.repository.SalesItemRepository;

@RestController
public class SalesItemController {
	
	@Autowired
	private SalesItemRepository salesItemRepository;

	@RequestMapping(value = "sales/salesItem", method = RequestMethod.GET)
	public ResponseEntity<Iterable<SalesItem>> getAllSalesItem() {
		//Iterable<SalesItem> allSalesItem = salesItemRepository.findAll();
		return new ResponseEntity<>(salesItemRepository.findAll(), HttpStatus.OK);

	}

	@RequestMapping(value = "sales/salesItem", method = RequestMethod.POST)
	public ResponseEntity<?> createSales(@RequestBody SalesItem saleItem) {
		saleItem = salesItemRepository.save(saleItem);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newProductUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saleItem.getsItem_id())
				.toUri();
		responseHeaders.setLocation(newProductUri);
		//logic to delete stock
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

	}
	
	@RequestMapping(value="sales/salesItem/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getSalesItem(@PathVariable Long id){
		SalesItem p= salesItemRepository.findOne(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="sales/salesItem/{id}", method= RequestMethod.PUT)
	public ResponseEntity<?> updateSales(@RequestBody SalesItem category, @PathVariable Long id){
		salesItemRepository.save(category);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="sales/salesItem{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> deleteSales(@PathVariable Long id){
		salesItemRepository.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}


