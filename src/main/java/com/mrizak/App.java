package com.mrizak;

import com.mrizak.domain.Saga;
import com.mrizak.domain.Title;

import java.util.Map;

public class App {
    public static Map<Title, Saga> sagaTitle = Map.of(
            Title.POTTER1, Saga.POTTER,
            Title.POTTER2, Saga.POTTER,
            Title.POTTER3, Saga.POTTER,
            Title.POTTER4, Saga.POTTER,
            Title.POTTER5, Saga.POTTER,
            Title.LOTR1, Saga.LOTR,
            Title.LOTR2, Saga.LOTR,
            Title.LOTR3, Saga.LOTR
    );

    public static Map<Saga, Map<Integer, Integer>> sagaDiscounts = Map.of(
            Saga.POTTER, Map.of(
                    2, 5,
                    3, 10,
                    4, 20,
                    5, 25
            ),
            Saga.LOTR, Map.of(
                    2, 20,
                    3, 30
            )
    );

    public static void main(String[] args) {
    }
}
