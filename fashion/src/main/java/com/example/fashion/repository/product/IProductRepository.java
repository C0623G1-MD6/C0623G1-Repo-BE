package com.example.fashion.repository.product;

import com.example.fashion.dto.product.IProductDTO;
import com.example.fashion.dto.product.ProductDTO;
import com.example.fashion.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    /**
     * created at 12/12/2023
     * LoanTTV
     * @param pageable
     * @param productName
     * @param minPrice
     * @param maxPrice
     * @param sizeName
     * @return Page<IProductDTO>
     */
    @Query(nativeQuery = true, value = "select p.id as productId, p.product_code as productCode, p.name as productName, p.price as productPrice, s.name as sizeName, sd.quantity as productQuantity \n" +
            "from products p \n" +
            "join product_categories pc on p.category_id = pc.id\n" +
            "join size_details sd on p.id = sd.product_id\n" +
            "join sizes s on sd.size_id = s.id\n" +
            "where p.name like %:productName% \n" +
            "and p.price between :minPrice and :maxPrice \n" +
            "and s.name like %:sizeName% ")
    Page<IProductDTO> findAll(Pageable pageable, String productName, Double minPrice, Double maxPrice, String sizeName);

    /**
     * created at 12/12/2023
     * LoanTTV
     * @param productDTO
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO products (gender, name, price, product_code, product_image, qr_code, category_id, promotion_id)\n" +
            "VALUES (:#{#productDTO.gender}, :#{#productDTO.name}, :#{#productDTO.price}, :#{#productDTO.productCode}, " +
            ":#{#productDTO.productImage}, :#{#productDTO.qrCode}, :#{#productDTO.categoryId}, :#{#productDTO.promotionId})")
    void save(@Param("productDTO") ProductDTO productDTO);

    /**
     * created at 12/12/2023
     * LoanTTV
     * @param productCode
     * @return IProductDTO
     */
    @Query(nativeQuery = true, value = "select id as productId from products where product_code = :productCode")
    IProductDTO findByProductCode(String productCode);
}
