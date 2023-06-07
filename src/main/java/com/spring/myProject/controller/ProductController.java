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
	private IcategoryService cateServic;
	
	@Autowired
	private IproductService prodServic;
	
	
	@GetMapping("/product")
	public String GetProductForm(Model model) {
		model.addAttribute("product",prodServic.getAllProduct());
		return "Product";
	}
	
	
	@GetMapping("/addProduct")
	public String AddProductForm(Model model) {
		List<Category> categories= cateServic.getAllCategory();
		model.addAttribute("categories",categories);
		return "AddProductForm";
	}
	
	
//	@PostMapping("/saveProduct")
//	public String doSaveProduct(@ModelAttribute Product product) {
//		prodServic.addProduct(product);
//		return "redirect:/product";
//	}
	

	
	@PostMapping("/saveProduct")
	public String doSaveProduct(@ModelAttribute Product product, @RequestParam("image") MultipartFile imageFile) {
	    // Save the product details using prodServic.addProduct()
	    prodServic.addProduct(product);

	    // Check if an image file is uploaded
	    if (!imageFile.isEmpty()) {
	        try {
	            // Specify the desired location and filename for the image
	            Path imagePath = Paths.get("D:\\my_project\\target\\classes\\static\\images", imageFile.getOriginalFilename());

	            // Save the image file to the specified location
	            Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);

	            // Set the image name to the imageName field of the product
	            product.setImageName(imageFile.getOriginalFilename());

	            // Update the product in the database to save the image name
	            prodServic.updateProduct(product);
	        } catch (IOException e) {
	            // Handle the exception if there's an error saving the image
	            e.printStackTrace();
	            // You can also show an error message to the user
	        }
	    }

	    return "redirect:/product";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam int id) {
		prodServic.deleteProduct(id);
		return "redirect:/product";
	}

	
	@GetMapping("editProduct")
	public String getEditProduct(@RequestParam int id, Model model) {
		List<Category> categories= cateServic.getAllCategory();
		model.addAttribute("categories",categories);
		model.addAttribute("oldProduct",prodServic.getById(id));
		return "EditProduct";
	}
	
	
	@PostMapping("/updateProduct")
	public String updateProduct(@ModelAttribute Product product) {
		prodServic.updateProduct(product);
		return "redirect:/product";
	}
	
	
	
	
}
