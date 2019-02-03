package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.MinMaxUnit;
import com.github.appreciated.grid.interfaces.RowOrColUnit;
import com.github.appreciated.grid.interfaces.TemplateRowsAndColsUnit;
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
    public void testGridTemplateRowAndColSupport() {
        Assert.assertTrue(new Auto() instanceof TemplateRowsAndColsUnit);
        Assert.assertFalse(new Area("test") instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new Length(1) instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new Length("1%") instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new Flex(1) instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new MaxContent() instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new MinContent() instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new MinMax(new Length(1), new Length(2)) instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new Repeat(1, new Length(1), new Length(2)) instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new FitContent(new Length(1)) instanceof TemplateRowsAndColsUnit);
        Assert.assertFalse(new Span(1) instanceof TemplateRowsAndColsUnit);
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
        Assert.assertTrue(new Auto() instanceof MinMaxUnit);
        Assert.assertFalse(new Area("test") instanceof MinMaxUnit);
        Assert.assertTrue(new Length(1) instanceof MinMaxUnit);
        Assert.assertTrue(new Length("1%") instanceof MinMaxUnit);
        Assert.assertTrue(new Flex(1) instanceof MinMaxUnit);
        Assert.assertTrue(new MaxContent() instanceof MinMaxUnit);
        Assert.assertTrue(new MinContent() instanceof MinMaxUnit);
        Assert.assertFalse(new MinMax(new Length(1), new Length(2)) instanceof MinMaxUnit);
        Assert.assertFalse(new Repeat(1, new Length(1), new Length(2)) instanceof MinMaxUnit);
        Assert.assertFalse(new FitContent(new Length(1)) instanceof MinMaxUnit);
        Assert.assertFalse(new Span(1) instanceof MinMaxUnit);
    }


    /**
     * auto
     * custom-ident
     * span && [ <integer> || <custom-ident> ]
     */
    @Test
    public void testRowOrColSupport() {
        Assert.assertTrue(new Auto() instanceof RowOrColUnit);
        Assert.assertTrue(new Area("test") instanceof RowOrColUnit);
        Assert.assertFalse(new Length(1) instanceof RowOrColUnit);
        Assert.assertFalse(new Length("1%") instanceof RowOrColUnit);
        Assert.assertFalse(new Flex(1) instanceof RowOrColUnit);
        Assert.assertFalse(new MaxContent() instanceof RowOrColUnit);
        Assert.assertFalse(new MinContent() instanceof RowOrColUnit);
        Assert.assertFalse(new MinMax(new Length(1), new Length(2)) instanceof RowOrColUnit);
        Assert.assertFalse(new Repeat(1, new Length(1), new Length(2)) instanceof RowOrColUnit);
        Assert.assertFalse(new FitContent(new Length(1)) instanceof RowOrColUnit);
        Assert.assertTrue(new Span(1) instanceof RowOrColUnit);
    }
}
