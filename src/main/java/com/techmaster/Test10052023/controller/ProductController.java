package com.techmaster.Test10052023.controller;

import com.techmaster.Test10052023.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
    	if(productService.findAll().size()>0) {
	        model.addAttribute("products", productService.findAll());
	        return "index";
    	} else {
    		return "emty";	
    	}
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }
}