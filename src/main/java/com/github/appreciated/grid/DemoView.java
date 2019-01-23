package com.github.appreciated.grid;

import com.github.appreciated.grid.vaadin.FluentGridLayout;
import com.github.appreciated.grid.vaadin.GridLayoutComponent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class DemoView extends VerticalLayout {

    public DemoView() {
        FluentGridLayout layout = new FluentGridLayout();
        Component alignTestComponent = getDiv();
        layout.withGridColumns("100px", "100px", "100px")
                .withGridRows("200px", "200px")
                .withSpan(alignTestComponent, 1, 1, 1, 3)
                .withColumnAlign(alignTestComponent, GridLayoutComponent.ColumnAlign.END)
                .withRowAlign(alignTestComponent, GridLayoutComponent.RowAlign.END)
                .withPosition(getDiv(), 2, 1)
                .withPosition(getDiv(), 2, 2)
                .withSpan(getDiv(), 1, 3, 3, 3);
        layout.setWidth("600px");
        layout.setHeight("600px");
        add(layout, new VerticalLayout(new Label("Test"), new Label("Test"), new Label("Test")));
    }

    private Component getDiv() {
        return new TestContent();
    }


}
