package com.github.appreciated.layout;

import com.github.appreciated.css.grid.interfaces.TemplateRowsAndColsUnit;
import com.github.appreciated.css.grid.sizes.Length;
import com.github.appreciated.css.grid.sizes.MinMax;
import com.github.appreciated.css.grid.sizes.Repeat;
import com.github.appreciated.css.grid.sizes.Span;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;

/**
 * A Layout which makes it easy for the user to create flexible grids.
 */
public class FlexibleGridLayout extends Composite<GridLayout> implements HasSize, HasStyle {
    public FlexibleGridLayout() {

    }

    /**
     * Convenience method, for users which don't want to dive into the css-grid to set the number of row an item should span over
     *
     * @param component the component which column width should be set
     * @param width     the number of columns the item should span over
     */
    public FlexibleGridLayout withItemWithWidth(Component component, int width) {
        getContent().add(component);
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
        getContent().setColumn(component, new Span(width));
    }

    public FlexibleGridLayout withItemWithSize(Component component, int size, int height) {
        getContent().add(component);
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
        getContent().setRow(component, new Span(height));
    }

    /**
     * Shorthand fluent style method for adding a component and setting its height
     *
     * @param component the components to add
     * @param height
     * @return this
     */
    public FlexibleGridLayout withItemWithHeight(Component component, int height) {
        getContent().add(component);
        setItemHeight(component, height);
        return this;
    }

    public FlexibleGridLayout withColumns(MinMax units) {
        getContent().setTemplateColumns(new Repeat(Repeat.RepeatMode.AUTO_FILL, units));
        return this;
    }

    public FlexibleGridLayout withRows(TemplateRowsAndColsUnit... units) {
        getContent().setTemplateRows(units);
        return this;
    }

    public FlexibleGridLayout withAutoRows(Length length) {
        getContent().setAutoRows(length);
        return this;
    }

    public FlexibleGridLayout withGap(Length gap) {
        getContent().setGap(gap);
        return this;
    }

    public FlexibleGridLayout withItems(Component... div) {
        getContent().add(div);
        return this;
    }
}
