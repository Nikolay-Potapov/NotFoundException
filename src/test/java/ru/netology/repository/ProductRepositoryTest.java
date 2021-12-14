package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product item9 = new Product(9, "Samsung", 15100);
    private Product item10 = new Product(10, "Meizu", 12500);
    private Product item11 = new Product(11, "Honor", 13000);

    @BeforeEach
    public void managerSave() {
        repository.save(item9);
        repository.save(item10);
        repository.save(item11);
    }

    @Test
    public void shouldRemoveByWrongId() {
        int idToRemove = 23;
        assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));

    }


    @Test
    public void shouldRemoveByRightId() {
        int idToRemove = 9;
        repository.removeById(idToRemove);
        Product[] expected = new Product[]{item10, item11};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}