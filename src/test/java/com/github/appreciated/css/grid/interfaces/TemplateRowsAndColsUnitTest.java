package com.github.appreciated.css.grid.interfaces;

import com.github.appreciated.css.grid.sizes.*;
import org.junit.Assert;
import org.junit.Test;

public class TemplateRowsAndColsUnitTest {

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
    public void testGridTemplateRowAndColSupport() {
        Assert.assertTrue(new Auto() instanceof TemplateRowsAndColsUnit);
        Assert.assertFalse(new CustomIdent("test") instanceof TemplateRowsAndColsUnit);
        Assert.assertFalse(new Int(1) instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new Length("1%") instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new Flex(1) instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new MaxContent() instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new MinContent() instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new MinMax(new Length("10px"), new Length("100px")) instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new Repeat(1, new Length("10px"), new Length("100px")) instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new FitContent(new Length("10px")) instanceof TemplateRowsAndColsUnit);
        Assert.assertFalse(new Span(1) instanceof TemplateRowsAndColsUnit);
    }

}