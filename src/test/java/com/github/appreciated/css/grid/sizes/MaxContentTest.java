package com.github.appreciated.css.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class MaxContentTest {

    @Test
    public void constructorTest() {
        // minmax(100px, max-content)
        Assert.assertEquals("max-content", new MaxContent().getCssValue());
    }
}