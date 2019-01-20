package com.github.appreciated.grid;

import com.vaadin.flow.component.Component;

public class FluentGridLayout extends GridLayout {

    /**
     * Convenience method, for users which don't want to dive into the css-grid to set the number of row an item should span over
     *
     * @param component the component which column width should be set
     * @param width     the number of columns the item should span over
     */
    public void setItemWidth(Component component, int width) {
        setColumn(component, "span " + width);
    }

    /**
     * Convenience method, for users which don't want to dive into the css-grid to set the number of row an item should span over
     *
     * @param component the component which row height should be set
     * @param height    the number of rows the item should span over
     */
    public void setItemHeight(Component component, int height) {
        setRow(component, "span " + height);
    }

    /**
     * Convenience method, for users which don't want to dive into the css-grid to set the number of rows and columns an item should span over
     *
     * @param component the component which column width should be set
     * @param width     the number of columns the item should span over
     * @param height    the number of rows the item should span over
     */
    public void setItemSize(Component component, int width, int height) {
        setItemHeight(component, height);
        setItemWidth(component, width);
    }

    /**
     * Fluent method of {@link GridLayout#setTemplateColumns(String...)}
     *
     * @param columns
     * @return
     */
    public GridLayout withTemplateColumns(String... columns) {
        setTemplateColumns(columns);
        return this;
    }

    /**
     * Fluent method of {@link GridLayout#setTemplateColumns(String...)}
     *
     * @param rows
     * @return
     */
    public GridLayout withTemplateRows(String... rows) {
        setTemplateRows(rows);
        return this;
    }

    public GridLayout withItemWithWidth(Component component, int width) {
        add(component);
        setItemWidth(component, width);
        return this;
    }

    public GridLayout withItemWithSize(Component component, int size, int height) {
        add(component);
        setItemSize(component, size, height);
        return this;
    }

    public GridLayout withItemAtArea(Component component, int rowStart, int colStart, int rowEnd, int colEnd) {
        add(component);
        setArea(component, rowStart, colStart, rowEnd, colEnd);
        return this;
    }

    public GridLayout withItemAtArea(Component component, String area) {
        add(component);
        setArea(component, area);
        return this;
    }

    public GridLayout withItem(Component component) {
        add(component);
        return this;
    }

    public GridLayout withItems(Component... components) {
        add(components);
        return this;
    }

    public GridLayout withItemWithHeight(Component component, int height) {
        add(component);
        setItemHeight(component, height);
        return this;
    }

    public GridLayout withWidth(String width) {
        setWidth(width);
        return this;
    }
}
