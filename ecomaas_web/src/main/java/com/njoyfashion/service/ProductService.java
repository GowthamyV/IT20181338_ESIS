package com.njoyfashion.service;

import com.njoyfashion.converter.ProductConverter;
import com.njoyfashion.dto.ImageDto;
import com.njoyfashion.dto.ProductDto;
import com.njoyfashion.dto.ProductSaveDto;
import com.njoyfashion.entity.Category;
import com.njoyfashion.entity.Products;
import com.njoyfashion.entity.SubCategory;
import com.njoyfashion.repository.ProductRepository;
import com.njoyfashion.util.FTPFileUploadUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductConverter productConverter;
    @Autowired
    FTPFileUploadUtil ftpFileUploadUtil;

    String uploadPath = "/opt/productImages/";

    public List<ProductDto> getAllProducts() {
        List<Products> products = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Products product : products) {
            ProductDto productDto = productConverter.convert(product);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    public ProductDto getProductById(Long id) {
        Products product = productRepository.findById(id).orElseThrow();
        return productConverter.convert(product);
    }

    public List<ProductDto> getProductBySubCategoryId(Long subCategoryId) {
        SubCategory subCategory = new SubCategory();
        subCategory.setId(subCategoryId);
        List<Products> products = productRepository.findProductsBySubCategoryId(subCategory);
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Products product : products) {
            productDtoList.add(productConverter.convert(product));
        }
        return productDtoList;

    }

    public List<ProductDto> getProductByCategoryId(Long categoryId) {
        Category category = new Category();
        category.setId(categoryId);
        List<Products> products = productRepository.findProductsByCategoryId(category);
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Products product : products) {
            productDtoList.add(productConverter.convert(product));
        }
        return productDtoList;
    }

    public ProductDto saveProductDetails(ProductSaveDto productSaveDto) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(productSaveDto.getDescription());
        productDto.setSize(productSaveDto.getSize());
        productDto.setName(productSaveDto.getName());
        productDto.setSubCategoryDto(productSaveDto.getSubCategoryDto());
        productDto.setPrice(productSaveDto.getPrice());
        Products products = productConverter.convert(productDto);
        products = productRepository.save(products);
        if (products != null) {
            for (ImageDto imageDto : productSaveDto.getImageBase64()) {
                ftpFileUploadUtil.uploadBase64File("/opt/" + products.getId().toString() + "/", imageDto.getImageName(), imageDto.getImageBase64());
            }
            productDto = productConverter.convert(products);
        }

        return productDto;
    }

//    public File convert(String productID, String base64Image) {
//        Path path = null;
//        File newFile = null;
//        try {
//            byte[] decodedBytes = Base64.getDecoder().decode(base64Image);
//            new File(uploadPath + productID).mkdirs();
//            path = Paths
//                    .get(uploadPath + productID );
//            BufferedImage image = ImageIO.read(new ByteArrayInputStream(decodedBytes));
//            File file = new File(
//                    uploadPath + productID );
//            ImageIO.write(image, "jpeg", file);
//            newFile = path.toFile();
//        } catch (Exception e) {
//
//        }
//        return newFile;
//    }
}
