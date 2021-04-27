package ru.arturios.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.arturios.entity.Product;
import ru.arturios.repository.ProductRepository;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        return new Product();
    }

    @GetMapping()
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping()
    public void saveProduct(@RequestParam(required = false) String title, @RequestParam(required = false) Integer price) {
        productRepository.save(new Product().setTitle(title).setPrice(price));
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }


}
