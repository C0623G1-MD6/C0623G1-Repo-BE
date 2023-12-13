package com.example.fashion.controller;

import com.example.fashion.dto.product.IProductResponse;
import com.example.fashion.model.product.Product;
import com.example.fashion.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
@CrossOrigin("*")
public class HomePageController {
    @Autowired
    private IProductService productService;

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param option
     * @param sort
     * @return : the page of all products
     */
    @GetMapping
    public ResponseEntity<?> findAllProductsByOption(
            @RequestParam(name = "option", defaultValue = "price") String option,
            @RequestParam(name = "sort", defaultValue = "ASC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(option).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(option).descending();
        }else {
            return ResponseEntity.badRequest().body("Sai tham số");
        }

        Pageable pageable = PageRequest.of(0, 28, sortable);
        Page<IProductResponse> products = productService.findAllProducts( pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param option
     * @param sort
     * @return: the page of products having promotion greater than 0
     */
    @GetMapping("/promotion")
    public ResponseEntity<?> findAllProductsHasPromotion(
            @RequestParam(name = "option", defaultValue = "price") String option,
            @RequestParam(name = "sort", defaultValue = "ASC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(option).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(option).descending();
        }else {
            return ResponseEntity.badRequest().body("Sai tham số");
        }

        Pageable pageable = PageRequest.of(0, 28, sortable);
        Page<IProductResponse> products = productService.findAllProductsHasPromotion( pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param option
     * @param sort
     * @return: the page of products for men
     */
    @GetMapping("/men")
    public ResponseEntity<?> findAllProductsForMen(@RequestParam(name = "option", defaultValue = "price") String option,
                                                   @RequestParam(name = "sort", defaultValue = "ASC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(option).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(option).descending();
        }else {
            return ResponseEntity.badRequest().body("Sai tham số");
        }

        Pageable pageable = PageRequest.of(0, 28, sortable);
        Page<IProductResponse> products = productService.findAllProductsForMen( pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Author: LyDTH
     * Date: 12/12/2023
     * @param option
     * @param sort
     * @return: the page of products for women
     */

    @GetMapping("/women")
    public ResponseEntity<?> findAllProductsForWomen(@RequestParam(name = "option", defaultValue = "price") String option,
                                                     @RequestParam(name = "sort", defaultValue = "ASC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(option).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(option).descending();
        }else {
            return ResponseEntity.badRequest().body("Sai tham số");
        }

        Pageable pageable = PageRequest.of(0, 28, sortable);
        Page<IProductResponse> products = productService.findAllProductsForWomen( pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param option
     * @param sort
     * @param categoryName
     * @return: the page of products (by category name)
     */
    @GetMapping("/category")
    public ResponseEntity<?> findAllProductsByCategory(@RequestParam(name = "option", defaultValue = "price") String option,
                                                       @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                                       @RequestParam(name = "categoryName") String categoryName) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(option).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(option).descending();
        }else {
            return ResponseEntity.badRequest().body("Sai tham số");
        }

        Pageable pageable = PageRequest.of(0, 4, sortable);
        Page<IProductResponse> products = productService.findAllProductsByCategory(categoryName, pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param option
     * @param sort
     * @param productName
     * @return: the page of products (by product name)
     */
    @GetMapping("/productName")
    public ResponseEntity<?> findAllProductsByName(@RequestParam(name = "option", defaultValue = "price") String option,
                                                       @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                                       @RequestParam(name = "productName") String productName) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(option).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(option).descending();
        }else {
            return ResponseEntity.badRequest().body("Sai tham số");
        }

        Pageable pageable = PageRequest.of(0, 4, sortable);
        Page<IProductResponse> products = productService.findAllProductsByName(productName, pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}


