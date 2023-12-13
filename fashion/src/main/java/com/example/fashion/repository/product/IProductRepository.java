package com.example.fashion.repository.product;

import com.example.fashion.dto.product.IProductResponse;
import com.example.fashion.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    /**
     * author: LyDTH
     * date: 13/12/2023
     * goal: get all products
     * @param pageable
     * @return
     */
    @Query(nativeQuery = true, value = " SELECT DISTINCT p.id as productId, p.name as productName, p.product_code as productCode, p.qr_code as qrCode,\n" +
            "   p.gender as gender,\n" +
            "   p.price as price, c.name as categoryName, pm.percent as percent\n" +
            "FROM products p\n" +
            "LEFT JOIN product_categories c ON p.category_id = c.id\n" +
            "LEFT JOIN size_details sd ON p.id = sd.product_id\n" +
            "LEFT JOIN sizes s ON s.id = sd.size_id\n" +
            "LEFT JOIN promotions pm ON p.promotion_id = pm.id "
    )
    Page<IProductResponse> findAllProducts(Pageable pageable);

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * Goal: get products having promotion greater than 0
     * @param pageable
     * @return
     */
    @Query(nativeQuery = true, value = "  SELECT p.id as productId, p.name as productName, p.product_code as productCode, p.qr_code as qrCode,\n" +
            "   p.gender as gender,\n" +
            "    p.price as price, c.name as categoryName, pm.percent as percent\n" +
            "FROM products p\n" +
            "LEFT JOIN product_categories c ON p.category_id = c.id\n" +
            "LEFT JOIN size_details sd ON p.id = sd.product_id\n" +
            "LEFT JOIN sizes s ON s.id = sd.size_id\n" +
            "LEFT JOIN promotions pm ON p.promotion_id = pm.id\n" +
            "WHERE pm.percent > 0 "
    )
    Page<IProductResponse> findAllProductsHasPromotion(Pageable pageable);

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * Goal: get products for men
     * @param pageable
     * @return
     */
    @Query(nativeQuery = true, value = "  SELECT p.id as productId, p.name as productName, p.product_code as productCode, p.qr_code as qrCode,\n" +
            "   p.gender as gender,\n" +
            "    p.price as price, c.name as categoryName, pm.percent as percent\n" +
            "FROM products p\n" +
            "LEFT JOIN product_categories c ON p.category_id = c.id\n" +
            "LEFT JOIN size_details sd ON p.id = sd.product_id\n" +
            "LEFT JOIN sizes s ON s.id = sd.size_id\n" +
            "LEFT JOIN promotions pm ON p.promotion_id = pm.id\n" +
            "WHERE p.gender = 0 "
           )
    Page<IProductResponse> findAllProductsForMen(Pageable pageable);

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * Goal: get products for men
     * @param pageable
     * @return
     */
    @Query(nativeQuery = true, value = "  SELECT p.id as productId, p.name as productName, p.product_code as productCode, p.qr_code as qrCode,\n" +
            "   p.gender as gender,\n" +
            "    p.price as price, c.name as categoryName, pm.percent as percent\n" +
            "FROM products p\n" +
            "LEFT JOIN product_categories c ON p.category_id = c.id\n" +
            "LEFT JOIN size_details sd ON p.id = sd.product_id\n" +
            "LEFT JOIN sizes s ON s.id = sd.size_id\n" +
            "LEFT JOIN promotions pm ON p.promotion_id = pm.id\n" +
            "WHERE p.gender = 1 "
      )
    Page<IProductResponse> findAllProductsForWomen(Pageable pageable);

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * Goal: get products for women/
     * @param categoryName
     * @param pageable
     * @return
     */
    @Query(nativeQuery = true, value = "  SELECT p.id as productId, p.name as productName, p.product_code as productCode, p.qr_code as qrCode,\n" +
            "   p.gender as gender,\n" +
            "    p.price as price, c.name as categoryName, pm.percent as percent\n" +
            "FROM products p\n" +
            "LEFT JOIN product_categories c ON p.category_id = c.id\n" +
            "LEFT JOIN size_details sd ON p.id = sd.product_id\n" +
            "LEFT JOIN sizes s ON s.id = sd.size_id\n" +
            "LEFT JOIN promotions pm ON p.promotion_id = pm.id\n" +
            "WHERE c.name like %:categoryName% "
           )
    Page<IProductResponse> findAllProductsByCategory(String categoryName, Pageable pageable);

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * Goal: get products by name
     * @param productName
     * @param pageable
     * @return
     */
    @Query(nativeQuery = true, value = "  SELECT p.id as productId, p.name as productName, p.product_code as productCode, p.qr_code as qrCode,\n" +
            "   p.gender as gender,\n" +
            "    p.price as price, c.name as categoryName, pm.percent as percent\n" +
            "FROM products p\n" +
            "LEFT JOIN product_categories c ON p.category_id = c.id\n" +
            "LEFT JOIN size_details sd ON p.id = sd.product_id\n" +
            "LEFT JOIN sizes s ON s.id = sd.size_id\n" +
            "LEFT JOIN promotions pm ON p.promotion_id = pm.id\n" +
            "WHERE p.name like %:productName% "
           )
    Page<IProductResponse> findAllProductsByName(String productName, Pageable pageable);

}
