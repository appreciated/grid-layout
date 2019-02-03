package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.CssGridMinMaxUnit;
import com.github.appreciated.grid.interfaces.CssGridTemplateUnit;
import org.junit.Assert;
import org.junit.Test;

public class SupportTest {

    /**
     * none
     * length
     * percentage
     * flex
     * max - content
     * min - content
     * auto
     * minmax(min, max)
     * repeat()
     * fit - content
     */
    @Test
    public void testGridTemplateSupport() {
        Assert.assertTrue(new Auto() instanceof CssGridTemplateUnit);
        Assert.assertTrue(new Length(1) instanceof CssGridTemplateUnit);
        Assert.assertTrue(new Length("1%") instanceof CssGridTemplateUnit);
        Assert.assertTrue(new Flex(1) instanceof CssGridTemplateUnit);
        Assert.assertTrue(new MaxContent() instanceof CssGridTemplateUnit);
        Assert.assertTrue(new MinContent() instanceof CssGridTemplateUnit);
        Assert.assertTrue(new MinMax(new Length(1), new Length(2)) instanceof CssGridTemplateUnit);
        Assert.assertTrue(new Repeat(1, new Length(1), new Length(2)) instanceof CssGridTemplateUnit);
        Assert.assertTrue(new FitContent(new Length(1)) instanceof CssGridTemplateUnit);
        Assert.assertFalse(new Span(new Length(1)) instanceof CssGridTemplateUnit);
    }


    /**
     * length
     * percentage
     * flex
     * max-content
     * min-content
     * auto
     */
    @Test
    public void testMinMaxSupport() {
        Assert.assertTrue(new Auto() instanceof CssGridMinMaxUnit);
        Assert.assertTrue(new Length(1) instanceof CssGridMinMaxUnit);
        Assert.assertTrue(new Length("1%") instanceof CssGridMinMaxUnit);
        Assert.assertTrue(new Flex(1) instanceof CssGridMinMaxUnit);
        Assert.assertTrue(new MaxContent() instanceof CssGridMinMaxUnit);
        Assert.assertTrue(new MinContent() instanceof CssGridMinMaxUnit);
        Assert.assertFalse(new MinMax(new Length(1), new Length(2)) instanceof CssGridMinMaxUnit);
        Assert.assertFalse(new Repeat(1, new Length(1), new Length(2)) instanceof CssGridMinMaxUnit);
        Assert.assertFalse(new FitContent(new Length(1)) instanceof CssGridMinMaxUnit);
        Assert.assertFalse(new Span(new Length(1)) instanceof CssGridMinMaxUnit);
    }
}
