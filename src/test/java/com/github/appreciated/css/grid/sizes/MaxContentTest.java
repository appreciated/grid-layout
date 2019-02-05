package com.github.appreciated.css.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class MaxContentTest {

    @Test
    public void constructorTest() {
        Assert.assertEquals("max-content", new MaxContent().getCssValue());
    }
}