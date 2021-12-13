package com.mrizak.domain;

import java.util.Map;

public class BookFactory {
    private final Map<Title, Saga> bookSaga;

    public BookFactory(Map<Title, Saga> bookSaga) {
        this.bookSaga = bookSaga;
    }

    public Book create(Title title) {
        return new Book(title, 8, this.bookSaga.get(title));
    }
}
