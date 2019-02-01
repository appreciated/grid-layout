package com.github.appreciated.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class RepeatTest {
    @Test
    public void constructorTest() {

        //repeat(4, 100px min-content 100px max-content 100px)
        Assert.assertEquals("repeat(4, 100px min-content 100px max-content 100px)", new Repeat(4, new Size(100, Size.CssUnit.PX), new MinContent(), new Size(100, Size.CssUnit.PX), new MaxContent(), new Size(100, Size.CssUnit.PX)).getCssValue());
        //repeat(auto-fill, 250px)
        //repeat(auto-fit, 250px)
        //repeat(auto-fill, [col-start] 250px [col-end])
        //repeat(auto-fit, [col-start] 250px [col-end])

    }
}