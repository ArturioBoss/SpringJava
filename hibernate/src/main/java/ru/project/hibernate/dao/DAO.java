package ru.project.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAO {

    private SessionFactory factory;
    private Session session;

    protected DAO() {
        factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();
        session = factory.openSession();
    }

    public Session getSession() {
        return session;
    }
}
