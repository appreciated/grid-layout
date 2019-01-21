package com.github.appreciated.grid;

import com.vaadin.flow.component.Component;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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

        List<Pair<Component, String>> list = new ArrayList<>();
        list.add(new Pair<>(new TestContent(), "header"));
        list.add(new Pair<>(new TestContent(), "content"));
        list.add(new Pair<>(new TestContent(), "left"));
        list.add(new Pair<>(new TestContent(), "right"));

        FluentGridLayout areaTest = new FluentGridLayout()
                .withWidth("100%")
                .withTemplateAreas(areas)
                .withItemAtArea(list.get(0).getKey(), list.get(0).getValue())
                .withItemAtArea(list.get(1).getKey(), list.get(1).getValue())
                .withItemAtArea(list.get(2).getKey(), list.get(2).getValue())
                .withItemAtArea(list.get(3).getKey(), list.get(3).getValue());

        Assert.assertEquals("1", list.get(0).getKey().getElement().getStyle().get("-ms-grid-row"));
        Assert.assertEquals("1", list.get(0).getKey().getElement().getStyle().get("-ms-grid-column"));
        Assert.assertEquals("5", list.get(0).getKey().getElement().getStyle().get("-ms-grid-column-span"));
        Assert.assertEquals("1", list.get(0).getKey().getElement().getStyle().get("-ms-grid-row-span"));

        Assert.assertEquals("2", list.get(1).getKey().getElement().getStyle().get("-ms-grid-row"));
        Assert.assertEquals("2", list.get(1).getKey().getElement().getStyle().get("-ms-grid-column"));
        Assert.assertEquals("3", list.get(1).getKey().getElement().getStyle().get("-ms-grid-column-span"));
        Assert.assertEquals("3", list.get(1).getKey().getElement().getStyle().get("-ms-grid-row-span"));

        Assert.assertEquals("2", list.get(2).getKey().getElement().getStyle().get("-ms-grid-row"));
        Assert.assertEquals("1", list.get(2).getKey().getElement().getStyle().get("-ms-grid-column"));
        Assert.assertEquals("1", list.get(2).getKey().getElement().getStyle().get("-ms-grid-column-span"));
        Assert.assertEquals("3", list.get(2).getKey().getElement().getStyle().get("-ms-grid-row-span"));

        Assert.assertEquals("2", list.get(3).getKey().getElement().getStyle().get("-ms-grid-row"));
        Assert.assertEquals("5", list.get(3).getKey().getElement().getStyle().get("-ms-grid-column"));
        Assert.assertEquals("1", list.get(3).getKey().getElement().getStyle().get("-ms-grid-column-span"));
        Assert.assertEquals("3", list.get(3).getKey().getElement().getStyle().get("-ms-grid-row-span"));
    }
}