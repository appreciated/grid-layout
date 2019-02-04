package com.github.appreciated;

import com.github.appreciated.css.grid.GridLayoutComponent;
import com.github.appreciated.css.grid.sizes.Flex;
import com.github.appreciated.css.grid.sizes.Length;
import com.github.appreciated.css.grid.sizes.MinMax;
import com.github.appreciated.css.grid.sizes.Repeat;
import com.github.appreciated.layout.AreaLayout;
import com.github.appreciated.layout.FlexibleGridLayout;
import com.github.appreciated.layout.FluentGridLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Random;

import static com.github.appreciated.css.grid.sizes.Repeat.RepeatMode.AUTO_FILL;

@Route("")
public class DemoView extends VerticalLayout {

    private final Random random;

    public DemoView() {
        random = new Random();
        FluentGridLayout layout = new FluentGridLayout();
        Component alignTestComponent = getDiv();
        layout.withTemplateRows(new Flex(1), new Flex(1), new Flex(1))
                .withTemplateColumns(new Flex(1), new Flex(1), new Flex(1))
                .withColumnAlign(alignTestComponent, GridLayoutComponent.ColumnAlign.END)
                .withRowAlign(alignTestComponent, GridLayoutComponent.RowAlign.END)
                .withItemAtArea(alignTestComponent, 1, 1, 1, 3)
                .withItemAtArea(getDiv(), 2, 1)
                .withItemAtArea(getDiv(), 2, 2)
                .withItemAtArea(getDiv(), 1, 3, 3, 3);
        layout.setWidth("100%");
        layout.setHeight("600px");

        FlexibleGridLayout flexibleGridLayout = new FlexibleGridLayout()
                .withColumns(new MinMax(new Length("220px"), new Flex(1)))
                .withRows(new Repeat(AUTO_FILL, new Length("220px")))
                .withAutoRows(new Length("220px"))
                .withGap(new Length("10px"))
                .withItems(
                        getDiv())
                .withItemWithSize(getDiv(), 2, 2)
                .withItems(
                        getDiv(), getDiv(), getDiv(), getDiv(), getDiv(), getDiv(),
                        getDiv(), getDiv()
                );
        flexibleGridLayout.setWidth("100%");

        AreaLayout areaLayout = new AreaLayout(new String[][]{
                new String[]{"header", "header", "header", "header", "header"},
                new String[]{"left", "content", "content", "content", "right"},
                new String[]{"left", "content", "content", "content", "right"},
                new String[]{"left", "content", "content", "content", "right"},
                new String[]{"left", "content", "content", "content", "right"}
        }).withItemAtArea(getDiv(), "header")
                .withItemAtArea(getDiv(), "left")
                .withItemAtArea(getDiv(), "right")
                .withItemAtArea(getDiv(), "content");

        areaLayout.setWidth("100%");
        areaLayout.setHeight("600px");

        add(layout, flexibleGridLayout, areaLayout);
        getStyle().set("overflow", "auto");
        layout.getStyle().set("flex-shrink", "0");
        flexibleGridLayout.getStyle().set("flex-shrink", "0");
        areaLayout.getStyle().set("flex-shrink", "0");
        setSizeFull();
    }


    private Component getDiv() {
        Div div = new Div();
        div.setClassName("item");
        int nextInt = random.nextInt(0xffffff + 1);
        java.lang.String colorCode = java.lang.String.format("#%06x", nextInt);
        div.add(new Label(colorCode));
        div.getStyle().set("background", colorCode).set("padding", "20px");
        return div;
    }

}