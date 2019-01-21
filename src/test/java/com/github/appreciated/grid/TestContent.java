package com.github.appreciated.grid;

import com.vaadin.flow.component.html.Div;

import java.util.Random;

public class TestContent extends Div {
    private final Random random;

    public TestContent() {
        random = new Random();
        setClassName("item");
        int nextInt = random.nextInt(0xffffff + 1);
        String colorCode = String.format("#%06x", nextInt);
        getStyle().set("background", colorCode);
    }

}
