package ru.arturios.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.arturios.products.ProductRepository;

@RestController
public class HomeController {
    private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping(value = "/json/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getJson() {
        String s = "";
        for (int i = 1; i <= productRepository.getAll().size(); i++) {
            s = s + String.format("{\"id\": \"%s\",\"Имя\": \"%s\",\"Цена\": \"%s\"}",productRepository.getById(String.valueOf(i)).getId(),
                    productRepository.getById(String.valueOf(i)).getName(),
                    productRepository.getById(String.valueOf(i)).getPrice());
            if (productRepository.getAll().size() != i){
                s = s + ",";
            }

        }

        return s;
    }

    @GetMapping("/xml/get")
    public String getXml() {
        String s = "<?xml version=\"1.0\" encoding=\"utf-8\"?> \n" +
                "<!DOCTYPE recipe>\n";
        for (int i = 1; i <= productRepository.getAll().size(); i++) {
            s = s + String.format(" <recipe id=\"%s\">\n" +
                            "   <title>\n" +
                            "      %S\n" +
                            "   </title>\n" +
                            "   <price>\n" +
                            "      %s руб.\n" +
                            "   </price>\n" +
                            "</recipe>\n",productRepository.getById(String.valueOf(i)).getId(),
                    productRepository.getById(String.valueOf(i)).getName(),
                    productRepository.getById(String.valueOf(i)).getPrice());

        }

        return s;
    }



}
