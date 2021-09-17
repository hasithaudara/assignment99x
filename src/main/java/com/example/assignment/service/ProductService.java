package com.example.assignment.service;

import com.example.assignment.model.Product;
import com.example.assignment.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public double findProductValue(Long id, String type, int qty) {
        double totalPrice = 0;
        double unitPrice;
        Product selectedProduct = productRepository.findProductById(id);

        switch (type) {
            case "u": // As in units
                int cartons = qty / selectedProduct.getCartonSize();
                int units = qty % selectedProduct.getCartonSize();

                double cartonsPrice;

                unitPrice = (selectedProduct.getCartonPrice() * 1.3) /
                        selectedProduct.getCartonSize(); // For additional labour cost

                if (cartons >= 3) { // For the discount
                    cartonsPrice = (selectedProduct.getCartonPrice() * 0.9) * cartons;
                } else {
                    cartonsPrice = selectedProduct.getCartonPrice() * cartons;
                }
                totalPrice = (unitPrice * units) + cartonsPrice;

                break;
            case "c": // As in cartons

                if (qty >= 3) { // For the discount
                    totalPrice = (selectedProduct.getCartonPrice() * 0.9) * qty;
                } else {
                    totalPrice = selectedProduct.getCartonPrice() * qty;
                }

                break;
            default:
                break;
        }

        return totalPrice;
    }

}
