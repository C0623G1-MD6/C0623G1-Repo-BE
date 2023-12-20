package com.example.fashion.controller.auth;

import com.example.fashion.dto.product.IProductResponse;
import com.example.fashion.dto.product.ISizeDto;
import com.example.fashion.service.product.IProductCategoryService;
import com.example.fashion.service.product.IProductService;
import com.example.fashion.service.product.ISizeDetailService;
import com.example.fashion.service.product.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home")
@CrossOrigin("*")
public class HomePageController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductCategoryService productCategoryService;
    @Autowired
    private ISizeService sizeService;

    @Autowired
    private ISizeDetailService sizeDetailService;

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     *
     * @param option
     * @param sort
     * @return : the page of all products
     */
    @GetMapping
    public ResponseEntity<?> findNewestProducts(
            @RequestParam(name = "option", defaultValue = "price",required = false) String option,
            @RequestParam(name = "sort", defaultValue = "ASC", required = false) String sort,
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
        Page<IProductResponse> products = productService.findNewestProducts(pageable);
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

        Pageable pageable = PageRequest.of(page, 8, sortable);
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

        Pageable pageable = PageRequest.of(page, 8, sortable);
        Page<IProductResponse> products = productService.findAllProductsByName(productName, pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/sizes/{productCode}")
    public ResponseEntity<List<ISizeDto>> getListSizeByProductCode(@PathVariable String productCode){
        List<ISizeDto> iSizeDtoList = sizeService.getListSizeByProductCode(productCode);
        if (iSizeDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iSizeDtoList,HttpStatus.OK);
    }
}


