package com.unit.testing.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


class ProductManagerTest {

    private ProductManager productManagement;

    @BeforeEach
     void setUp(){
        productManagement = new ProductManager();
    }
    private void addProduct(){
        Product product =  Product.builder().id(1).name("Coffee").price(250).stock(1000).build();
        productManagement.addProduct(product);
    }

    @Test
    @DisplayName("Add product test")
    @DisabledOnOs(value = OS.WINDOWS)
    void givenValidProduct_WhenAddProduct_ExpectSuccess() {
        addProduct();
        assertEquals( 1, productManagement.getProducts().size());
        assertEquals(250, productManagement.findProductById(1).getPrice());
    }

    @Test
    @DisplayName("Add invalid product to stock")
    void givenAlreadyExistedProduct_WhenAddProduct_ExpectFailure() {
        addProduct();
        Product product =  Product.builder().id(1).name("Tea").price(100).stock(500).build(); // this id is already existed
        assertThrows(IllegalArgumentException.class, () -> productManagement.addProduct(product));

    }

    @ParameterizedTest
    @DisplayName("Update product test")
    @MethodSource("provideDataToUpdateTests")
    void updateProductTest(int id, double price, double expectedPrice) {
        if(productManagement.findProductById(1) == null)
            addProduct();
        assumeTrue(productManagement.findProductById(id) != null); ;
        productManagement.updateProductPrice(id, price);
        assertEquals(expectedPrice, productManagement.findProductById(1).getPrice());
    }

    private static Stream<Arguments> provideDataToUpdateTests(){
        return Stream.of(
                Arguments.of(1, 1000, 1000),
                Arguments.of(2, 500, 500)
        );
    }

    @Tag("CSV_FILE_SOURCE")
    @ParameterizedTest
    @CsvFileSource(resources = "/statusData.csv", numLinesToSkip = 1)
    @DisplayName("product stock status")
    void productStockStatusTest(String id, String status) {
        if(productManagement.findProductById(1) == null)
            addProduct();
        assertEquals(Boolean.parseBoolean(status), productManagement.isProductInStock(Integer.parseInt(id)));
    }




}