package uk.ac.westminster.products_api;

public interface Discountable {
    public abstract void applyDiscount (double rate);
    public abstract double getDiscountedPrice();
}
