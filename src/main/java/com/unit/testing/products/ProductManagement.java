package com.unit.testing.products;



import lombok.Data;
import java.util.ArrayList;
import java.util.List;


@Data
public class ProductManagement {

    private List<Product> products;

    public ProductManagement() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (products.stream().anyMatch(p -> p.getId() == product.getId())) {
            throw new IllegalArgumentException("Product ID already exists");
        }
        products.add(product);
    }

    public Product findProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public boolean isProductInStock(int id) {
        Product product = findProductById(id);
        if(product == null) {
            return false;
        }
        return product.getStock() > 0;
    }

    public void updateProductPrice(int id, double newPrice) {
        Product product = findProductById(id);
        product.setPrice(newPrice);
    }

    public void deleteProductFromStock(int id) {
        Product product = findProductById(id);
        if(product == null) {
            throw new IllegalArgumentException("Product ID does not exist");
        }
        products.remove(product);
    }
}
