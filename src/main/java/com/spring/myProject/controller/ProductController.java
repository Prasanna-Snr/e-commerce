package com.spring.myProject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.myProject.model.Category;
import com.spring.myProject.model.Product;
import com.spring.myProject.service.IcategoryService;
import com.spring.myProject.service.IproductService;

@Controller
public class ProductController {

    @Autowired
    private IcategoryService categoryService;

    @Autowired
    private IproductService productService;

    @GetMapping("/product")
    public String getProductForm(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "Product";
    }

    @GetMapping("/addProduct")
    public String addProductForm(Model model) {
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "AddProductForm";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product product, @RequestParam("image") MultipartFile imageFile) {
        productService.addProduct(product);

        if (!imageFile.isEmpty()) {
            try {
                Path imagePath = Paths.get("src/main/resources/static/images", imageFile.getOriginalFilename());
                Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
                product.setImageName(imageFile.getOriginalFilename());
                productService.updateProduct(product);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/product";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/editProduct")
    public String getEditProduct(@RequestParam int id, Model model) {
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("oldProduct", productService.getById(id));
        return "EditProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/product";
    }
}
