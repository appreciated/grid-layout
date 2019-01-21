package com.github.appreciated.grid;

import com.vaadin.flow.component.Component;

public class FluentGridLayout extends GridLayout {

    /**
     * Fluent method of {@link GridLayout#setTemplateColumns(String...)}
     *
     * @param columns
     * @return
     */
    public FluentGridLayout withTemplateColumns(String... columns) {
        setTemplateColumns(columns);
        return this;
    }

    /**
     * Fluent method of {@link GridLayout#setTemplateColumns(String...)}
     *
     * @param rows
     * @return
     */
    public FluentGridLayout withTemplateRows(String... rows) {
        setTemplateRows(rows);
        return this;
    }

    public FluentGridLayout withItemWithWidth(Component component, String width) {
        add(component);
        setItemWidth(component, width);
        return this;
    }

    /**
     * Convenience method, for users which don't want to dive into the css-grid to set the number of rows and columns an item should span over
     *
     * @param component the component which column width should be set
     * @param width     the number of columns the item should span over
     * @param height    the number of rows the item should span over
     */
    public void setItemSize(Component component, String width, String height) {
        setItemHeight(component, height);
        setItemWidth(component, width);
    }

    public FluentGridLayout withItemWithSize(Component component, String size, String height) {
        add(component);
        setItemSize(component, size, height);
        return this;
    }

    /**
     * Convenience method, for users which don't want to dive into the css-grid to set the number of row an item should span over
     *
     * @param component the component which row height should be set
     * @param height    the number of rows the item should span over
     */
    public void setItemHeight(Component component, String height) {
        setRow(component, "span " + height);
    }

    /**
     * Convenience method, for users which don't want to dive into the css-grid to set the number of row an item should span over
     *
     * @param component the component which column width should be set
     * @param width     the number of columns the item should span over
     */
    public void setItemWidth(Component component, String width) {
        setColumn(component, "span " + width);
    }

    public FluentGridLayout withItemAtArea(Component component, String rowStart, String colStart, String rowEnd, String colEnd) {
        add(component);
        setArea(component, rowStart, colStart, rowEnd, colEnd);
        return this;
    }

    public FluentGridLayout withItemAtArea(Component component, String area) {
        add(component);
        setArea(component, area);
        return this;
    }

    public FluentGridLayout withItem(Component component) {
        add(component);
        return this;
    }

    public FluentGridLayout withItems(Component... components) {
        add(components);
        return this;
    }

    public FluentGridLayout withItemWithHeight(Component component, String height) {
        add(component);
        setItemHeight(component, height);
        return this;
    }

    public FluentGridLayout withWidth(String width) {
        setWidth(width);
        return this;
    }

    /**
     * Fluent method of {@link GridLayout#setTemplateAreas(String[][])} (String...)}
     *
     * @param templateAreas
     * @return
     */
    public FluentGridLayout withTemplateAreas(String[][] templateAreas) {
        setTemplateAreas(templateAreas);
        return this;
    }

}
