package com.mrizak.domain;

class Book {
    private double price;
    private final Title title;
    private final Saga saga;

    public Book(Title title, double price, Saga saga) {
        this.title = title;
        this.price = price;
        this.saga = saga;
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

    public Saga getSaga() {
        return saga;
    }
}
