package ru.arturios.repository;

import org.springframework.data.repository.CrudRepository;
import ru.arturios.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
