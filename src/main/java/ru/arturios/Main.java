package ru.arturios;

import ru.arturios.dao.ProductDAO;
import ru.arturios.entity.Product;

public class Main {
    public static void main(String[] args) {
        ProductDAO dao = ProductDAO.getInstance();

        Product product = new Product("Печенье", 150);

        System.out.println(dao.findById(4L));

        dao.getSession().close();
    }
}
