package com.github.appreciated.layout;

import com.github.appreciated.css.grid.sizes.CustomIdent;
import com.github.appreciated.css.grid.sizes.TemplateArea;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;

import java.util.Arrays;

/**
 * A Layout which makes it easy for the user to create area based grids.
 */
public class AreaLayout extends Composite<GridLayout> implements HasSize, HasStyle {
    public AreaLayout(String[][] areas) {
        getContent().setTemplateAreas(Arrays.stream(areas).map(strings ->
                Arrays.stream(strings).map(CustomIdent::new).toArray(CustomIdent[]::new)
        ).toArray(CustomIdent[][]::new));
    }

    public AreaLayout withItemAtArea(Component component, String area) {
        getContent().add(component);
        getContent().setArea(component, new TemplateArea(area));
        return this;
    }
}
