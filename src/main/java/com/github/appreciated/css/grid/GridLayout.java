package com.github.appreciated.css.grid;

import com.github.appreciated.css.grid.entities.GridTemplates;
import com.github.appreciated.css.grid.interfaces.AreaUnit;
import com.github.appreciated.css.grid.interfaces.CssUnit;
import com.github.appreciated.css.grid.interfaces.RowOrColUnit;
import com.github.appreciated.css.grid.interfaces.TemplateRowsAndColsUnit;
import com.github.appreciated.css.grid.sizes.Area;
import com.github.appreciated.css.grid.sizes.Length;
import com.vaadin.flow.component.*;

import java.util.Arrays;
import java.util.Objects;

@Tag("div")
public class GridLayout extends Component implements HasStyle, HasOrderedComponents<Component>, HasSize, GridLayoutComponent {

    /**
     * @param components
     */
    public GridLayout(Component... components) {
        this();
        this.add(components);
    }

    /**
     *
     */
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
    public void setColumnGap(Length columnGap) {
        if (columnGap == null) {
            getStyle().remove("grid-column-gap");
        } else {
            getStyle().set("grid-column-gap", columnGap.getCssValue());
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
    public void setRowGap(Length rowGap) {
        if (rowGap == null) {
            getStyle().remove("grid-row-gap");
        } else {
            getStyle().set("grid-row-gap", rowGap.getCssValue());
        }
    }

    /**
     * @param columnGap
     * @param rowGap
     */
    public void setGap(Length columnGap, Length rowGap) {
        Objects.requireNonNull(columnGap);
        Objects.requireNonNull(rowGap);
        getStyle().set("grid-gap", columnGap.getCssValue() + " " + rowGap.getCssValue());
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
    public void setGap(Length gap) {
        if (gap == null) {
            getStyle().remove("grid-gap");
        } else {
            getStyle().set("grid-gap", gap.getCssValue());
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
    public void setTemplateColumns(TemplateRowsAndColsUnit... units) {
        getStyle().set("grid-template-columns", Arrays.stream(units).map(CssUnit::getCssValue).reduce((s, s2) -> s + " " + s2).orElse(""));
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
    public void setTemplateRows(TemplateRowsAndColsUnit... units) {
        if (units == null) {
            getStyle().remove("grid-template-rows");
        } else {
            getStyle().set("grid-template-rows", Arrays.stream(units).map(CssUnit::getCssValue).reduce((s, s2) -> s + " " + s2).orElse(""));
        }
    }

    /**
     * @param template
     */
    public void setTemplate(GridTemplates template) {
        if (template == null) {
            getStyle().remove("grid-template");
        } else {
            getStyle().set("grid-template", template.getTemplateRows().getCssValue() + " / " + template.getTemplateColumns().getCssValue());
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
     * In the second step you set the area for each item which will then span over the above defined area. Use therefore {@link GridLayout#setArea(Component, AreaUnit...)}}
     *
     * @param templateAreas
     */
    public void setTemplateAreas(Area[][] templateAreas) {
        if (templateAreas == null) {
            getStyle().remove("grid-template-areas");
        } else {
            String areas = Arrays.stream(templateAreas)
                    .map(strings -> Arrays.stream(strings).map(CssUnit::getCssValue).reduce((s, s2) -> s + " " + s2)
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
    public void setColumnAndRow(Component component, RowOrColUnit column, RowOrColUnit row) {
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
    public void setColumn(Component component, RowOrColUnit column) {
        if (column == null) {
            component.getElement().getStyle().remove("grid-column");
        } else {
            component.getElement().getStyle().set("grid-column", column.getCssValue());
        }
    }

    /**
     * @param component
     * @param row
     */
    public void setRow(Component component, RowOrColUnit row) {
        if (row == null) {
            component.getElement().getStyle().remove("grid-row");
        } else {
            component.getElement().getStyle().set("grid-row", row.getCssValue());
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
     * @param area
     */
    public void setArea(Component component, AreaUnit... area) {
        if (area == null) {
            component.getElement().getStyle().remove("grid-area");
        } else {
            component.getElement().getStyle().set("grid-area", Arrays.stream(area).map(CssUnit::getCssValue)
                    .reduce((s, s2) -> s + " / " + s2)
                    .orElse(""));
        }
    }

    /**
     * @param component
     * @param rowStart
     * @param colStart
     * @param rowEnd
     * @param colEnd
     */
    public void setArea(Component component, RowOrColUnit rowStart, RowOrColUnit colStart, RowOrColUnit rowEnd, RowOrColUnit colEnd) {
        setRowStartAndEnd(component, rowStart, rowEnd);
        setColumnStartAndEnd(component, colStart, colEnd);
    }

    /**
     * @param component
     * @param start
     * @param end
     */
    public void setRowStartAndEnd(Component component, RowOrColUnit start, RowOrColUnit end) {
        setRowStart(component, start);
        setRowEnd(component, end);
    }

    /**
     * @param component
     * @param start
     * @param end
     */
    public void setColumnStartAndEnd(Component component, RowOrColUnit start, RowOrColUnit end) {
        setColumnStart(component, start);
        setColumnEnd(component, end);
    }

    /**
     * @param component
     * @param rowStart
     */

    public void setRowStart(Component component, RowOrColUnit rowStart) {
        if (rowStart == null) {
            component.getElement().getStyle().remove("grid-row-start");
        } else {
            component.getElement().getStyle().set("grid-row-start", rowStart.getCssValue());
        }
    }

    /**
     * @param component
     * @param rowEnd
     */
    public void setRowEnd(Component component, RowOrColUnit rowEnd) {
        if (rowEnd == null) {
            component.getElement().getStyle().remove("grid-row-end");
        } else {
            component.getElement().getStyle().set("grid-row-end", rowEnd.getCssValue());
        }
    }

    /**
     * @param component
     * @param colStart
     */
    public void setColumnStart(Component component, RowOrColUnit colStart) {
        if (colStart == null) {
            component.getElement().getStyle().remove("grid-column-start");
        } else {
            component.getElement().getStyle().set("grid-column-start", colStart.getCssValue());
        }
    }

    /**
     * @param component
     * @param colEnd
     */
    public void setColumnEnd(Component component, RowOrColUnit colEnd) {
        if (colEnd == null) {
            component.getElement().getStyle().remove("grid-column-end");
        } else {
            component.getElement().getStyle().set("grid-column-end", colEnd.getCssValue());
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
     * @param size
     */
    public void setAutoColumns(Length size) {
        if (size == null) {
            getStyle().remove("grid-auto-columns");
        } else {
            getStyle().set("grid-auto-columns", size.getCssValue());
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
     * @param size
     */
    public void setAutoRows(Length size) {
        if (size == null) {
            getStyle().remove("grid-auto-rows");
        } else {
            getStyle().set("grid-auto-rows", size.getCssValue());
        }
    }

}

