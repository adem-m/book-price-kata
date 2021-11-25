package com.mrizak;

public class Book {
    private double price;
    private Title title;

    private Book(Title title, double price) {
        this.title = title;
        this.price = price;
    }

    public static Book of(Title title) {
        return new Book(title, 8);
    }

    public double getPrice() {
        return price;
    }

    public Title getTitle() {
        return title;
    }

    public void applyDiscount(int discount) {
        this.price -= (this.price * discount) / 100;
    }
}
