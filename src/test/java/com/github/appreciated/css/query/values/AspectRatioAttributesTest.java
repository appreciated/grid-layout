package com.github.appreciated.css.query.values;

import org.junit.Assert;
import org.junit.Test;

public class AspectRatioAttributesTest {
    @Test
    public void testAspectRatio() {
        Assert.assertEquals("aspect-ratio: 16/9", new AspectRatioAttributes.AspectRatio(16, 9).getCssValue());
    }

    @Test
    public void testMinAspectRatio() {
        Assert.assertEquals("min-aspect-ratio: 16/9", new AspectRatioAttributes.MinAspectRatio(16, 9).getCssValue());
    }

    @Test
    public void testMaxAspectRatio() {
        Assert.assertEquals("max-aspect-ratio: 16/9", new AspectRatioAttributes.MaxAspectRatio(16, 9).getCssValue());
    }
}