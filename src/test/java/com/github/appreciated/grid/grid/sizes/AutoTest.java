package com.github.appreciated.grid.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class AutoTest {

    @Test
    public void constructorTest() {
        Assert.assertEquals("auto", new Auto().getCssValue());
    }
}