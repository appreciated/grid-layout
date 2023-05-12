package com.github.appreciated;

import com.github.appreciated.css.grid.sizes.*;
import com.github.appreciated.layout.AreaLayout;
import com.github.appreciated.layout.FlexibleGridLayout;
import com.github.appreciated.layout.FluentGridLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaddon.css.query.MediaQuery;

import java.util.Random;

import static com.github.appreciated.css.grid.GridLayoutComponent.*;
import static org.vaddon.css.query.values.WidthAttributes.MaxWidth;
import static org.vaddon.css.query.values.WidthAttributes.MinWidth;

@Route("")
public class DemoView extends VerticalLayout {

    private final Random random;

    public DemoView() {
        random = new Random();
        FluentGridLayout layout = new FluentGridLayout();
        Component alignTestComponent = getDiv();
        layout.withTemplateRows(new Flex(), new Flex(), new Flex())
                .withTemplateColumns(new Flex(), new Flex(), new Flex())
                .withColumnAlign(alignTestComponent, ColumnAlign.END)
                .withRowAlign(alignTestComponent, RowAlign.END)
                .withRowAndColumn(alignTestComponent, 1, 1, 1, 3)
                .withRowAndColumn(getDiv(), 2, 1)
                .withRowAndColumn(getDiv(), 2, 2)
                .withRowAndColumn(getDiv(), 1, 3, 3, 3);
        layout.setWidth("100%");
        layout.setHeight("600px");


        FluentGridLayout layout2 = new FluentGridLayout();
        Component customColTest = getDiv();
        layout2.withTemplateColumns(
                new TemplateColOrRow("col1-start", new Flex()),
                new TemplateColOrRow("col2-start", new Flex()),
                new TemplateColOrRow("col3-start", new Flex()),
                new TemplateColOrRow("col-end"))
                .withTemplateRows(
                        new TemplateColOrRow("row1-start", new Flex()),
                        new TemplateColOrRow("row2-start", new Flex()),
                        new TemplateColOrRow("row-end"))
                .withItems(customColTest)
                .withColumnStart(customColTest, new ColOrRow("col1-start"))
                .withColumnEnd(customColTest, new ColOrRow("col3-start"))
                .withRowStart(customColTest, new ColOrRow("row1-start"))
                .withRowEnd(customColTest, new ColOrRow("rows-end"))
                .withOverflow(Overflow.AUTO)
                .withPadding(true)
                .withSpacing(true);
        layout2.setWidth("100%");
        layout2.setHeight("600px");

        FlexibleGridLayout flexibleGridLayout = new FlexibleGridLayout()
                .withColumns(Repeat.RepeatMode.AUTO_FILL, new MinMax(new Length("220px"), new Flex()))
                .withAutoRows(new Length("220px"))
                .withItems(
                        getDiv())
                .withItemWithSize(getDiv(), 2, 2)
                .withItems(
                        getDiv(), getDiv(), getDiv(), getDiv(), getDiv(), getDiv(),
                        getDiv(), getDiv(), getDiv(), getDiv(), getDiv(), getDiv(),
                        getDiv(), getDiv())
                .withOverflow(Overflow.AUTO)
                .withAutoFlow(AutoFlow.ROW_DENSE)
                .withPadding(true)
                .withSpacing(true);
        flexibleGridLayout.setWidth("100%");
        flexibleGridLayout.setHeight("600px");

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

        Component header = getDiv();
        Component left = getDiv();
        Component right = getDiv();
        Component content = getDiv();

        FluentGridLayout mediaGridLayout = new FluentGridLayout()
                .withTemplateAreas(new MediaQuery(new MaxWidth("800px")),
                        new TemplateAreas("header"),
                        new TemplateAreas("left"),
                        new TemplateAreas("content"),
                        new TemplateAreas("right"))
                .withTemplateAreas(new MediaQuery(new MinWidth("800px")),
                        new TemplateAreas("header", "header", "header", "header", "header"),
                        new TemplateAreas("left", "content", "content", "content", "right"),
                        new TemplateAreas("left", "content", "content", "content", "right"),
                        new TemplateAreas("left", "content", "content", "content", "right"))
                .withItem(header).withArea(header, new TemplateArea("header"))
                .withItem(left).withArea(left, new TemplateArea("left"))
                .withItem(right).withArea(right, new TemplateArea("right"))
                .withItem(content).withArea(content, new TemplateArea("content"));
        mediaGridLayout.setWidth("100%");
        mediaGridLayout.setHeight("600px");


        add(layout, layout2, flexibleGridLayout, areaLayout, mediaGridLayout);
        getChildren().forEach(component -> component.getElement().getStyle().set("flex-shrink", "0"));
        getStyle().set("overflow", "auto");

        setSizeFull();
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