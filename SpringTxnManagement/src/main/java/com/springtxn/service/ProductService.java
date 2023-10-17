package com.springtxn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springtxn.dto.Product;
import com.springtxn.repository.ProductRepo;

@Component
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
	/*@Transactional
	public void saveProductInfo(){
		try{
			for(int i=1;i<=10;i++){
				Product product = new Product();
				product.setId(i);
				product.setpName("Test Product "+i);
				productRepo.saveProduct(product);
				
				if(i==7){
					throw new RuntimeException("Some Error Occured...");
				}

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}*/
	
	//@Transactional
	/*@Transactional(rollbackFor=Exception.class)
	public void saveProductInfo() throws Exception{
		
			for(int i=1;i<=10;i++){
				Product product = new Product();
				product.setId(i);
				product.setpName("Test Product "+i);
				productRepo.saveProduct(product);
				
				if(i==7){
					throw new Exception("Some Error Occured...");
				}

			}
		
	}*/

	
	//@Transactional
	@Transactional(noRollbackFor=RuntimeException.class)
	public void saveProductInfo() {
		
			for(int i=1;i<=10;i++){
				Product product = new Product();
				product.setId(i);
				product.setpName("Test Product "+i);
				productRepo.saveProduct(product);
				
				if(i==7){
					throw new RuntimeException("Some Error Occured...");
				}

			}
	
	}
}
