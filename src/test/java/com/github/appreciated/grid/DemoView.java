package com.github.appreciated.grid;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import java.util.Random;

@Route("")
public class DemoView extends Div {

    private final Random random;

    public DemoView() {
        random = new Random();

        GridLayout gridLayout = new GridLayout()
                .withItems(getDiv())
                .withItemAtArea(getDiv(), 1, 1, 3, 3)
                .withItemAtArea(getDiv(), 3, 3, 5, 5)
                .withItemWithSize(getDiv(), 2, 2)
                .withItemWithSize(getDiv(), 2, 2)
                .withItemWithHeight(getDiv(), 2)
                .withItemWithHeight(getDiv(), 2)
                .withItemWithWidth(getDiv(), 2)
                .withItemWithWidth(getDiv(), 2)
                .withItems(getDiv(),
                        getDiv(),
                        getDiv(),
                        getDiv(),
                        getDiv()
                );

        gridLayout.setColumns("200px", "auto", "200px", "auto");
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
