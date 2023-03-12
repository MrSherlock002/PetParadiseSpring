package com.pet.controller;

import com.pet.entities.Product;
import com.pet.exception.ProductNotFoundException;
import com.pet.service.ProductsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Products REST Mappings using productsService aggregation
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductsController {

    // injects the object dependency
    @Autowired
    private ProductsServiceImpl productsService;

    // create
    @PostMapping("/add")
    public Product addProduct(@Valid @RequestBody Product products) {
    	System.out.println("inside add products controller");
        return productsService.addProducts(products);
    }

    // update
    @PutMapping("/update")
    public Product updateProducts(@Valid @RequestBody Product products) throws ProductNotFoundException {
        return productsService.updateProducts(products);
    }

    // delete
    @DeleteMapping("/remove/{productsId}")
    public Product removeProducts(@PathVariable int productsId) throws ProductNotFoundException {
        return productsService.deleteProducts(productsId);
    }

    // read
    @GetMapping("/view/{productsId}")
    public Product getProducts(@PathVariable int productsId) throws ProductNotFoundException {
        Product products = new Product();
        products.setProductId(productsId);
        return productsService.viewProducts(products);
    }

    // read
    @GetMapping("/show")
    public List<Product> getAllProductss() {
        return productsService.showAllProducts();
    }
}
