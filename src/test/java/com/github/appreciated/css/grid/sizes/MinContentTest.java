package com.github.appreciated.css.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class MinContentTest {

    @Test
    public void constructorTest() {
        Assert.assertEquals("min-content", new MinContent().getCssValue());
    }
}