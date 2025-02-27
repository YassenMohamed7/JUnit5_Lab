# JUnit5 Lab Tasks

This project contains JUnit5 tests to cover various scenarios for a product management system. The tasks focus on writing unit tests using JUnit5 annotations and features.

---

## Tasks

### **1. Basic Tests**
Create tests to cover all scenarios for the following:

#### a. Add Product to Stock
- **Objective:** Test the functionality of adding a product to the stock.
- **Annotations Used:** `@Test`, `@DisplayName`, `@BeforeEach`

#### b. Find Product by ID
- **Objective:** Test the functionality of finding a product by its ID.
- **Annotations Used:** `@Test`, `@DisplayName`, `@BeforeEach`

---

### **2. Parameterized Tests**
Write parameterized tests for the following:

#### a. Verify if Product is in Stock or Not
- **Objective:** Use `@CsvFileSource` to load test data from a CSV file and verify if a product is in stock.
- **Annotations Used:** `@ParameterizedTest`, `@CsvFileSource`

#### b. Update Product Price (Optional)
- **Objective:** Use `@MethodSource` to provide test data and update the product price.
- **Annotations Used:** `@ParameterizedTest`, `@MethodSource`

---

### **3. Exception Handling**
Test exception handling for the following:

#### a. Test `addProduct` for Duplicate IDs
- **Objective:** Verify that `addProduct` throws an `IllegalArgumentException` when adding a product with a duplicate ID.
- **Annotations Used:** `@Test`, `assertThrows`

---

### **4. Disabled Tests**
Disable tests based on specific conditions:

#### a. Disable Deleting Product Test for Your OS
- **Objective:** Disable the "delete product" test for your operating system.
- **Annotations Used:** `@Disabled` or `@DisabledOnOS`

---

## How to Run the Tests
1. Clone the repository.
2. Navigate to the project directory.
3. Write your tests
4. Run the tests using the following command:
   ```bash
   mvn test
