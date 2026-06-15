package models;

import java.util.Date;

public class Product {
    private String id, name, catId;
    private int qty;
    private Date importDate;
    private double price;

    public Product() {
    }

    public Product(String id, String name, int qty, Date importDate, double price, String catId) {
        this.id = id;
        this.name = name;
        this.catId = catId;
        this.qty = qty;
        this.importDate = importDate;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", catId=" + catId + ", qty=" + qty + ", importDate=" + importDate + ", price=" + price + '}';
    }
}
