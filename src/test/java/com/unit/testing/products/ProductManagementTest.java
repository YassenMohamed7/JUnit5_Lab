package com.unit.testing.products;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductManagerTest {
    private final ProductManager productManager;

    ProductManagerTest() {
        this.productManager = new ProductManager();
    }

    @Test
    @DisplayName("Successfully adding product to stock")
    public void addProduct() {
        Product product = Product
                .builder()
                .setId(1)
                .setName("Product 1")
                .setPrice(100)
                .setPrice(500)
                .build();
        productManager.addProduct(product);
        assertEquals(product, productManager.findProductById(1));
    }

}