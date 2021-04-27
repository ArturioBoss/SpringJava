package ru.project.hibernate.dao;

import ru.project.hibernate.entity.Consumer;
import ru.project.hibernate.entity.Product;

import javax.persistence.Query;
import java.util.List;

public class ConsumerDAO extends DAO {

    private static ConsumerDAO consumerDAO;

    private ConsumerDAO() {
        super();
    }

    public static ConsumerDAO getInstance() {
        if (consumerDAO == null) {
            consumerDAO = new ConsumerDAO();
        }
        return consumerDAO;
    }

    public Consumer findById(Long id) {
        Query query = getSession().createQuery("select c from Consumer c where c.id = :id");
        query.setParameter("id", id);
        return (Consumer) query.getSingleResult();
    }

    public List<Product> findAll() {
        return (List<Product>) getSession().createQuery("select c from Consumer c").getResultList();
    }

    public void deleteById(Long id) {
        Consumer consumer = getSession().find(Consumer.class, id);
        getSession().getTransaction().begin();
        getSession().remove(consumer);
        getSession().getTransaction().commit();
    }

    public Consumer saveOrUpdate(Consumer consumer) {
        getSession().getTransaction().begin();
        getSession().saveOrUpdate(consumer);
        getSession().getTransaction().commit();
        return consumer;
    }
}
