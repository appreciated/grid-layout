package com.github.appreciated.grid;

import com.vaadin.flow.component.*;

import java.util.Arrays;
import java.util.Objects;

@Tag("div")
public class GridLayout extends Component implements HasStyle, HasOrderedComponents<Component>, HasSize {

    public GridLayout(Component... components) {
        this();
        this.add(components);
    }

    public GridLayout() {
        getStyle().set("display", "grid");
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
     * Sets the number of columns in your grid-layout.  <br>
     * #Allowed Values  <br>
     * Fixed number of rows:  <br>
     * Pixels: 100px 200px 300px 400px | 4 rows having pixel valued size  <br>
     * Auto: auto auto auto auto | 4 rows having the same size  <br>
     * Fr: auto 1fr auto | checkout the css grid documentation <br>
     * #Dynamic Number of rows  <br>
     * Other: repeat(auto-fill, minmax(250px, 1fr));  <br>
     *
     * @param templateColumns "The column definition in your grid layout, can either be fixed or dynamic checkout the official css grid documentation for further details"
     */
    public void setTemplateColumns(String... templateColumns) {
        getStyle().set("grid-template-columns", Arrays.stream(templateColumns).reduce((s, s2) -> s + " " + s2).orElse(""));
    }

    /**
     * Sets the number of rows in your grid-layout.  <br>
     * #Allowed Values  <br>
     * Fixed number of rows:  <br>
     * Pixels: 100px 200px 300px 400px | 4 rows having pixel valued size  <br>
     * Auto: auto auto auto auto | 4 rows having the same size  <br>
     * Fr: auto 1fr auto | checkout the css grid documentation <br>
     * #Dynamic Number of rows  <br>
     * Other: repeat(auto-fill, minmax(250px, 1fr));  <br>
     *
     * @param templateRows "The row definition in your grid layout, can either be fixed or dynamic checkout the official css grid documentation for further details"
     */
    public void setTemplateRows(String... templateRows) {
        if (templateRows == null) {
            getStyle().remove("grid-template-rows");
        } else {
            getStyle().set("grid-template-rows", Arrays.stream(templateRows).reduce((s, s2) -> s + " " + s2).orElse(""));
        }
    }

    public void setTemplate(String template) {
        if (template == null) {
            getStyle().remove("grid-template");
        } else {
            getStyle().set("grid-template", template);
        }
    }

    public String getGrid() {
        return getStyle().get("grid");
    }

    public void setGrid(String grid) {
        if (grid == null) {
            getStyle().remove("grid");
        } else {
            getStyle().set("grid", grid);
        }
    }

    /**
     * Sets the column and row definition of your grid-layout. Instead of setting the sizes for rows and columns you
     * define areas by using custom keywords. <br>
     * <p>
     * Example:   <br>
     * 'header header header header header header' <br>
     * 'menu main main main right right'  <br>
     * 'menu footer footer footer footer footer';  <br>
     * <p>
     * In the second step you set the area for each item which will then span over the above defined area. Use therefor {@link GridLayout#setArea(Component, int, int, int, int)}
     *
     * @param templateAreas
     */
    public void setTemplateAreas(String[][] templateAreas) {
        if (templateAreas == null) {
            getStyle().remove("grid-template-areas");
        } else {
            String areas = Arrays.stream(templateAreas)
                    .map(strings -> Arrays.stream(strings).reduce((s, s2) -> s + " " + s2)
                            .orElse("")
                    ).map(s -> "'" + s + "'")
                    .reduce((s, s2) -> s + " " + s2)
                    .orElse("");
            getStyle().set("grid-template-areas", areas);
        }
    }

    public void getRow(Component component) {
        component.getElement().getStyle().get("grid-row");
    }

    public void setColumnAndRow(Component component, String column, String row) {
        setColumn(component, column);
        setRow(component, row);
    }

    /**
     * Sets the 'grid-column' value of an element
     *
     * @param component
     * @param column
     */
    public void setColumn(Component component, String column) {
        if (column == null) {
            component.getElement().getStyle().remove("grid-column");
        } else {
            component.getElement().getStyle().set("grid-column", column);
        }
    }

    public void setRow(Component component, String row) {
        if (row == null) {
            component.getElement().getStyle().remove("grid-row");
        } else {
            component.getElement().getStyle().set("grid-row", row);
        }
    }

    public String getColumnEnd(Component component) {
        return component.getElement().getStyle().get("grid-column-end");
    }

    public String getColumnStart(Component component) {
        return component.getElement().getStyle().get("grid-column-start");
    }

    public String getRowEnd(Component component) {
        return component.getElement().getStyle().get("grid-row-end");
    }

    public String getRowStart(Component component) {
        return component.getElement().getStyle().get("grid-row-start");
    }

    public void setArea(Component component, String rowStart, String colStart, String rowEnd, String colEnd) {
        setRowStartAndEnd(component, rowStart, rowEnd);
        setColumnStartAndEnd(component, colStart, colEnd);
    }

    public void setRowStartAndEnd(Component component, String start, String end) {
        setRowStart(component, start);
        setRowEnd(component, end);
    }

    public void setColumnStartAndEnd(Component component, String start, String end) {
        setColumnStart(component, start);
        setColumnEnd(component, end);
    }

    public void setRowStart(Component component, String start) {
        if (start == null) {
            component.getElement().getStyle().remove("grid-row-start");
        } else {
            component.getElement().getStyle().set("grid-row-start", start);
        }
    }

    public void setRowEnd(Component component, String end) {
        if (end == null) {
            component.getElement().getStyle().remove("grid-row-end");
        } else {
            component.getElement().getStyle().set("grid-row-end", end);
        }
    }

    public void setColumnStart(Component component, String start) {
        if (start == null) {
            component.getElement().getStyle().remove("grid-column-start");
        } else {
            component.getElement().getStyle().set("grid-column-start", start);
        }
    }

    public void setColumnEnd(Component component, String end) {
        if (end == null) {
            component.getElement().getStyle().remove("grid-column-end");
        } else {
            component.getElement().getStyle().set("grid-column-end", end);
        }
    }

    public void setArea(Component component, String area) {
        if (area == null) {
            getStyle().remove("grid-area");
        } else {
            getStyle().set("grid-area", area);
        }
    }

    public String getArea() {
        return getStyle().get("grid-area");
    }

    public String getAutoColumns() {
        return getStyle().get("grid-auto-columns");
    }

    public void setAutoColumns(String autoColumns) {
        if (autoColumns == null) {
            getStyle().remove("grid-auto-columns");
        } else {
            getStyle().set("grid-auto-columns", autoColumns);
        }
    }

    public String getAutoFlow() {
        return getStyle().get("grid-auto-flow");
    }

    public void setAutoFlow(String autoFlow) {
        if (autoFlow == null) {
            getStyle().remove("grid-auto-flow");
        } else {
            getStyle().set("grid-auto-flow", autoFlow);
        }
    }

    public String getAutoRows() {
        return getStyle().get("grid-auto-rows");
    }

    public void setAutoRows(String autoRows) {
        if (autoRows == null) {
            getStyle().remove("grid-auto-rows");
        } else {
            getStyle().set("grid-auto-rows", autoRows);
        }
    }

    public JustifyContentMode getJustifyContentMode() {
        return JustifyContentMode.toJustifyContentMode(this.getElement().getStyle().get("justify-content"), JustifyContentMode.START);
    }

    public void setJustifyContentMode(JustifyContentMode justifyContentMode) {
        if (justifyContentMode == null) {
            throw new IllegalArgumentException("The 'justifyContentMode' argument can not be null");
        } else {
            this.getElement().getStyle().set("justify-content", justifyContentMode.getFlexValue());
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

    public enum JustifyContentMode {
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

        static JustifyContentMode toJustifyContentMode(String flexValue, JustifyContentMode defaultValue) {
            return Arrays.stream(values())
                    .filter((justifyContent) -> justifyContent.getFlexValue().equals(flexValue))
                    .findFirst()
                    .orElse(defaultValue);
        }

        String getFlexValue() {
            return this.flexValue;
        }
    }

    public enum AlignContentMode {
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

        static AlignContentMode toAlignment(String flexValue, AlignContentMode defaultValue) {
            return Arrays.stream(values())
                    .filter((alignment) -> alignment.getFlexValue().equals(flexValue))
                    .findFirst()
                    .orElse(defaultValue);
        }

        String getFlexValue() {
            return this.flexValue;
        }
    }
}

