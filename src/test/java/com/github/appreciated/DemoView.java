package com.github.appreciated;

import com.github.appreciated.grid.FluentFlexibleGridLayout;
import com.github.appreciated.grid.GridLayoutComponent;
import com.github.appreciated.grid.grid.sizes.MaxContent;
import com.github.appreciated.grid.grid.sizes.MinContent;
import com.github.appreciated.grid.grid.sizes.MinMax;
import com.github.appreciated.grid.grid.sizes.Size;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Random;

import static com.github.appreciated.grid.grid.sizes.Size.CssUnit.PX;

@Route("")
public class DemoView extends VerticalLayout {

    private final Random random;

    public DemoView() {
        random = new Random();
        FluentFlexibleGridLayout layout = new FluentFlexibleGridLayout();
        Component alignTestComponent = getDiv();
        layout.withTemplateColumns(new Size(100, PX), new Size(100, PX), new Size(100, PX))
                .withTemplateRows(new MinMax(new MinContent(), new MaxContent()), new MinMax(new MinContent(), new MaxContent()))
                .withColumnAlign(alignTestComponent, GridLayoutComponent.ColumnAlign.END)
                .withRowAlign(alignTestComponent, GridLayoutComponent.RowAlign.END)
                .withItemAtArea(alignTestComponent, 1, 1, 1, 3)
                .withItemAtArea(getDiv(), 2, 1)
                .withItemAtArea(getDiv(), 2, 2)
                .withItemAtArea(getDiv(), 1, 3, 3, 3);
        layout.setWidth("600px");
        layout.setHeight("600px");
        add(layout, new VerticalLayout(new Label("Test"), new Label("Test"), new Label("Test")));
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