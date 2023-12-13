package com.example.fashion.service.product;

import com.example.fashion.dto.product.IProductDTO;
import com.example.fashion.dto.product.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    /**
     * created at 12/12/2023
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
     * created at 12/12/2023
     * LoanTTV
     * @param productDTO
     */
    void createProduct(ProductDTO productDTO);

    /**
     * created at 12/12/2023
     * LoanTTV
     * @param productCode
     * @return
     */
    IProductDTO findByProductCode(String productCode);
}
