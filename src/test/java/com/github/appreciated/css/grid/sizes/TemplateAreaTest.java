package com.github.appreciated.css.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class TemplateAreaTest {

    @Test
    public void constructorTest() {
        Assert.assertEquals("test", new TemplateArea("test").getCssValue());
    }
}