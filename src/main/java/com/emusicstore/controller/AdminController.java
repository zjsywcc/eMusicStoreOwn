package com.emusicstore.controller;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wcc on 2016/8/1.
 */
@Controller
public class AdminController {

    private Path path;

    @Autowired
    private ProductDao productDao;

    private static final Logger logger = Logger.getLogger(HomeController.class);


    @RequestMapping("/admin")
    public String adminPage(Model model, Principal principal) {
        final String currentUser = principal.getName();
        model.addAttribute("currentUser", currentUser);
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model) {
        initMap(model);

        Product product = new Product();

        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");


        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST) //BindingResult should just follow the @ModelAttribute!
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model,HttpServletRequest request) {
        initMap(model);

        if(result.hasErrors()) {
            logger.error("page has error:"+result.getErrorCount());
            return "addProduct";
        }
        productDao.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if(productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+productId+".png");

        if(Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        productDao.deleteProduct(productId);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/editProduct/{productId}")
    public String editProduct(@PathVariable("productId") int productId, Model model) {
        initMap(model);

        Product product = productDao.getProductById(productId);
        model.addAttribute(product);

        return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST) //BindingResult should just follow the @ModelAttribute!
    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model, HttpServletRequest request) {
        initMap(model);

        if(result.hasErrors()) {
            return "editProduct";
        }
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");

        if(productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                throw new RuntimeException("Product image saving failed", e);
            }
        }
        productDao.editProduct(product);

        return "redirect:/admin/productInventory";
    }

    // just pass map to radiobuttons in ftl
    public void initMap(Model model) {
        Map category = new LinkedHashMap();
        category.put("instrument", "instrument");
        category.put("record", "record");
        category.put("accessory", "accessory");

        Map condition = new LinkedHashMap();
        condition.put("new", "new");
        condition.put("used", "used");

        Map status = new LinkedHashMap();
        status.put("active", "active");
        status.put("inactive", "inactive");

        model.addAttribute("category", category);
        model.addAttribute("condition", condition);
        model.addAttribute("status", status);
    }
}
