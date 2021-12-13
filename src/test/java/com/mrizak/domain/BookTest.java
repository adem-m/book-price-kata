package com.mrizak.domain;

import com.mrizak.App;
import org.junit.Assert;
import org.junit.Test;

public class BookTest {
    private final BookFactory bookFactory = new BookFactory(App.sagaTitle);

    @Test
    public void should_apply_discount() {
        Book book = bookFactory.create(Title.POTTER1);
        book.applyDiscount(10);
        Assert.assertEquals(7.2, book.getPrice(), 0.00001);
    }

}