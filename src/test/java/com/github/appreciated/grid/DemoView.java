package com.github.appreciated.grid;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Random;

@Route("")
public class DemoView extends VerticalLayout {

    private final Random random;

    public DemoView() {
        random = new Random();

        GridLayout gridAreaTestLayout = new GridLayout()
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
        gridAreaTestLayout.setTemplateColumns("200px", "auto", "200px", "auto");

        gridAreaTestLayout.setSizeFull();

        GridLayout responsiveTest = new GridLayout()
                .withWidth("100%")
                .withTemplateColumns("repeat(auto-fit, minmax(300px, auto))")
                .withItemWithWidth(getDiv(), 2)
                .withItem(getDiv())
                .withItemWithWidth(getDiv(), 2)
                .withItem(getDiv())
                .withItemWithWidth(getDiv(), 2)
                .withItem(getDiv())
                .withItemWithWidth(getDiv(), 2)
                .withItem(getDiv())
                .withItemWithWidth(getDiv(), 2)
                .withItem(getDiv())
                .withItemWithWidth(getDiv(), 2)
                .withItem(getDiv());
        responsiveTest.setSizeFull();
        add(gridAreaTestLayout, responsiveTest);
        setSizeFull();

        GridLayout areaTest = new GridLayout()
                .withWidth("100%")
                .withTemplateAreas(new String[][]{
                        new String[]{"header", "header", "header", "header", "header"},
                        new String[]{"left", "content", "content", "content", "right"},
                        new String[]{"left", "content", "content", "content", "right"},
                        new String[]{"left", "content", "content", "content", "right"},
                })
                .withItemAtArea(getDiv(), "header")
                .withItemAtArea(getDiv(), "content")
                .withItemAtArea(getDiv(), "left")
                .withItemAtArea(getDiv(), "right");
        areaTest.setSizeFull();
        add(gridAreaTestLayout, responsiveTest, areaTest);
        setSizeFull();

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
