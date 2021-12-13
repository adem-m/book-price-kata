package com.mrizak.domain;

import com.mrizak.App;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BookServiceTest {
    private final BookFactory bookFactory = new BookFactory(App.sagaTitle);
    private final BookService bookService = new BookService(App.sagaDiscounts);

    @Test
    public void should_get_no_price_for_empty_list() {
        List<Book> books = List.of();
        Assert.assertEquals(0.0, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_one_book() {
        List<Book> books = List.of(
                this.bookFactory.create(Title.POTTER1)
        );
        Assert.assertEquals(8.0, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_five_same_books() {
        List<Book> books = List.of(
                this.bookFactory.create(Title.POTTER1),
                this.bookFactory.create(Title.POTTER1),
                this.bookFactory.create(Title.POTTER1),
                this.bookFactory.create(Title.POTTER1),
                this.bookFactory.create(Title.POTTER1)
        );
        Assert.assertEquals(40.0, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_two_distinct_books() {
        List<Book> books = List.of(
                this.bookFactory.create(Title.POTTER1),
                this.bookFactory.create(Title.POTTER2)
        );
        Assert.assertEquals(15.2, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_three_distinct_books() {
        List<Book> books = List.of(
                this.bookFactory.create(Title.POTTER1),
                this.bookFactory.create(Title.POTTER2),
                this.bookFactory.create(Title.POTTER3)
        );
        Assert.assertEquals(21.6, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_four_distinct_books() {
        List<Book> books = List.of(
                this.bookFactory.create(Title.POTTER1),
                this.bookFactory.create(Title.POTTER2),
                this.bookFactory.create(Title.POTTER3),
                this.bookFactory.create(Title.POTTER4)
        );
        Assert.assertEquals(25.6, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_five_distinct_books() {
        List<Book> books = List.of(
                this.bookFactory.create(Title.POTTER1),
                this.bookFactory.create(Title.POTTER2),
                this.bookFactory.create(Title.POTTER3),
                this.bookFactory.create(Title.POTTER4),
                this.bookFactory.create(Title.POTTER5)
        );
        Assert.assertEquals(30, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_two_distinct_and_one_different_books() {
        List<Book> books = List.of(
                this.bookFactory.create(Title.POTTER1),
                this.bookFactory.create(Title.POTTER1),
                this.bookFactory.create(Title.POTTER2)
        );
        Assert.assertEquals(23.2, bookService.getPrice(books), 0.000001);
    }

    @Test
    public void should_get_price_for_two_distinct_and_two_different_books() {
        List<Book> books = List.of(
                this.bookFactory.create(Title.POTTER1),
                this.bookFactory.create(Title.POTTER2),
                this.bookFactory.create(Title.POTTER1),
                this.bookFactory.create(Title.POTTER2)
        );
        Assert.assertEquals(30.4, bookService.getPrice(books), 0.000001);
    }
}