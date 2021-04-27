package ru.project.hibernate;

import ru.project.hibernate.service.Service;

public class ApplicationHibernate {
    public static void main(String[] args) {
        var service = new Service();

        System.out.println("Список купленных товаров покупателя с id = 2");
        service.getListOfPurchasedProducts(2L).forEach(System.out::println);
    }
}
