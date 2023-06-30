package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "Product1", 675);
    Product product2 = new Product(2, "Product 2", 65 - 988 - 555);
    Product product3 = new Product(3, "Product 3", 4);

    @BeforeEach
    public void setup() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

    }

    @Test
    public void shouldAddProduct() {

        Product[] expected = {product1, product3};
        Product[] actual = repo.removeById(product2.getId());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionRemoveById() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(446);
        });
    }


}


