package com.github.appreciated.grid;

import com.github.appreciated.grid.sizes.sizes.CssGridUnit;
import com.vaadin.flow.component.Component;

public class FluentFlexibleGridLayout extends FlexibleGridLayout {

    /**
     * Fluent method of {@link FlexibleGridLayout#setTemplateColumns(CssGridUnit...)}
     *
     * @param units
     * @return
     */
    public FluentFlexibleGridLayout withTemplateColumns(CssGridUnit... units) {
        setTemplateColumns(units);
        return this;
    }

    /**
     * Fluent method of {@link FlexibleGridLayout#setTemplateColumns(CssGridUnit...)}
     *
     * @param rows
     * @return
     */
    public FluentFlexibleGridLayout withTemplateRows(CssGridUnit... rows) {
        setTemplateRows(rows);
        return this;
    }

    /**
     * Convenience method, for users which don't want to dive into the css-grid to set the number of row an item should span over
     *
     * @param component the component which column width should be set
     * @param width     the number of columns the item should span over
     */
    public FluentFlexibleGridLayout withItemWithWidth(Component component, String width) {
        add(component);
        setItemWidth(component, width);
        return this;
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

    public FluentFlexibleGridLayout withItemWithSize(Component component, String size, String height) {
        add(component);
        setItemSize(component, size, height);
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

    public FluentFlexibleGridLayout withItemAtArea(Component component, int rowStart, int colStart) {
        return withItemAtArea(component, rowStart, colStart, rowStart, colStart);
    }

    public FluentFlexibleGridLayout withItemAtArea(Component component, int rowStart, int colStart, int rowEnd, int colEnd) {
        return withItemAtArea(component, String.valueOf(rowStart), String.valueOf(colStart), String.valueOf(rowEnd), String.valueOf(colEnd));
    }

    /**
     * Shorthand fluent style method for adding a component and setting its area
     *
     * @param component
     * @param rowStart  row in which you want the component span to begin
     * @param colStart  col in which you want the component span to begin
     * @param rowEnd    row in which you want the component span to end
     * @param colEnd    col in which you want the component span to end
     * @return this
     */
    public FluentFlexibleGridLayout withItemAtArea(Component component, String rowStart, String colStart, String rowEnd, String colEnd) {
        add(component);
        setArea(component, rowStart, colStart, rowEnd, colEnd);
        return this;
    }

    /**
     * Shorthand fluent style method for adding a component and setting its area
     *
     * @param component the component to add
     * @param area      the area the element should be assigned
     * @return this
     */
    public FluentFlexibleGridLayout withItemAtArea(Component component, String area) {
        add(component);
        setArea(component, area);
        return this;
    }

    /**
     * Shorthand fluent style method for adding a component
     *
     * @param component the component to add
     * @return this
     */
    public FluentFlexibleGridLayout withItem(Component component) {
        add(component);
        return this;
    }

    /**
     * Shorthand fluent style method for adding one or multiple components
     *
     * @param components the components to add
     * @return this
     */
    public FluentFlexibleGridLayout withItems(Component... components) {
        add(components);
        return this;
    }

    /**
     * Shorthand fluent style method for adding a component and setting its height
     *
     * @param component the components to add
     * @param height
     * @return this
     */
    public FluentFlexibleGridLayout withItemWithHeight(Component component, String height) {
        add(component);
        setItemHeight(component, height);
        return this;
    }

    /**
     * Shorthand fluent style for users which don't want to dive into the css-grid to set the number of row an item should span over
     *
     * @param component the component which row height should be set
     * @param height    the number of rows the item should span over
     */
    public void setItemHeight(Component component, String height) {
        setRow(component, "span " + height);
    }

    /**
     * Shorthand fluent style method to set the width of the layout
     *
     * @param width the width that should be assigned
     * @return this
     */
    public FluentFlexibleGridLayout withWidth(String width) {
        setWidth(width);
        return this;
    }

    /**
     * Fluent method of {@link FlexibleGridLayout#setTemplateAreas(String[][])} for setting the template areas available
     *
     * @param templateAreas the template areas you want to be assigned
     * @return this
     */
    public FluentFlexibleGridLayout withTemplateAreas(String[][] templateAreas) {
        setTemplateAreas(templateAreas);
        return this;
    }

    public FluentFlexibleGridLayout withColumnAlign(Component component, ColumnAlign columnAlign) {
        setColumnAlign(component, columnAlign);
        return this;
    }

    public FluentFlexibleGridLayout withRowAlign(Component component, RowAlign end) {
        setRowAlign(component, end);
        return this;
    }
}
