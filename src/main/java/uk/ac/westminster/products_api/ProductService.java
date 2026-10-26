package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService  {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService() {
        products.add (new DigitalProduct(nextId++, "Clean Code (E-book) ",29.99,"/downloads/clean-code.pdf",4.2));
        products.add (new PhysicalProduct(nextId++,"27-inch Monitor",249.99,5.4,"61cm x 41cm x 18cm"));
    }

    public List<Product> getAllProducts() {return products;}

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p ->p.getId().equals(id))
                 .findFirst();
    }


    public Product addProduct (Product product) {
        product.setId(nextId);
        nextId ++;
        products.add(product);
        return product;
    }

    public String deleteProductById (Long id) {
        boolean isDeleted = products.removeIf(p -> p.getId().equals(id));
        if (isDeleted) {
            return "Deleted !!";
        } else {
            return "Product with id not found";
        }
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name)).toList();
    }

    public List<String> getAllProductSummaries() {
        return products.stream()
                .map(p ->p.getSummary()).toList();
    }
    }


