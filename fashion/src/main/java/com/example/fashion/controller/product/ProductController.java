package com.example.fashion.controller.product;

import com.example.fashion.dto.product.IProductDTO;
import com.example.fashion.dto.product.ProductDTO;
import com.example.fashion.model.product.Product;
import com.example.fashion.model.product.Size;
import com.example.fashion.repository.product.IProductRepository;
import com.example.fashion.repository.product.ISizeDetailRepository;
import com.example.fashion.service.product.IProductService;
import com.example.fashion.service.product.ISizeDetailService;
import com.example.fashion.service.product.ISizeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ISizeDetailService sizeDetailService;

    @Autowired
    private ISizeService sizeService;

    /**
     * created at 12/12/2023
     * LoanTTV
     * method getAllProducts is used to get all products from database with input parameters
     * @param page
     * @param size
     * @param productName
     * @param sizeName
     * @param minPrice
     * @param maxPrice
     * @param sortDirection
     * @return Page<IProductDTO>
     */
    @GetMapping("/list")
    public ResponseEntity<Page<IProductDTO>> getAllProducts(@RequestParam (defaultValue = "0") int page,
                                                            @RequestParam (defaultValue = "5") int size,
                                                            @RequestParam (defaultValue = "", required = false) String productName,
                                                            @RequestParam (defaultValue = "", required = false) String sizeName,
                                                            @RequestParam (required = false) Double minPrice,
                                                            @RequestParam (required = false) Double maxPrice,
                                                            @RequestParam (required = false, defaultValue = "asc") String sortDirection) {
        Sort sort = sortDirection.equals("asc") ? Sort.by("productQuantity").ascending() : Sort.by("productQuantity").descending();
        maxPrice = maxPrice == null ? 1000000000d : maxPrice;
        minPrice = minPrice == null ? 0 : minPrice;
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<IProductDTO> result = productService.getAllProducts(pageable, productName, minPrice, maxPrice, sizeName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * created at 12/12/2023
     * LoanTTV
     * method createProduct is used to add new product to database and to validate product information
     * @param productDTO
     * @param bindingResult
     * @return Status code
     */
    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            HashMap<String, Object> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach( e -> errors.put(e.getField(), e.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            productService.createProduct(productDTO);
            Integer productId = productService.findByProductCode(productDTO.getProductCode()).getProductId();
            List<Integer> sizeDetailIdList = productDTO.getSizeDetailId();
            for(Integer i : sizeDetailIdList){
                sizeDetailService.save(productId, i);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @GetMapping("/size")
    public ResponseEntity<List<Size>> getAllSizes() {
        List<Size> sizeList = sizeService.getAllSize();
        if (sizeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sizeList, HttpStatus.OK);
    }

    @GetMapping("/size/{id}")
    public ResponseEntity<Size> findSizeById(@PathVariable Integer id) {
        Optional<Size> size = sizeService.findById(id);
        if (!size.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(size.get(), HttpStatus.OK);
    }

}
