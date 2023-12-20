package com.example.fashion.service.product.impl;
import com.example.fashion.dto.product.IProductDTO;
import com.example.fashion.dto.product.IProductInvoiceDto;
import com.example.fashion.dto.product.ProductDTO;
import com.example.fashion.dto.product.IProductResponse;
import com.example.fashion.repository.product.IProductRepository;
import com.example.fashion.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private IProductRepository productRepository;

    /**
     * created at 12/12/2023
     * LoanTTV
     * This method is used to get all products with these input parameters
     *
     * @param pageable
     * @param productName
     * @param minPrice
     * @param maxPrice
     * @param sizeName
     * @return Page<IProductDTO>
     */
    @Override
    public Page<IProductDTO> getAllProducts(Pageable pageable, String productName, Double minPrice, Double maxPrice, String sizeName) {
        return productRepository.findAll(pageable, productName, minPrice, maxPrice, sizeName);
    }

    /**
     * created at 12/12/2023
     * LoanTTV
     * @param productDTO
     */
    @Override
    public void createProduct(ProductDTO productDTO) {
        productRepository.save(productDTO);
    }

    /**
     * created at 12/12/2023
     * LoanTTV
     * @param productCode
     * @return
     */
    @Override
    public IProductDTO findByProductCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     *
     * @param pageable
     * @return: the page of products
     */
    @Override
    public Page<IProductResponse> findNewestProducts(Pageable pageable) {

        return iProductRepository.findNewestProducts(pageable);

    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     *
     * @param pageable
     * @return: the page of products having promotion greater than 0
     */
    @Override
    public Page<IProductResponse> findAllProductsHasPromotion(Pageable pageable) {

        return iProductRepository.findAllProductsHasPromotion(pageable);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     *
     * @param pageable
     * @return: the page of products for men
     */
    @Override
    public Page<IProductResponse> findAllProductsForMen(Pageable pageable) {

        return iProductRepository.findAllProductsForMen(pageable);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     *
     * @param pageable
     * @return: the page of products for women
     */
    @Override
    public Page<IProductResponse> findAllProductsForWomen(Pageable pageable) {

        return iProductRepository.findAllProductsForWomen(pageable);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     *
     * @param categoryName
     * @param pageable
     * @return the page of products by category name
     */
    @Override
    public Page<IProductResponse> findAllProductsByCategory(String categoryName, Pageable pageable) {

        return iProductRepository.findAllProductsByCategory(categoryName, pageable);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     *
     * @param name
     * @param pageable
     * @return: the page of products by product name
     */

    @Override
    public Page<IProductResponse> findAllProductsByName(String name, Pageable pageable) {

        return iProductRepository.findAllProductsByName(name, pageable);
    }


    /**
     * The method help to get list product.
     * @author NhatNk
     * @since 2023-12-14
     * @param keyword is String entered from input box on the screen
     * @return Null If the query at IProductRepository is incorrect and an exception occurs
     * @return list IProductInvoiceDto and 200 Ok If the query at IProductRepository is correct and no exception occurs
     * @see List<IProductInvoiceDto>
     */
    @Override
    public List<IProductInvoiceDto> getListProduct(String keyword) {
        try {
            return productRepository.getListProduct("%" + keyword + "%");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * The method help to get info IProductInvoiceDto.
     * @author NhatNk
     * @since 2023-12-14
     * @param productCode s parameter select from List Product
     * @return Null If the query at IProductRepository is incorrect and an exception occurs
     * @return IProductInvoiceDto and 200 Ok If the query at IProductRepository is correct and no exception occurs
     * @see IProductInvoiceDto
     */
    @Override
    public IProductInvoiceDto getProductByProductCode(String productCode) {
        try {
            return productRepository.getProductByProductCode(productCode);
        } catch (Exception e) {
            return null;
        }
    }
}