package miu.edu.lab1.controller;

import miu.edu.lab1.domain.Product;
import miu.edu.lab1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public Product findById(){
        return productService.findById();
    }

//    @PostMapping
//    public void save(RequestBody Product product){
//        return productService.save(product);
//    }

}
