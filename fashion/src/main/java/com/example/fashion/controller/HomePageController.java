package com.example.fashion.controller;

import com.example.fashion.model.product.Product;
import com.example.fashion.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
@CrossOrigin("*")
public class HomePageController {
@Autowired
    private IProductService productService;

/**
 Author: LyDTH
 Date: 12/12/2023
 Goal: BackEnd Home Page
 **/
//@GetMapping
//    public ResponseEntity<Page<Product>> findAllProducts(@PageableDefault (value = 4) Pageable pageable){
//    Page<Product> products = productService.findAllProducts(pageable);
//    if(products.isEmpty()) {
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//    return new ResponseEntity<>(products, HttpStatus.OK);

//@GetMapping
//    public ResponseEntity<Page<Product>> findAllProductsByDescPrice(@PageableDefault(value = 4, sort = "price",direction = Sort.Direction.DESC) Pageable pageable) {
//    Page<Product> products = productService.findAllProducts(pageable);
//    if(products.isEmpty()) {
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//    return new ResponseEntity<>(products, HttpStatus.OK);
//}
//    @GetMapping
//    public ResponseEntity<Page<Product>> findAllProductsByAscPrice(@PageableDefault(value = 4, sort = "price",direction = Sort.Direction.ASC) Pageable pageable) {
//        Page<Product> products = productService.findAllProducts(pageable);
//        if(products.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
    @GetMapping
    public ResponseEntity<Page<Product>> findAllProductsByDescId(@PageableDefault(value = 4, sort = "id",direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Product> products = productService.findAllProductsByDescId(pageable);
        if(products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
//    @GetMapping
//    public ResponseEntity<Page<Product>> findAllProductsHasPromotion(@PageableDefault(value = 4) )
}
