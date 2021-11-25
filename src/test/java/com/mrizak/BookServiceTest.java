package com.mrizak;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class BookServiceTest {
    Map<Integer, Integer> discounts = Map.of(
            2, 5,
            3, 10,
            4, 20,
            5, 25
    );
    private final BookService bookService = new BookService(discounts);

    @Test
    public void should_get_price_for_one_book() {
        List<Book> books = List.of(
                Book.of(Title.POTTER1)
        );
        Assert.assertEquals(8.0, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_two_distinct_books() {
        List<Book> books = List.of(
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER2)
        );
        Assert.assertEquals(15.2, bookService.getPrice(books), 0.000001);
    }
}