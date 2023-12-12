package com.example.fashion.repository.product;

import com.example.fashion.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(nativeQuery = true, value = "SELECT p.id, p.name, p.product_code, p.qr_code, p.gender, p.price, c.naproductsme, pm.percent\n" +
            "FROM products p\n" +
            "LEFT JOIN product_categories c ON p.category_id = c.id\n" +
            "LEFT JOIN size_details sd ON p.id = sd.product_id\n" +
            "LEFT JOIN sizes s ON s.id = sd.size_id\n" +
            "LEFT JOIN promotions pm ON p.promotion_id = pm.id\n" +
            "ORDER BY :param ;")
    Page<Product> findAllProducts(@Param("param")String option, Pageable pageable);

//    @Query(nativeQuery = true, value = "SELECT p.id, p.name, p.product_code, p.qr_code, p.gender, p.price, c.name, pm.percent\n" +
//            "FROM products p\n" +
//            "Left JOIN product_categories c ON p.category_id = c.id\n" +
//            "Left JOIN size_details sd ON p.id = sd.product_id\n" +
//            "Left JOIN sizes s ON s.id = sd.size_id\n" +
//            "LEFT JOIN promotions pm ON p.promotion_id = pm.id\n" +
//            "ORDER BY p.id DESC;")
//    Page<Product> findAllProductsByDescId(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT p.id, p.name, p.product_code, p.qr_code, p.gender, p.price, c.name, pm.percent\n" +
            "FROM products p\n" +
            "LEFT JOIN product_categories c ON p.category_id = c.id\n" +
            "LEFT JOIN size_details sd ON p.id = sd.product_id\n" +
            "LEFT JOIN sizes s ON s.id = sd.size_id\n" +
            "LEFT JOIN promotions pm ON p.promotion_id = pm.id\n" +
            "WHERE pm.percent > 0\n" +
    "ORDER BY :param ;")
    Page<Product> findAllProductsHasPromotion(@Param("param")String option, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT p.id, p.name, p.product_code, p.qr_code, p.gender, p.price, c.name, pm.percent\n" +
            "FROM products p\n" +
            "LEFT JOIN product_categories c ON p.category_id = c.id\n" +
            "LEFT JOIN size_details sd ON p.id = sd.product_id\n" +
            "LEFT JOIN sizes s ON s.id = sd.size_id\n" +
            "LEFT JOIN promotions pm ON p.promotion_id = pm.id\n" +
            "WHERE p.gender = 0\n" +
    "ORDER BY :param ;")
    Page<Product> findAllProductsForMen(@Param("param")String option, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT p.id, p.name, p.product_code, p.qr_code, p.gender, p.price, c.name, pm.percent\n" +
            "FROM products p\n" +
            "LEFT JOIN product_categories c ON p.category_id = c.id\n" +
            "LEFT JOIN size_details sd ON p.id = sd.product_id\n" +
            "LEFT JOIN sizes s ON s.id = sd.size_id\n" +
            "LEFT JOIN promotions pm ON p.promotion_id = pm.id\n" +
            "WHERE p.gender = 1\n" +
            "ORDER BY :param ;")
    Page<Product> findAllProductsForWomen(@Param("param")String option, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT p.id, p.name, p.product_code, p.qr_code, p.gender, p.price,c.id, c.name, pm.percent\n" +
            "FROM products p\n" +
            "LEFT JOIN product_categories c ON p.category_id = c.id\n" +
            "LEFT JOIN size_details sd ON p.id = sd.product_id\n" +
            "LEFT JOIN sizes s ON s.id = sd.size_id\n" +
            "LEFT JOIN promotions pm ON p.promotion_id = pm.id\n" +
            "WHERE c.id = :param1\n" +
            "ORDER BY :param2 ;")
    Page<Product> findAllProductsByCategory(@Param("param1") Integer chosenId, @Param("param2") String option ,Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT p.id, p.name, p.product_code, p.qr_code, p.gender, p.price, c.name, pm.percent\n" +
            "FROM products p\n" +
            "LEFT JOIN product_categories c ON p.category_id = c.id\n" +
            "LEFT JOIN size_details sd ON p.id = sd.product_id\n" +
            "LEFT JOIN sizes s ON s.id = sd.size_id\n" +
            "LEFT JOIN promotions pm ON p.promotion_id = pm.id\n" +
            "WHERE p.name like %:param1%\n" +
    "ORDER BY :param2 ;")
    Page<Product> findAllProductsByName(@Param("param1") String name, @Param("param2") String option ,Pageable pageable);

}
