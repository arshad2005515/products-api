package uk.ac.westminster.products_api;
//A PhysicalProduct IS-A Product because it inherits the characteristics of super class of product
// Customer entity. as the product entity cannot be inherited with the customer entity
public class PhysicalProduct extends Product {
    private double weightKg;
    private String dimension;

    public PhysicalProduct() {}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimension) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimension = dimension;
    }



    public double getWeightKg() {return weightKg;}
    public String getDimension() {return dimension;}
}
