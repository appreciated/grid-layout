package com.github.appreciated.grid;

import com.github.appreciated.grid.grid.sizes.CssGridUnit;
import com.vaadin.flow.component.*;

import java.util.Arrays;
import java.util.Objects;

@Tag("div")
public class FlexibleGridLayout extends Component implements HasStyle, HasOrderedComponents<Component>, HasSize, GridLayoutComponent {

    /**
     * @param components
     */
    public FlexibleGridLayout(Component... components) {
        this();
        this.add(components);
    }

    /**
     *
     */
    public FlexibleGridLayout() {
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

    /**
     * @return
     */
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
     * @param units "The column definition in your grid layout, can either be fixed or dynamic checkout the official css grid documentation for further details"
     */
    public void setTemplateColumns(CssGridUnit... units) {
        getStyle().set("grid-template-columns", Arrays.stream(units).map(CssGridUnit::getValue).reduce((s, s2) -> s + " " + s2).orElse(""));
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
     * @param units "The row definition in your grid layout, can either be fixed or dynamic checkout the official css grid documentation for further details"
     */
    public void setTemplateRows(CssGridUnit... units) {
        if (units == null) {
            getStyle().remove("grid-template-rows");
        } else {
            getStyle().set("grid-template-rows", Arrays.stream(units).map(CssGridUnit::getValue).reduce((s, s2) -> s + " " + s2).orElse(""));
        }
    }

    /**
     * @param template
     */
    public void setTemplate(String template) {
        if (template == null) {
            getStyle().remove("grid-template");
        } else {
            getStyle().set("grid-template", template);
        }
    }

    /**
     * @return
     */
    public String getGrid() {
        return getStyle().get("grid");
    }

    /**
     * @param grid
     */
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
     * In the second step you set the area for each item which will then span over the above defined area. Use therefor {@link FlexibleGridLayout#setArea(Component, String)} (Component, int, int, int, int)}
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

    /**
     * @param component
     */
    public void getRow(Component component) {
        component.getElement().getStyle().get("grid-row");
    }

    /**
     * @param component
     * @param column
     * @param row
     */
    public void setColumnAndRow(Component component, String column, String row) {
        setColumn(component, column);
        setRow(component, row);
    }

    /**
     * This property is specified as one or two <grid-line> values.
     * <p>
     * If two <grid-line> values are given they are separated by "/". The grid-column-start longhand is set to the value before the slash, and the grid-column-end longhand is set to the value after the slash.
     * <p>
     * Each <grid-line> value can be specified as:
     * <p>
     * either the auto keyword
     * or a <custom-ident> value
     * or an <integer> value
     * or both <custom-ident> and <integer>, separated by a space
     * or the keyword span together with either a <custom-ident> or an <integer> or both.
     * <p>
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

    /**
     * @param component
     * @param row
     */
    public void setRow(Component component, String row) {
        if (row == null) {
            component.getElement().getStyle().remove("grid-row");
        } else {
            component.getElement().getStyle().set("grid-row", row);
        }
    }

    /**
     * @param component
     * @return
     */
    public String getColumnEnd(Component component) {
        return component.getElement().getStyle().get("grid-column-end");
    }

    /**
     * @param component
     * @return
     */
    public String getColumnStart(Component component) {
        return component.getElement().getStyle().get("grid-column-start");
    }

    /**
     * @param component
     * @return
     */
    public String getRowEnd(Component component) {
        return component.getElement().getStyle().get("grid-row-end");
    }

    /**
     * @param component
     * @return
     */
    public String getRowStart(Component component) {
        return component.getElement().getStyle().get("grid-row-start");
    }

    /**
     * @param component
     * @param rowStart
     * @param colStart
     * @param rowEnd
     * @param colEnd
     */
    public void setArea(Component component, String rowStart, String colStart, String rowEnd, String colEnd) {
        setRowStartAndEnd(component, rowStart, rowEnd);
        setColumnStartAndEnd(component, colStart, colEnd);
    }

    /**
     * @param component
     * @param start
     * @param end
     */
    public void setRowStartAndEnd(Component component, String start, String end) {
        setRowStart(component, start);
        setRowEnd(component, end);
    }

    /**
     * @param component
     * @param start
     * @param end
     */
    public void setColumnStartAndEnd(Component component, String start, String end) {
        setColumnStart(component, start);
        setColumnEnd(component, end);
    }

    /**
     * @param component
     * @param start
     */

    public void setRowStart(Component component, String start) {
        if (start == null) {
            component.getElement().getStyle().remove("grid-row-start");
        } else {
            component.getElement().getStyle().set("grid-row-start", start);
        }
    }

    /**
     * @param component
     * @param end
     */
    public void setRowEnd(Component component, String end) {
        if (end == null) {
            component.getElement().getStyle().remove("grid-row-end");
        } else {
            component.getElement().getStyle().set("grid-row-end", end);
        }
    }

    /**
     * @param component
     * @param start
     */
    public void setColumnStart(Component component, String start) {
        if (start == null) {
            component.getElement().getStyle().remove("grid-column-start");
        } else {
            component.getElement().getStyle().set("grid-column-start", start);
        }
    }

    /**
     * @param component
     * @param end
     */
    public void setColumnEnd(Component component, String end) {
        if (end == null) {
            component.getElement().getStyle().remove("grid-column-end");
        } else {
            component.getElement().getStyle().set("grid-column-end", end);
        }
    }

    /**
     * @param component
     * @param area
     */
    public void setArea(Component component, String area) {
        if (area == null) {
            component.getElement().getStyle().remove("grid-area");
        } else {
            component.getElement().getStyle().set("grid-area", area);
        }
    }

    /**
     * @param component
     * @return
     */
    public String getArea(Component component) {
        return component.getElement().getStyle().get("grid-area");
    }

    /**
     * @return
     */
    public String getAutoColumns() {
        return getStyle().get("grid-auto-columns");
    }

    /**
     * @param autoColumns
     */
    public void setAutoColumns(String autoColumns) {
        if (autoColumns == null) {
            getStyle().remove("grid-auto-columns");
        } else {
            getStyle().set("grid-auto-columns", autoColumns);
        }
    }

    /**
     * @return
     */
    public AutoFlow getAutoFlow() {
        return AutoFlow.toAutoFlow(getStyle().get(AutoFlow.cssProperty));
    }

    /**
     * @param autoFlow
     */
    public void setAutoFlow(AutoFlow autoFlow) {
        if (autoFlow == null) {
            getStyle().remove(autoFlow.cssProperty);
        } else {
            getStyle().set(autoFlow.cssProperty, autoFlow.getAutoFlowValue());
        }
    }

    /**
     * @return
     */
    public String getAutoRows() {
        return getStyle().get("grid-auto-rows");
    }

    /**
     * @param autoRows
     */
    public void setAutoRows(String autoRows) {
        if (autoRows == null) {
            getStyle().remove("grid-auto-rows");
        } else {
            getStyle().set("grid-auto-rows", autoRows);
        }
    }

}

