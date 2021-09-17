package com.example.assignment;

import com.example.assignment.model.Product;
import com.example.assignment.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping // Eg:- http://localhost:8080/product
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = productService.findAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("/find") // Eg:- http://localhost:8080/product/find?id=2&type=u&qty=23
    @ResponseBody
    public double getProductPrice(@RequestParam Long id,
                                  @RequestParam String type,
                                  @RequestParam int qty) {

        return productService.findProductValue(id,type,qty);
    }
}
