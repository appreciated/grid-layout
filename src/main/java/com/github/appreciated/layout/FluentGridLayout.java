package com.github.appreciated.layout;

import com.github.appreciated.css.grid.exception.NegativeValueException;
import com.github.appreciated.css.grid.interfaces.RowOrColUnit;
import com.github.appreciated.css.grid.interfaces.TemplateRowsAndColsUnit;
import com.github.appreciated.css.grid.sizes.CustomIdent;
import com.github.appreciated.css.grid.sizes.Int;
import com.github.appreciated.css.grid.sizes.Length;
import com.vaadin.flow.component.Component;

public class FluentGridLayout extends GridLayout {

    /**
     * Fluent method of {@link GridLayout#setTemplateColumns(TemplateRowsAndColsUnit...)}
     *
     * @param units
     * @return
     */
    public FluentGridLayout withTemplateColumns(TemplateRowsAndColsUnit... units) {
        setTemplateColumns(units);
        return this;
    }

    /**
     * Fluent method of {@link GridLayout#setTemplateColumns(TemplateRowsAndColsUnit...)}
     *
     * @param rows
     * @return
     */
    public FluentGridLayout withTemplateRows(TemplateRowsAndColsUnit... rows) {
        setTemplateRows(rows);
        return this;
    }

    public FluentGridLayout withRowAndColumn(Component component, int rowStart, int colStart) {
        return withRowAndColumn(component, rowStart, colStart, rowStart, colStart);
    }

    public FluentGridLayout withRowAndColumn(Component component, int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowStart < 0 || colStart < 0 || rowEnd < 0 || colEnd < 0) {
            throw new NegativeValueException(rowStart, colStart, rowEnd, colEnd);
        }
        return withRowAndColumn(component, new Int(rowStart), new Int(colStart), new Int(rowEnd), new Int(colEnd));
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
    public FluentGridLayout withRowAndColumn(Component component, RowOrColUnit rowStart, RowOrColUnit colStart, RowOrColUnit rowEnd, RowOrColUnit colEnd) {
        add(component);
        setRowAndColumn(component, rowStart, colStart, rowEnd, colEnd);
        return this;
    }

    /**
     * Shorthand fluent style method for adding a component and setting its area
     *
     * @param component the component to add
     * @param area      the area the element should be assigned
     * @return this
     */
    public FluentGridLayout withRowAndColumn(Component component, CustomIdent area) {
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
    public FluentGridLayout withItem(Component component) {
        add(component);
        return this;
    }

    /**
     * Shorthand fluent style method for adding one or multiple components
     *
     * @param components the components to add
     * @return this
     */
    public FluentGridLayout withItems(Component... components) {
        add(components);
        return this;
    }

    /**
     * Shorthand fluent style method to set the width of the layout
     *
     * @param width the width that should be assigned
     * @return this
     */
    public FluentGridLayout withWidth(java.lang.String width) {
        setWidth(width);
        return this;
    }

    /**
     * Fluent method of {@link GridLayout#setTemplateAreas(CustomIdent[][])} for setting the template areas available
     *
     * @param templateAreas the template areas you want to be assigned
     * @return this
     */
    public FluentGridLayout withTemplateAreas(CustomIdent[][] templateAreas) {
        setTemplateAreas(templateAreas);
        return this;
    }

    public FluentGridLayout withColumnAlign(Component component, ColumnAlign columnAlign) {
        setColumnAlign(component, columnAlign);
        return this;
    }

    public FluentGridLayout withRowAlign(Component component, RowAlign end) {
        setRowAlign(component, end);
        return this;
    }

    public FluentGridLayout withGap(Length size) {
        setGap(size);
        return this;
    }

    public FluentGridLayout withAutoRows(Length size) {
        setAutoRows(size);
        return this;
    }

    public FluentGridLayout withAutoColumns(Length size) {
        setAutoColumns(size);
        return this;
    }

    public FluentGridLayout withColumnStart(Component component, RowOrColUnit unit) {
        setColumnStart(component, unit);
        return this;
    }

    public FluentGridLayout withColumnEnd(Component component, RowOrColUnit unit) {
        setColumnEnd(component, unit);
        return this;
    }

    public FluentGridLayout withRowStart(Component component, RowOrColUnit unit) {
        setRowStart(component, unit);
        return this;
    }

    public FluentGridLayout withRowEnd(Component component, RowOrColUnit unit) {
        setRowEnd(component, unit);
        return this;
    }

}
