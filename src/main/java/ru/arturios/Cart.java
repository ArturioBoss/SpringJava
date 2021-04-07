package ru.arturios;

import org.springframework.stereotype.Controller;
import ru.arturios.products.Product;
import ru.arturios.products.ProductRepository;

@Controller
public class Cart {

    private final ProductRepository productRepository;

    private Product product;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(String name, int price) {
        int qvant = productRepository.getAll().size()+1;
        product = new Product(String.valueOf(qvant),name,price);
        productRepository.merge(product);
        System.out.println("Товар "+name+" был добавлен");
    }

    public void delete(String product) {
        String s = productRepository.getById(product).getName();
        productRepository.getAll().remove(productRepository.getById(product));
        System.out.println("Товар "+s+" был удалён");
    }
}
