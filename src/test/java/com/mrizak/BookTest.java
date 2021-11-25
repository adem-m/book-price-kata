package com.mrizak;

import org.junit.Assert;
import org.junit.Test;

public class BookTest {

    @Test
    public void should_apply_discount() {
        Book book = Book.of(Title.POTTER1);
        book.applyDiscount(10);
        Assert.assertEquals(7.2, book.getPrice(), 0.00001);
    }

}