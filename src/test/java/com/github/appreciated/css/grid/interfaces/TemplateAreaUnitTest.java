package com.github.appreciated.css.grid.interfaces;

import com.github.appreciated.css.grid.sizes.*;
import org.junit.Assert;
import org.junit.Test;

public class TemplateAreaUnitTest {
    @Test
    public void testGridTemplateRowAndColSupport() {
        Assert.assertTrue(new Auto() instanceof TemplateAreaUnit);
        Assert.assertFalse(new CustomIdent("test") instanceof TemplateAreaUnit);
        Assert.assertFalse(new Int(1) instanceof TemplateAreaUnit);
        Assert.assertFalse(new Length("1%") instanceof TemplateAreaUnit);
        Assert.assertFalse(new Flex(1) instanceof TemplateAreaUnit);
        Assert.assertFalse(new MaxContent() instanceof TemplateAreaUnit);
        Assert.assertFalse(new MinContent() instanceof TemplateAreaUnit);
        Assert.assertFalse(new MinMax(new Length("10px"), new Length("100px")) instanceof TemplateAreaUnit);
        Assert.assertFalse(new Repeat(1, new Length("10px"), new Length("100px")) instanceof TemplateAreaUnit);
        Assert.assertFalse(new FitContent(new Length("10px")) instanceof TemplateAreaUnit);
        Assert.assertTrue(new Span(1) instanceof TemplateAreaUnit);
        Assert.assertTrue(new TemplateArea("test") instanceof TemplateAreaUnit);
    }
}