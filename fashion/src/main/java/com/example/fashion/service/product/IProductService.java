package com.example.fashion.service.product;

import com.example.fashion.dto.product.IProductDTO;
import com.example.fashion.dto.product.IProductInvoiceDto;
import com.example.fashion.dto.product.ProductDTO;
import com.example.fashion.dto.product.IProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IProductService {

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param pageable
     */
    Page<IProductResponse> findAllProducts( Pageable pageable);

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param pageable
     */
    Page<IProductResponse> findAllProductsHasPromotion(Pageable pageable);

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param pageable
     */
    Page<IProductResponse> findAllProductsForMen(Pageable pageable);

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param pageable
     */
    Page<IProductResponse> findAllProductsForWomen(Pageable pageable);

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param categoryName
     * @param pageable
     */
    Page<IProductResponse> findAllProductsByCategory(String categoryName ,Pageable pageable);

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param name
     * @param pageable
     */
    Page<IProductResponse> findAllProductsByName(String name , Pageable pageable);
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



    List<IProductInvoiceDto> getListProduct(String keyword);
    IProductInvoiceDto getProductByProductCode(String productCode);
}
