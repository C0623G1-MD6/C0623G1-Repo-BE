package com.example.fashion.controller.auth;

import com.example.fashion.dto.product.IProductResponse;
import com.example.fashion.model.product.Product;
import com.example.fashion.model.product.ProductCategory;
import com.example.fashion.service.product.IProductCategoryService;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/home")
@CrossOrigin("*")
public class HomePageController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductCategoryService productCategoryService;

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     *
     * @param option
     * @param sort
     * @return : the page of all products
     */
    @GetMapping
    public ResponseEntity<?> findAllProducts(
            @RequestParam(name = "option", defaultValue = "id",required = false) String option,
            @RequestParam(name = "sort", defaultValue = "DESC", required = false) String sort,
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page)
    {
        if (option == null || option.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(option).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(option).descending();
        } else {
            return ResponseEntity.badRequest().body("Sai tham số");
        }

        Pageable pageable = PageRequest.of(page, 20, sortable);
        Page<IProductResponse> products = productService.findAllProducts(pageable);
//        List<IProductResponse> products = null;
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     *
     * @param option
     * @param sort
     * @return: the page of products having promotion greater than 0
     */
    @GetMapping("/promotion")
    public ResponseEntity<?> findAllProductsHasPromotion(
            @RequestParam(required = false, name = "option", defaultValue = "price") String option,
            @RequestParam(name = "sort", defaultValue = "ASC") String sort,
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page) {

        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(option).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(option).descending();
        } else {
            return ResponseEntity.badRequest().body("Sai tham số");
        }

        Pageable pageable = PageRequest.of(page, 20, sortable);
        Page<IProductResponse> products = productService.findAllProductsHasPromotion(pageable);
//        List<IProductResponse> products = null;
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     *
     * @param option
     * @param sort
     * @return: the page of products for men
     */
    @GetMapping("/men")
    public ResponseEntity<?> findAllProductsForMen(@RequestParam(name = "option", defaultValue = "price", required = false) String option,
                                                   @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                                   @RequestParam(name = "page", defaultValue = "0", required = false) Integer page) {


        if (option == null || option.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(option).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(option).descending();
        } else {
            return ResponseEntity.badRequest().body("Sai tham số");
        }

        Pageable pageable = PageRequest.of(page, 20, sortable);
        Page<IProductResponse> products = productService.findAllProductsForMen(pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Author: LyDTH
     * Date: 12/12/2023
     *
     * @param option
     * @param sort
     * @return: the page of products for women
     */

    @GetMapping("/women")
    public ResponseEntity<?> findAllProductsForWomen(@RequestParam(name = "option", defaultValue = "price",required = false) String option,
                                                     @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                                     @RequestParam(name = "page", defaultValue = "0", required = false) Integer page) {

        if (option == null || option.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(option).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(option).descending();
        } else {
            return ResponseEntity.badRequest().body("Sai tham số");
        }

        Pageable pageable = PageRequest.of(page, 20, sortable);
        Page<IProductResponse> products = productService.findAllProductsForWomen(pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     *
     * @param option
     * @param sort
     * @param categoryName
     * @return: the page of products (by category name)
     */
    @GetMapping("/category")
    public ResponseEntity<?> findAllProductsByCategory(@RequestParam(name = "option",defaultValue = "price",required = false) String option,
                                                       @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                                       @RequestParam(name = "categoryName", required = false) String categoryName,
                                                       @RequestParam(name = "page", defaultValue = "0", required = false) Integer page) {

        if (option == null || option.isEmpty() || categoryName == null || categoryName.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(option).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(option).descending();
        } else {
            return ResponseEntity.badRequest().body("Sai tham số");
        }

        Pageable pageable = PageRequest.of(page, 20, sortable);
        Page<IProductResponse> products = productService.findAllProductsByCategory(categoryName, pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     *
     * @param option
     * @param sort
     * @param productName
     * @return: the page of products (by product name)
     */
    @GetMapping("/productName")
    public ResponseEntity<?> findAllProductsByName(@RequestParam(name = "option", defaultValue = "price",required = false) String option,
                                                   @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                                   @RequestParam(name = "productName") String productName,
                                                   @RequestParam(name = "page", defaultValue = "0", required = false) Integer page) {

        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(option).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(option).descending();
        } else {
            return ResponseEntity.badRequest().body("Sai tham số");
        }

        Pageable pageable = PageRequest.of(page, 20, sortable);
        Page<IProductResponse> products = productService.findAllProductsByName(productName, pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
//@GetMapping("/productCategory")
//    public ResponseEntity<List<ProductCategory>> findAllProductCategories() {
//        List<ProductCategory> productCategories = productCategoryService.getAllProductsCategory();
//        if(productCategories.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(productCategories, HttpStatus.OK);
//}


}


