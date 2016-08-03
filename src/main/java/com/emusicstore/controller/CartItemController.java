package com.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wcc on 2016/8/3.
 */

@Controller
@RequestMapping("/cart")
public class CartItemController {

    @RequestMapping
    public String get(HttpServletRequest request) {
        return "redirect:/cart/"+request.getSession(true).getId();
    }

    @RequestMapping(value="/{cartId}")
    public String getCart(@PathVariable(value = "cartId") String cartId, Model model) {
        model.addAttribute("carId", cartId);
        return "cart";
    }
}
