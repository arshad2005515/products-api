package uk.ac.westminster.products_api;
//A PhysicalProduct IS-A Product because it inherits the characteristics of super class of product
// Customer entity. as the product entity cannot be inherited with the customer entity
public class PhysicalProduct extends Product implements Discountable {
    private double weightKg;
    private String dimension;
    private double discountedPrice;

    public PhysicalProduct() {}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimension) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimension = dimension;
    }



    public double getWeightKg() {return weightKg;}
    public String getDimension() {return dimension;}

    @Override
    public String getSummary() {
        return "Digital: name: " + getName() + "|price: " + getPrice() +
                "|weightKg: " + weightKg +"|dimension: " + dimension;
    }

    @Override
    public void applyDiscount(double rate) {
        this.discountedPrice = getPrice() * (1 - rate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
