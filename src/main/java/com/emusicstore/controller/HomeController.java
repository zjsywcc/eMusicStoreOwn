package com.emusicstore.controller;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * Created by wcc on 2016/7/26.
 */
@Controller
public class HomeController {
    @Autowired
    private ProductDao productDao;


    @RequestMapping(value="/")
    public String home() {
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> products = productDao.getAllProducts();

        model.addAttribute("products", products);

        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable("productId") int productId, Model model, Principal principal) throws IOException {
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);
        if (principal != null) {
            final String currentUser = principal.getName();
            if (currentUser != null) {
                model.addAttribute("currentUser", currentUser);
            }
        }
        return "viewProduct";
    }



}
