package com.example.fashion.service.product;

import com.example.fashion.dto.product.IProductResponse;
import com.example.fashion.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

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
}
