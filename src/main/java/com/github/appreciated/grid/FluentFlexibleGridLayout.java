package com.github.appreciated.grid;

import com.github.appreciated.grid.interfaces.CssGridUnit;
import com.github.appreciated.grid.sizes.NegativeValueException;
import com.github.appreciated.grid.sizes.Size;
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
    public FluentFlexibleGridLayout withItemWithWidth(Component component, int width) {
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
    public void setItemWidth(Component component, int width) {
        setColumn(component, "span " + width);
    }

    public FluentFlexibleGridLayout withItemWithSize(Component component, int size, int height) {
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
    public void setItemSize(Component component, int width, int height) {
        setItemHeight(component, height);
        setItemWidth(component, width);
    }

    /**
     * Shorthand fluent style for users which don't want to dive into the css-grid to set the number of row an item should span over
     *
     * @param component the component which row height should be set
     * @param height    the number of rows the item should span over
     */
    public void setItemHeight(Component component, int height) {
        setRow(component, "span " + height);
    }

    public FluentFlexibleGridLayout withItemAtArea(Component component, int rowStart, int colStart) {
        return withItemAtArea(component, rowStart, colStart, rowStart, colStart);
    }

    public FluentFlexibleGridLayout withItemAtArea(Component component, int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowStart < 0 || colStart < 0 || rowEnd < 0 || colEnd < 0) {
            throw new NegativeValueException(rowStart, colStart, rowEnd, colEnd);
        }
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
    public FluentFlexibleGridLayout withItemWithHeight(Component component, int height) {
        add(component);
        setItemHeight(component, height);
        return this;
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

    public FluentFlexibleGridLayout withGap(Size size) {
        setGap(size);
        return this;
    }

    public FluentFlexibleGridLayout withAutoRows(Size size) {
        setAutoRows(size);
        return this;
    }

    public FluentFlexibleGridLayout withAutoColmuns(Size size) {
        setAutoColumns(size);
        return this;
    }
}
