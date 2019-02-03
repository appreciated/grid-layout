package com.github.appreciated;

import com.github.appreciated.css.grid.FluentGridLayout;
import com.github.appreciated.css.grid.GridLayoutComponent;
import com.github.appreciated.css.grid.sizes.Flex;
import com.github.appreciated.css.grid.sizes.Length;
import com.github.appreciated.css.grid.sizes.MinMax;
import com.github.appreciated.css.grid.sizes.Repeat;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Random;

import static com.github.appreciated.css.grid.sizes.Repeat.RepeatMode.AUTO_FILL;
import static com.github.appreciated.css.grid.sizes.Repeat.RepeatMode.AUTO_FIT;

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

        FluentGridLayout flexibleGridLayout = new FluentGridLayout()
                .withTemplateColumns(new Repeat(AUTO_FIT, new MinMax(new Length("220px"), new Flex(1))))
                .withTemplateRows(new Repeat(AUTO_FILL, new Length("220px")))
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
        add(layout, flexibleGridLayout);
    }


    private Component getDiv() {
        Div div = new Div();
        div.setClassName("item");
        int nextInt = random.nextInt(0xffffff + 1);
        String colorCode = String.format("#%06x", nextInt);
        div.add(new Label(colorCode));
        div.getStyle().set("background", colorCode).set("padding", "20px");
        return div;
    }

}