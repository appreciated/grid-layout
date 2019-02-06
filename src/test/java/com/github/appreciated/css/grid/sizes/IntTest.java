package com.github.appreciated.css.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class IntTest {
    @Test
    public void constructorTest() {
        Assert.assertEquals("1", new Int(1).getCssValue());
    }
}