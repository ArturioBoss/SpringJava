package ru.project.hibernate.dao;

import ru.project.hibernate.entity.Product;

import javax.persistence.Query;
import java.util.List;

public class ProductDAO extends DAO {

    private static ProductDAO productDAO;

    private ProductDAO() {
        super();
    }

    public static ProductDAO getInstance() {
        if (productDAO == null) {
            productDAO = new ProductDAO();
        }
        return productDAO;
    }

    public Product findById(Long id) {
        Query query = getSession().createQuery("select p from Product p where p.id = :id");
        query.setParameter("id", id);
        return (Product) query.getSingleResult();
    }

    public List<Product> findAll() {
        return (List<Product>) getSession().createQuery("select p from Product p").getResultList();
    }

    public void deleteById(Long id) {
        Product product = getSession().find(Product.class, id);
        getSession().getTransaction().begin();
        getSession().remove(product);
        getSession().getTransaction().commit();
    }

    public Product saveOrUpdate(Product product) {
        getSession().getTransaction().begin();
        getSession().saveOrUpdate(product);
        getSession().getTransaction().commit();
        return product;
    }
}
