package com.github.appreciated.layout;

import com.github.appreciated.css.grid.sizes.Area;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;

import java.util.Arrays;

public class AreaLayout extends Composite<GridLayout> implements HasSize, HasStyle {
    public AreaLayout(String[][] areas) {
        getContent().setTemplateAreas(Arrays.stream(areas).map(strings ->
                Arrays.stream(strings).map(Area::new).toArray(Area[]::new)
        ).toArray(Area[][]::new));
    }

    public AreaLayout withItemAtArea(Component component, String area) {
        getContent().add(component);
        getContent().setArea(component, new Area(area));
        return this;
    }
}
