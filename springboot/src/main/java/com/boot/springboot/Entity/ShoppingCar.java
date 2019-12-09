package com.boot.springboot.Entity;

public class ShoppingCar {
    private int id;
    private String bookName;
    private int bookSum;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookSum() {
        return bookSum;
    }

    public void setBookSum(int bookSum) {
        this.bookSum = bookSum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookSum=" + bookSum +
                ", price=" + price +
                '}';
    }
}
