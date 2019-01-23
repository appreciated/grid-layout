package com.github.appreciated.grid.vaadin;

import com.vaadin.flow.component.Component;

import java.util.Arrays;

public interface GridLayoutComponent {

    default void setColumnAlign(Component component, ColumnAlign align) {
        for (String cssProperty : ColumnAlign.cssProperties) {
            component.getElement().getStyle().set(cssProperty, align.getAlignValue());
        }
    }

    default void setRowAlign(Component component, RowAlign align) {
        for (String cssProperty : RowAlign.cssProperties) {
            component.getElement().getStyle().set(cssProperty, align.getAlignValue());
        }
    }

    public enum ColumnAlign {
        START("start"),
        END("end"),
        CENTER("center"),
        STRETCH("stretch");

        public static final String[] cssProperties = new String[]{"justify-self", "-ms-grid-column-align"};
        private final String alignValue;

        ColumnAlign(String alignValue) {
            this.alignValue = alignValue;
        }

        static ColumnAlign toColumnAlign(String alignValue, ColumnAlign defaultValue) {
            return Arrays.stream(values())
                    .filter((justifyContent) -> justifyContent.getAlignValue().equals(alignValue))
                    .findFirst()
                    .orElse(defaultValue);
        }

        String getAlignValue() {
            return this.alignValue;
        }
    }

    public enum RowAlign {
        START("start"),
        END("end"),
        CENTER("center"),
        STRETCH("stretch");

        public static final String[] cssProperties = new String[]{"align-self", "-ms-grid-row-align"};
        private final String alignValue;

        RowAlign(String alignValue) {
            this.alignValue = alignValue;
        }

        static RowAlign toAlignment(String alignValue, RowAlign defaultValue) {
            return Arrays.stream(values())
                    .filter((alignment) -> alignment.getAlignValue().equals(alignValue))
                    .findFirst()
                    .orElse(defaultValue);
        }

        String getAlignValue() {
            return this.alignValue;
        }
    }
}
