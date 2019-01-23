package com.github.appreciated.grid.vaadin;

import com.vaadin.flow.component.Component;

public class FluentGridLayout extends GridLayout {

    public FluentGridLayout withGridRows(String... rows) {
        super.setGridRows(rows);
        return this;
    }

    public FluentGridLayout withGridColumns(String... rows) {
        super.setGridColumns(rows);
        return this;
    }

    public FluentGridLayout withSpan(Component component, int rowFrom, int colFrom, int rowTo, int colTo) {
        add(component);
        super.setSpan(component, colFrom, rowFrom, colTo, rowTo);
        return this;
    }

    public FluentGridLayout withPosition(Component component, int row, int column) {
        add(component);
        super.setPosition(component, row, column);
        return this;
    }

    public FluentGridLayout withColumnSpan(Component component, int from, int to) {
        add(component);
        super.setColumnSpan(component, from, to);
        return this;
    }

    public FluentGridLayout withRowSpan(Component component, int from, int to) {
        add(component);
        super.setRowSpan(component, from, to);
        return this;
    }

    public FluentGridLayout withColumnAlign(Component component, ColumnAlign align) {
        setColumnAlign(component, align);
        return this;
    }

    public FluentGridLayout withRowAlign(Component component, RowAlign align) {
        setRowAlign(component, align);
        return this;
    }
}