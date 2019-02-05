package com.github.appreciated.css.grid.sizes;

import com.github.appreciated.css.grid.exception.NegativeOrZeroValueException;
import org.junit.Assert;
import org.junit.Test;

public class SpanTest {
    @Test
    public void constructorTest() {
        Assert.assertEquals("span 1", new Span(1).getCssValue());
        Assert.assertEquals("span 1 test", new Span(new CustomIdent(1, "test")).getCssValue());
        Assert.assertEquals("span test", new Span(new CustomIdent("test")).getCssValue());
    }

    @Test(expected = NegativeOrZeroValueException.class)
    public void constructorZeroTest() {
        new Span(0).getCssValue();
    }

    @Test(expected = NegativeOrZeroValueException.class)
    public void constructorNegativeTest() {
        new Span(-1).getCssValue();
    }
}