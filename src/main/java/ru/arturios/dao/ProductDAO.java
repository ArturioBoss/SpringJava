package ru.arturios.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.arturios.entity.Product;

import javax.persistence.Query;
import java.util.List;

public class ProductDAO {

    private static ProductDAO productDAO;
    private SessionFactory factory;
    private Session session;

    private ProductDAO() {
        factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();
        session = factory.openSession();
    }

    public static ProductDAO getInstance() {
        if (productDAO == null) {
            productDAO = new ProductDAO();
        }
        return productDAO;
    }

    public Product findById(Long id) {
        Query query = session.createQuery("select p from Product p where p.id = :id");
        query.setParameter("id", id);
        return (Product) query.getSingleResult();
    }

    public List<Product> findAll() {
        return (List<Product>) session.createQuery("select p from Product p").getResultList();
    }

    public void deleteById(Long id) {
        Product product = session.find(Product.class, id);
        session.getTransaction().begin();
        session.remove(product);
        session.getTransaction().commit();
    }

    public Product saveOrUpdate(Product product) {
        session.getTransaction().begin();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        return product;
    }

    public Session getSession() {
        return session;
    }
}