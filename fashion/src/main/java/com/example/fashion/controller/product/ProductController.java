package com.example.fashion.controller.product;

import com.example.fashion.dto.product.IProductDTO;
import com.example.fashion.dto.product.ProductDTO;
import com.example.fashion.model.product.ProductCategory;
import com.example.fashion.model.product.Promotion;
import com.example.fashion.model.product.Size;
import com.example.fashion.service.product.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ISizeDetailService sizeDetailService;

    @Autowired
    private ISizeService sizeService;

    @Autowired
    private IPromotionService promotionService;

    @Autowired
    private IProductCategoryService productCategoryService;

    /**
     * created on 12/12/2023
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
                                                            @RequestParam (defaultValue = "", required = false) String productCode,
                                                            @RequestParam (defaultValue = "", required = false) String sizeName,
                                                            @RequestParam (required = false) Double minPrice,
                                                            @RequestParam (required = false) Double maxPrice,
                                                            @RequestParam (required = false, defaultValue = "desc") String sortDirection,
                                                            @RequestParam (required = false, defaultValue = "createdDate") String sortBy){
        Sort sort = sortDirection.equals("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        maxPrice = maxPrice == null ? 1000000000d : maxPrice;
        minPrice = minPrice == null ? 0 : minPrice;
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<IProductDTO> result = productService.getAllProducts(pageable, productName, productCode, minPrice, maxPrice, sizeName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * created on 12/12/2023
     * LoanTTV
     * method createProduct is used to add new product to database and to validate product information
     * @param productDTO
     * @param bindingResult
     * @return Status code
     */

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO productDTO
            , BindingResult bindingResult) {
        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setProductService(productService);
        productDTO1.validate(productDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            HashMap<String, Object> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach( e -> errors.put(e.getField(), e.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            LocalDateTime localDate = new Date().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            productDTO.setCreatedDate(localDate);
            productService.createProduct(productDTO);
            Integer productId = productService.findByProductCode(productDTO.getProductCode()).getProductId();
            List<Integer> sizeDetailIdList = productDTO.getSizeId();
            for(Integer i : sizeDetailIdList){
                sizeDetailService.save(productId, i);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Created on 15/12/2023
     * LoanTTV
     * This method is used to get all sizes
     * @return Status code
     */
    @GetMapping("/size")
    public ResponseEntity<?> getAllSizes() {
        List<Size> sizeList = sizeService.getAllSize();
        if (sizeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sizeList, HttpStatus.OK);
    }

    /**
     * Created on 15/12/2023
     * LoanTTV
     * This method is used to get all promotions
     * @return Status code
     */
    @GetMapping("/promotion")
    public ResponseEntity<?> getAllPromotions() {
        List<Promotion> promotionList = promotionService.getAllPromotions();
        if (promotionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(promotionList, HttpStatus.OK);
    }

    /**
     * Created on 15/12/2023
     * LoanTTV
     * This method is used to get all categories
     * @return Status code
     */
    @GetMapping("/category")
    public ResponseEntity<?> getAllCategories() {
        List<ProductCategory> categoryList = productCategoryService.getAllCategories();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

}
