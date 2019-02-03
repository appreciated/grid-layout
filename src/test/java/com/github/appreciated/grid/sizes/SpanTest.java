package com.github.appreciated.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class SpanTest {
    @Test
    public void constructorTest() {
        Assert.assertEquals("span 1", new Span(1).getCssValue());
        Assert.assertEquals("span 1 test", new Span(1, new Area("test")).getCssValue());
        Assert.assertEquals("span test", new Span(new Area("test")).getCssValue());
    }
}