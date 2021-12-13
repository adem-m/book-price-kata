package com.mrizak.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BookService {
    private final Map<Saga, Map<Integer, Integer>> discounts;

    public BookService(Map<Saga, Map<Integer, Integer>> discounts) {
        this.discounts = discounts;
    }

    public double getPrice(List<Book> books) {
        List<Book> distinctBooks = this.getDistinctBooks(books);
        if (distinctBooks.size() > 1) {
            this.applyDiscount(distinctBooks);
        }
        return books.stream().reduce(0.0, (price, book) -> price + book.getPrice(), Double::sum);
    }


    private List<Book> getDistinctBooks(List<Book> books) {
        Set<Title> titles = books.stream().map(Book::getTitle).collect(Collectors.toSet());
        List<Book> result = new ArrayList<>();
        for (Title title : titles) {
            Book uniqueBook = books.stream()
                    .filter(book -> book.getTitle().equals(title)).collect(Collectors.toList()).get(0);
            result.add(uniqueBook);
        }
        return result;
    }

    private void applyDiscount(List<Book> distinctBooks) {
        Map<Integer, Integer> sagaDiscounts = discounts.get(distinctBooks.get(0).getSaga());
        Integer discount = sagaDiscounts.get(distinctBooks.size());
        for (Book book : distinctBooks) {
            book.applyDiscount(discount);
        }
    }
}
