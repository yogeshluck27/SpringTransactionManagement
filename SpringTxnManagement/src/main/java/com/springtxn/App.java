package com.springtxn;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springtxn.config.ProductConfig;
import com.springtxn.service.ProductService;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
    	context.registerShutdownHook();
    	ProductService service = context.getBean(ProductService.class);
    	service.saveProductInfo();
    	context.close();

    }
}
