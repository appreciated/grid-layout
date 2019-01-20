package com.github.appreciated.grid;

import com.vaadin.flow.component.*;

import java.util.Arrays;
import java.util.Objects;

@Tag("div")
public class GridLayout extends Component implements HasStyle, HasOrderedComponents<Component>, HasSize {

    public GridLayout() {
        getStyle().set("display", "grid");
    }

    public GridLayout(Component... components) {
        this();
        this.add(components);
    }

    /**
     * @return
     */
    public String getColumnGap() {
        return getStyle().get("grid-column-gap");
    }

    /**
     * @param columnGap
     */
    public void setColumnGap(String columnGap) {
        if (columnGap == null) {
            getStyle().remove("grid-column-gap");
        } else {
            getStyle().set("grid-column-gap", columnGap);
        }
    }

    /**
     * @return
     */
    public String getRowGap() {
        return getStyle().get("grid-row-gap");
    }

    /**
     * @param rowGap
     */
    public void setRowGap(String rowGap) {
        if (rowGap == null) {
            getStyle().remove("grid-row-gap");
        } else {
            getStyle().set("grid-row-gap", rowGap);
        }
    }

    /**
     * @param gap
     */
    public void setGap(String gap) {
        if (gap == null) {
            getStyle().remove("grid-gap");
        } else {
            getStyle().set("grid-gap", gap);
        }
    }

    /**
     * @param columnGap
     * @param rowGap
     */
    public void setGap(String columnGap, String rowGap) {
        Objects.requireNonNull(columnGap);
        Objects.requireNonNull(rowGap);
        getStyle().set("grid-gap", columnGap + " " + rowGap);
    }

    public String getGap() {
        return getStyle().get("grid-gap");
    }

    /**
     * set the number of columns in your grid-layout, also you set here the number of columns desired.
     * Allowed values
     * Pixels: 100px 200px 300px 400px; 4 rows having pixel valued size
     * Auto: auto auto auto auto; 4 rows having the same size
     * Other: repeat(auto-fill, minmax(250px, 1fr));
     *
     * @param templateColumns "defines the number of columns in your grid layout, and it can define the width of each column."
     */
    public void setTemplateColumns(String... templateColumns) {
        getStyle().set("grid-template-columns", Arrays.stream(templateColumns).reduce((s, s2) -> s + " " + s2).orElse(""));
    }

    /**
     * @param templateAreas
     */
    public void setTemplateAreas(String[][] templateAreas) {
        getStyle().set("grid-template-areas",
                Arrays.stream(templateAreas)
                        .map(strings -> Arrays.stream(strings).reduce((s, s2) -> s + " " + s2)
                                .orElse("")
                        ).reduce((s, s2) -> s + "\n" + s2)
                        .orElse(""));
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
     * Sets the 'grid-column' value of an element
     *
     * @param component
     * @param column
     */
    public void setColumn(Component component, String column) {
        component.getElement().getStyle().set("grid-column", column);
    }

    public void setRow(Component component, String row) {
        component.getElement().getStyle().set("grid-row", row);
    }

    public void setColumnAndColumn(Component component, String column) {
        component.getElement().getStyle().set("grid-column", column);
    }

    public void setColumnEnd(Component component, int end) {
        component.getElement().getStyle().set("grid-column-end", String.valueOf(end));
    }

    public void setColumnStart(Component component, int start) {
        component.getElement().getStyle().set("grid-column-start", String.valueOf(start));
    }

    public void setColumnStartAndEnd(Component component, int start, int end) {
        setColumnStart(component, start);
        setColumnEnd(component, end);
    }

    public void setRowEnd(Component component, int end) {
        component.getElement().getStyle().set("grid-row-end", String.valueOf(end));
    }

    public void setRowStart(Component component, int start) {
        component.getElement().getStyle().set("grid-row-start", String.valueOf(start));
    }

    public void setRowStartAndEnd(Component component, int start, int end) {
        setRowStart(component, start);
        setRowEnd(component, end);
    }

    public void setArea(Component component, int rowStart, int colStart, int rowEnd, int colEnd) {
        setRowStartAndEnd(component, rowStart, rowEnd);
        setColumnStartAndEnd(component, colStart, colEnd);
    }

    public GridLayout withItemWithHeight(Component component, int height) {
        add(component);
        setItemHeight(component, height);
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

    public GridLayout withItem(Component component) {
        add(component);
        return this;
    }

    public GridLayout withItems(Component... components) {
        add(components);
        return this;
    }

    public void setJustifyContentMode(JustifyContentMode justifyContentMode) {
        if (justifyContentMode == null) {
            throw new IllegalArgumentException("The 'justifyContentMode' argument can not be null");
        } else {
            this.getElement().getStyle().set("justify-content", justifyContentMode.getFlexValue());
        }
    }

    public JustifyContentMode getJustifyContentMode() {
        return JustifyContentMode.toJustifyContentMode(this.getElement().getStyle().get("justify-content"), JustifyContentMode.START);
    }

    public GridLayout withWidth(String width) {
        setWidth(width);
        return this;
    }

    public static enum JustifyContentMode {
        START("flex-start"),
        END("flex-end"),
        CENTER("center"),
        BETWEEN("space-between"),
        AROUND("space-around"),
        EVENLY("space-evenly");

        private final String flexValue;

        JustifyContentMode(String flexValue) {
            this.flexValue = flexValue;
        }

        String getFlexValue() {
            return this.flexValue;
        }

        static JustifyContentMode toJustifyContentMode(String flexValue, JustifyContentMode defaultValue) {
            return Arrays.stream(values())
                    .filter((justifyContent) -> justifyContent.getFlexValue().equals(flexValue))
                    .findFirst()
                    .orElse(defaultValue);
        }
    }

    public void setAlignContentMode(AlignContentMode alignContentMode) {
        if (alignContentMode == null) {
            throw new IllegalArgumentException("The 'alignContentMode' argument can not be null");
        } else {
            this.getElement().getStyle().set("align-content", alignContentMode.getFlexValue());
        }
    }

    public AlignContentMode getAlignMode() {
        return AlignContentMode.toAlignment(this.getElement().getStyle().get("align-content"), AlignContentMode.START);
    }

    public static enum AlignContentMode {
        START("flex-start"),
        END("flex-end"),
        CENTER("center"),
        STRETCH("stretch"),
        BASELINE("baseline"),
        AUTO("auto");

        private final String flexValue;

        AlignContentMode(String flexValue) {
            this.flexValue = flexValue;
        }

        String getFlexValue() {
            return this.flexValue;
        }

        static AlignContentMode toAlignment(String flexValue, AlignContentMode defaultValue) {
            return Arrays.stream(values())
                    .filter((alignment) -> alignment.getFlexValue().equals(flexValue))
                    .findFirst()
                    .orElse(defaultValue);
        }
    }
}

