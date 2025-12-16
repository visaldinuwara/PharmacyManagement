package Service;

import Model.DTO.ProductDetailsDTO;
import Model.Entity.ProductDetails;
import Repository.ProductRepository;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class ProductService {
    private ProductRepository productRepository;
    public ProductService(){
        productRepository=new ProductRepository();
    }
    public void addProduct(ProductDetailsDTO productDetailsDTO) throws SQLException {
        productRepository.addProduct(new ProductDetails("1",productDetailsDTO.getName(),productDetailsDTO.getBrand(),productDetailsDTO.getExpiry(),productDetailsDTO.getQuantity(),productDetailsDTO.getPrice()));
    }

    public void deleteProduct(String text) throws SQLException {
        productRepository.deleteProduct(text);
    }

    public ProductDetails searchProduct(String text) throws SQLException {
        return productRepository.searchProduct(text);
    }

    public void updateProduct(ProductDetails productDetails) throws SQLException {
        productRepository.updateProduct(new ProductDetails(productDetails.getId(),productDetails.getName(),productDetails.getBrand(),productDetails.getExpiry(),productDetails.getQuantity(),productDetails.getPrice()));
    }

    public ObservableList getAll() throws SQLException {
        return productRepository.getAllProducts();
    }
}
