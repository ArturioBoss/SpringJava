package ru.project.hibernate.service;

import ru.project.hibernate.dao.ConsumerDAO;
import ru.project.hibernate.dao.ProductDAO;
import ru.project.hibernate.entity.Consumer;
import ru.project.hibernate.entity.Product;

import java.util.List;

public class Service {
    private ConsumerDAO consumerDAO;
    private ProductDAO productDAO;

    public Service() {
        this.consumerDAO = ConsumerDAO.getInstance();
        this.productDAO = ProductDAO.getInstance();
    }

    public List<Product> getListOfPurchasedProducts(Long consumerId) {
        return consumerDAO.findById(consumerId).getProducts();
    }

    public List<Consumer> getListOfProductConsumers(Long productId) {
        return productDAO.findById(productId).getConsumers();
    }

}
