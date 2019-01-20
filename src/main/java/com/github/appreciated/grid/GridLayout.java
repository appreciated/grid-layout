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
        getStyle().set("grid-template-rows", Arrays.stream(templateRows).reduce((s, s2) -> s + " " + s2).orElse(""));
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
        String areas = Arrays.stream(templateAreas)
                .map(strings -> Arrays.stream(strings).reduce((s, s2) -> s + " " + s2)
                        .orElse("")
                ).map(s -> "'" + s + "'")
                .reduce((s, s2) -> s + " " + s2)
                .orElse("");
        getStyle().set("grid-template-areas", areas);
    }


    /**
     * Fluent method of {@link GridLayout#setTemplateAreas(String[][])} (String...)}
     *
     * @param templateAreas
     * @return
     */
    public GridLayout withTemplateAreas(String[][] templateAreas) {
        setTemplateAreas(templateAreas);
        return this;
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

    public void setColumnAndRow(Component component, String column, String row) {
        setColumn(component, column);
        setRow(component, row);
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

    public void setArea(Component component, String area) {
        component.getElement().getStyle().set("grid-area", area);
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

