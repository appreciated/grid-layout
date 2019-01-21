package com.github.appreciated.grid;

import com.vaadin.flow.component.Component;

/**
 * This class is purely for Internet Explorer to make it compatible with the new CSS Grid API.
 */
public class TemplateAreaParser {
    int top;
    int right;
    int left;
    int bottom;
    private String[][] templateAreas;

    public TemplateAreaParser(String[][] templateAreas) {
        this.templateAreas = templateAreas;
    }

    public void addIESupportStyles(Component component, String area) {
        top = templateAreas.length;
        left = templateAreas[0].length;
        right = 0;
        bottom = 0;
        for (int i = 0; i < templateAreas.length; i++) {
            for (int j = 0; j < templateAreas[i].length; j++) {
                if (templateAreas[i][j].equals(area)) {
                    if (j < left) {
                        left = j;
                    }
                    if (j > right) {
                        right = j;
                    }
                    if (i < top) {
                        top = i;
                    }
                    if (i > bottom) {
                        bottom = i;
                    }
                }
            }
        }
        component.getElement().getStyle()
                .set("-ms-grid-row", String.valueOf(top + 1))
                .set("-ms-grid-column", String.valueOf(left + 1))
                .set("-ms-grid-column-span", String.valueOf(right - left + 1))
                .set("-ms-grid-row-span", String.valueOf(bottom - top + 1));
    }
}
