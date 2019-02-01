package com.github.appreciated.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class FractionalTest {
    @Test
    public void constructorTest() {
        // minmax(100px, max-content)
        Assert.assertEquals("1fr", new Fractional(1).getCssValue());
        Assert.assertEquals("2fr", new Fractional(2).getCssValue());
        Assert.assertEquals("3fr", new Fractional(3).getCssValue());
        Assert.assertEquals("4fr", new Fractional(4).getCssValue());
    }
}