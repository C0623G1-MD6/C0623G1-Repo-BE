package com.example.fashion.service.product.impl;
import com.example.fashion.model.product.Size;
import com.example.fashion.dto.product.ISizeDto;
import com.example.fashion.repository.product.ISizeRepository;
import com.example.fashion.service.product.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SizeServiceImpl implements ISizeService {
    @Autowired
    private ISizeRepository sizeRepository;

    /**
     * NhatNk
     * @param productCode
     * @return
     */
    @Override
    public List<ISizeDto> getListSizeByProductCode(String productCode) {
        try {
            return sizeRepository.getListSizeByProductCode(productCode);
        } catch (Exception e){
            return null;
        }
    }

    /**
     * LoanTTV
     * @return List<Size>
     */
    @Override
    public List<Size> getAllSize() {
        return sizeRepository.findAll();
    }

    @Override
    public List<ISizeDto> getAllSizes(Integer productId) {
        return sizeRepository.getListSizeByProductId(productId);
    }

//    @Override
//    public Optional<Size> findById(Integer id) {
//        return iSizeRepository.findSizeBySizeId(id);
//    }
}
