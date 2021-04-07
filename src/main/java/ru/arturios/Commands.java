package ru.arturios;

import org.springframework.stereotype.Component;
import ru.arturios.products.ProductRepository;

@Component
public class Commands {

    private final ProductRepository productRepository;
    private final Cart cart;

    public Commands(ProductRepository productRepository, Cart cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    public void doAuth(String s) {
        if (s.startsWith("INFO")) {
            System.out.println("****************************");
            System.out.println("**      Набор команд      **");
            System.out.println("**  add - добавить товар  **");
            System.out.println("** del - удалить товар    **");
            System.out.println("** all - товары в корзине **");
            System.out.println("****************************");

        } else if (s.startsWith("all")){
            System.out.println("Всего товаров:");
            for (int i = 1; i <= productRepository.getAll().size(); i++) {
                System.out.printf("id: %s Имя: %s Цена: %s\n",productRepository.getById(String.valueOf(i)).getId(),
                        productRepository.getById(String.valueOf(i)).getName(),
                        productRepository.getById(String.valueOf(i)).getPrice());
            }

        } else if (s.startsWith("add")){
            String[] credentialValues = s.split("\\s");
            if (credentialValues.length < 3){
                System.out.println("Введите имя и цену товара");
                System.out.println("ПРИМЕР: Процессор 300");
            } else if(!isDigit(credentialValues[2])){
                System.out.println("Цена товара не может быть не числом");
            } else {
                cart.saveProduct(credentialValues[1], Integer.parseInt(credentialValues[2]));
            }

        } else if (s.startsWith("del")){
            String[] credentialValues = s.split("\\s");
            if (credentialValues.length < 2){
                System.out.println("Для удаления, введите id товара");
            } else if(!isDigit(credentialValues[1])){
                System.out.println("id не может быть не числом");
            } else {
                cart.delete(credentialValues[1]);
            }

        }

    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
