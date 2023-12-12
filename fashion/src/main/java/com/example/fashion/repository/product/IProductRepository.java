package com.example.fashion.repository.product;

import com.example.fashion.dto.product.IProductDTO;
import com.example.fashion.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

    @Query (nativeQuery = true, value = "select p.id as productId, p.product_code as productCode, p.name as productName, p.price as productPrice, s.name as sizeName, sd.quantity as productQuantity \n" +
            "from products p \n" +
            "join product_categories pc on p.category_id = pc.id\n" +
            "join size_details sd on p.id = sd.product_id\n" +
            "join sizes s on sd.size_id = s.id\n" +
            "where p.name like %:productName% \n" +
            "and p.price between :minPrice and :maxPrice \n" +
            "and s.name like %:sizeName% ")
    Page<IProductDTO> findAll(Pageable pageable, String productName, Double minPrice, Double maxPrice, String sizeName);
}
