package com.github.appreciated.css.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class CustomIdentTest {

    @Test
    public void constructorTest() {
        Assert.assertEquals("1 test", new CustomIdent(1, "test").getCssValue());
        Assert.assertEquals("1 test-end", new CustomIdent(1, "test-end").getCssValue());
        Assert.assertEquals("1 test-start", new CustomIdent(1, "test-start").getCssValue());
        Assert.assertEquals("test", new CustomIdent("test").getCssValue());
        Assert.assertEquals("test-end", new CustomIdent("test-end").getCssValue());
        Assert.assertEquals("test-start", new CustomIdent("test-start").getCssValue());
    }

}