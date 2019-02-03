package com.github.appreciated.css.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class FitContentTest {
    @Test
    public void constructorTest() {
        Assert.assertEquals("fit-content(400px)", new FitContent(new Length("400px")).getCssValue());
        Assert.assertEquals("fit-content(5cm)", new FitContent(new Length("5cm")).getCssValue());
        Assert.assertEquals("fit-content(20%)", new FitContent(new Length("20%")).getCssValue());
    }

}