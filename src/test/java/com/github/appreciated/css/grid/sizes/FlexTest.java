package com.github.appreciated.css.grid.sizes;

import com.github.appreciated.css.grid.exception.NegativeValueException;
import org.junit.Assert;
import org.junit.Test;

public class FlexTest {
    @Test
    public void constructorTest() {
        // minmax(100px, max-content)
        Assert.assertEquals("1.0fr", new Flex(1).getCssValue());
        Assert.assertEquals("2.0fr", new Flex(2).getCssValue());
        Assert.assertEquals("3.0fr", new Flex(3).getCssValue());
        Assert.assertEquals("4.0fr", new Flex(4).getCssValue());
    }

    @Test(expected = NegativeValueException.class)
    public void testNegativeValueException() {
        new Flex(-1);
    }

}