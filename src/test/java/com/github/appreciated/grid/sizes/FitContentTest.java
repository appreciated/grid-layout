package com.github.appreciated.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class FitContentTest {
    @Test
    public void constructorTest() {
        Assert.assertEquals("fit-content(400px)", new FitContent(new Size("400px")).getCssValue());
        Assert.assertEquals("fit-content(5cm)", new FitContent(new Size("5cm")).getCssValue());
        Assert.assertEquals("fit-content(20%)", new FitContent(new Size("20%")).getCssValue());
    }

}