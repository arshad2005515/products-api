package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable {
    private String downloadUrl;
    private double fileSize;
    private double  discountedPrice;

    public DigitalProduct() {}

    public DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSize) {
        super (id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }





    public String getDownloadUrl() {return downloadUrl;}
    public double getFileSize() {return fileSize;}

    @Override
    public String getSummary() {
        return "Digital: name: " + getName() + "|price: " + getPrice() +
                "|downloadurl: " + downloadUrl +"|fileSize: " + fileSize;
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


