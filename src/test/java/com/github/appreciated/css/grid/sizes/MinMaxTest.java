package com.github.appreciated.css.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class MinMaxTest {

    @Test
    public void constructorTest() {
        Assert.assertEquals("minmax(100px,max-content)", new MinMax(new Length("100px"), new MaxContent()).getCssValue());
    }
}