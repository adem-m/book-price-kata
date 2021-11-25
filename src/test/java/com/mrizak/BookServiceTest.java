package com.mrizak;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class BookServiceTest {
    Map<Integer, Integer> discounts = Map.of(
            1,0,
            2, 5,
            3, 10,
            4, 20,
            5, 25
    );
    private final BookService bookService = new BookService(discounts);

    @Test
    public void should_get_no_price_for_empty_list() {
        List<Book> books = List.of();
        Assert.assertEquals(0.0, bookService.getPrice(books), 0.000001);
    }
    @Test
    public void should_get_price_for_one_book() {
        List<Book> books = List.of(
                Book.of(Title.POTTER1)
        );
        Assert.assertEquals(8.0, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_five_same_books() {
        List<Book> books = List.of(
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER1)
        );
        Assert.assertEquals(40.0, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_two_distinct_books() {
        List<Book> books = List.of(
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER2)
        );
        Assert.assertEquals(15.2, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_three_distinct_books() {
        List<Book> books = List.of(
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER2),
                Book.of(Title.POTTER3)
        );
        Assert.assertEquals(21.6, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_four_distinct_books() {
        List<Book> books = List.of(
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER2),
                Book.of(Title.POTTER3),
                Book.of(Title.POTTER4)
        );
        Assert.assertEquals(25.6, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_five_distinct_books() {
        List<Book> books = List.of(
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER2),
                Book.of(Title.POTTER3),
                Book.of(Title.POTTER4),
                Book.of(Title.POTTER5)
        );
        Assert.assertEquals(30, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_two_distinct_and_one_different_books() {
        List<Book> books = List.of(
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER2)
        );
        Assert.assertEquals(23.2, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_two_distinct_and_two_different_books() {
        List<Book> books = List.of(
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER2),
                Book.of(Title.POTTER1),
                Book.of(Title.POTTER2)
        );
        Assert.assertEquals(30.4, bookService.getPrice(books), 0.000001);
    }
}