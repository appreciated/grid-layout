package com.github.appreciated.grid;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import java.util.Random;

@Route("")
public class DemoView extends Div {

    private final Random random;

    public DemoView() {
        random = new Random();
        Div element = getDiv();
        Div element2 = getDiv();

        GridLayout gridLayout = new GridLayout(
                getDiv(),
                element,
                element2,
                getDiv(),
                getDiv(),
                getDiv(),
                getDiv(),
                getDiv(),
                getDiv(),
                getDiv(),
                getDiv()
        );
        gridLayout.setColumns("200px", "auto", "200px", "auto");
        gridLayout.setArea(element, 1, 1, 3, 3);
        gridLayout.setArea(element2, 3, 3, 5, 5);
        gridLayout.setWidth("100%");
        gridLayout.setHeight("500px");
        add(gridLayout);
    }

    Div getDiv() {
        Div d = new Div();
        d.setClassName("item");
        int nextInt = random.nextInt(0xffffff + 1);
        String colorCode = String.format("#%06x", nextInt);
        d.getStyle().set("background", colorCode);
        return d;
    }
}
