package com.github.appreciated.layout;

import com.github.appreciated.css.grid.GridLayoutComponent;
import com.github.appreciated.css.grid.sizes.TemplateArea;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;

import java.util.Arrays;

/**
 * A Layout which makes it easy for the user to create area based grids.
 */
public class AreaLayout extends Composite<GridLayout> implements HasSize, HasStyle, GridLayoutComponent {

    /**
     * Shorthand to allow setting the <a href="https://developer.mozilla.org/de/docs/Web/CSS/grid-template-areas">grid-template-areas</a>
     *
     * @param areas
     */
    public AreaLayout(String[][] areas) {
        getContent().setTemplateAreas(Arrays.stream(areas).map(strings ->
                Arrays.stream(strings).map(TemplateArea::new).toArray(TemplateArea[]::new)
        ).toArray(TemplateArea[][]::new));
    }

    /**
     * Short hand to add an item and set its <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/grid-area">grid-area</a>
     *
     * @param component
     * @param area
     * @return
     */
    public AreaLayout withItemAtArea(Component component, String area) {
        getContent().add(component);
        getContent().setArea(component, new TemplateArea(area));
        return this;
    }
}
