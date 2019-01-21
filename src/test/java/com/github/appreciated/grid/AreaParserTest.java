package com.github.appreciated.grid;

import com.vaadin.flow.component.Component;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AreaParserTest {
    @Test
    public void name() {
        String[][] areas = new String[][]{
                new String[]{"header", "header", "header", "header", "header"},
                new String[]{"left", "content", "content", "content", "right"},
                new String[]{"left", "content", "content", "content", "right"},
                new String[]{"left", "content", "content", "content", "right"},
        };

        List<Pair<Component, String>> list = Arrays.asList(
                new Pair<>(new TestContent(), "header"),
                new Pair<>(new TestContent(), "content"),
                new Pair<>(new TestContent(), "left"),
                new Pair<>(new TestContent(), "right")
        );

        FluentGridLayout areaTest = new FluentGridLayout()
                .withWidth("100%")
                .withTemplateAreas(areas)
                .withItemAtArea(list.get(0).getKey(), list.get(0).getValue())
                .withItemAtArea(list.get(1).getKey(), list.get(1).getValue())
                .withItemAtArea(list.get(2).getKey(), list.get(2).getValue())
                .withItemAtArea(list.get(3).getKey(), list.get(3).getValue());

        assertStyleEquals("1", list, 0, "-ms-grid-row");
        assertStyleEquals("1", list, 0, "-ms-grid-column");
        assertStyleEquals("5", list, 0, "-ms-grid-column-span");
        assertStyleEquals("1", list, 0, "-ms-grid-row-span");

        assertStyleEquals("2", list, 1, "-ms-grid-row");
        assertStyleEquals("2", list, 1, "-ms-grid-column");
        assertStyleEquals("3", list, 1, "-ms-grid-column-span");
        assertStyleEquals("3", list, 1, "-ms-grid-row-span");

        assertStyleEquals("2", list, 2, "-ms-grid-row");
        assertStyleEquals("1", list, 2, "-ms-grid-column");
        assertStyleEquals("1", list, 2, "-ms-grid-column-span");
        assertStyleEquals("3", list, 2, "-ms-grid-row-span");

        assertStyleEquals("2", list, 3, "-ms-grid-row");
        assertStyleEquals("5", list, 3, "-ms-grid-column");
        assertStyleEquals("1", list, 3, "-ms-grid-column-span");
        assertStyleEquals("3", list, 3, "-ms-grid-row-span");
    }

    public void assertStyleEquals(String expectedValue, List<Pair<Component, String>> list, int index, String style) {
        Assert.assertEquals(expectedValue, list.get(index).getKey().getElement().getStyle().get(style));
    }

}