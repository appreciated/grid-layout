package com.github.appreciated.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class MinMaxTest {

    @Test
    public void constructorTest() {
        // minmax(100px, max-content)
        Assert.assertEquals("minmax(100px,max-content)", new MinMax(new Size("100px"), new MaxContent()).getCssValue());
    }
}