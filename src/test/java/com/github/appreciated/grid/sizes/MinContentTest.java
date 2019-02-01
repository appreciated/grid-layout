package com.github.appreciated.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class MinContentTest {

    @Test
    public void constructorTest() {
        // minmax(100px, max-content)
        Assert.assertEquals("min-content", new MinContent().getCssValue());
    }
}