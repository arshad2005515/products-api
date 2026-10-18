package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController//makes the class as a spring component that handles the http request
@RequestMapping("/products")//the base URL path for all endpoints in the controller

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts() {return productService.getAllProducts();}

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {return productService.getProductById(id).orElse(null);}

    @PostMapping()
    public Product addProduct(@RequestBody Product product) {return productService.addProduct(product);}

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {return productService.deleteProductById(id);}

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {return productService.findByName(name);}
}
