package com.github.appreciated.grid;

import com.vaadin.flow.component.*;

import java.util.Arrays;

@Tag("div")
public class GridLayout extends Component implements HasStyle, HasComponents, HasSize {

    public GridLayout() {
        getStyle().set("display", "grid");
    }

    public GridLayout(Component... components) {
        this();
        this.add(components);
    }

    public void setColumnGap(String columnGap) {
        if (columnGap == null) {
            getStyle().remove("grid-column-gap");
        } else {
            getStyle().set("grid-column-gap", columnGap);
        }
    }

    public String getColumnGap() {
        return getStyle().get("align-self");
    }

    public void setRowGap(String rowGap) {
        if (rowGap == null) {
            getStyle().remove("grid-row-gap");
        } else {
            getStyle().set("grid-row-gap", rowGap);
        }
    }

    public String getRowGap() {
        return getStyle().get("grid-row-gap");
    }

    public void setGap(String gap) {
        if (gap == null) {
            getStyle().remove("grid-gap");
        } else {
            getStyle().set("grid-gap", gap);
        }
    }

    public String getGap() {
        return getStyle().get("grid-gap");
    }

    public void setColumns(String... columns) {
        getStyle().set("grid-template-columns", Arrays.stream(columns).reduce((s, s2) -> s + " " + s2).orElse(""));
    }

    public void setItemWidth(Component component, int width) {
        component.getElement().getStyle().set("grid-column", "span " + width);
    }

    public void setItemHeight(Component component, int height) {
        component.getElement().getStyle().set("grid-row", "span " + height);
    }

    public void setItemSize(Component component, int width, int height) {
        setItemHeight(component, height);
        setItemWidth(component, width);
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

    public void setAlignContentMode(AlignmentMode alignContentMode) {
        if (alignContentMode == null) {
            throw new IllegalArgumentException("The 'justifyContentMode' argument can not be null");
        } else {
            this.getElement().getStyle().set("align-content", alignContentMode.getFlexValue());
        }
    }

    public AlignmentMode getAlignContentMode() {
        return AlignmentMode.toAlignment(this.getElement().getStyle().get("align-content"), AlignmentMode.START);
    }

    public static enum AlignmentMode {
        START("flex-start"),
        END("flex-end"),
        CENTER("center"),
        STRETCH("stretch"),
        BASELINE("baseline"),
        AUTO("auto");

        private final String flexValue;

        AlignmentMode(String flexValue) {
            this.flexValue = flexValue;
        }

        String getFlexValue() {
            return this.flexValue;
        }

        static AlignmentMode toAlignment(String flexValue, AlignmentMode defaultValue) {
            return Arrays.stream(values())
                    .filter((alignment) -> alignment.getFlexValue().equals(flexValue))
                    .findFirst()
                    .orElse(defaultValue);
        }
    }

}

