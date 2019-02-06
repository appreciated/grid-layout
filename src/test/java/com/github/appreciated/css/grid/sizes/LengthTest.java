package com.github.appreciated.css.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class LengthTest {
    @Test
    public void constructorTest() {
        Assert.assertEquals("10px", new Length("10px").getCssValue());
        Assert.assertEquals("10%", new Length("10%").getCssValue());
        Assert.assertEquals("10vh", new Length("10vh").getCssValue());
        Assert.assertEquals("10vw", new Length("10vw").getCssValue());
    }
}