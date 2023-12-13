package com.example.fashion.service.product;

import com.example.fashion.dto.product.IProductDTO;
import com.example.fashion.dto.product.ProductDTO;
import com.example.fashion.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IProductService {
    /**
     * LoanTTV
     * @param pageable
     * @param productName
     * @param minPrice
     * @param maxPrice
     * @param sizeName
     * @return
     */
    Page<IProductDTO> getAllProducts(Pageable pageable, String productName, Double minPrice, Double maxPrice, String sizeName);

    /**
     * LoanTTV
     * @param productDTO
     */
    void createProduct(ProductDTO productDTO);

    /**
     * LoanTTV
     * @param productCode
     * @return
     */
    IProductDTO findByProductCode(String productCode);

    Page<Product> findAllProducts(String option, Pageable pageable);
//    Page<Product> findAllProductsByDescId(Pageable pageable);
    Page<Product> findAllProductsHasPromotion(String option, Pageable pageable);
    Page<Product> findAllProductsForMen(String option, Pageable pageable);
    Page<Product> findAllProductsForWomen(String option, Pageable pageable);
    Page<Product> findAllProductsByCategory(Integer chosenId ,String option, Pageable pageable);
    Page<Product> findAllProductsByName(String name ,String option, Pageable pageable);
}
