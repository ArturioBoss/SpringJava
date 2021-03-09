package ru.arturios.products;

import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class ProductRepository {

    private AtomicInteger sequence = new AtomicInteger();

    private Map<String, Product> productMap = Collections.synchronizedMap(new LinkedHashMap<>());

    public ProductRepository() {
        this.merge(new Product("1", "Книги",  50));
        this.merge(new Product("2", "Мышь", 150));
        this.merge(new Product("3", "Клавиатура", 200));
        this.merge(new Product("4", "Компьютер", 500));
        sequence.set(productMap.size());
    }

    public void merge(Product product) {
        if (!productMap.containsKey(product.getId())) {
            product.setId(String.valueOf(sequence.incrementAndGet()));
        }
        productMap.put(product.getId(), product);
    }

    public Collection<Product> getAll() {
        return productMap.values();
    }

    public Product getById(String id) {
        return productMap.get(id);
    }
}
