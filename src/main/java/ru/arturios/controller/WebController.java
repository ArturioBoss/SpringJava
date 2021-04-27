package ru.arturios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.arturios.repository.ProductRepository;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/";
    }

}
