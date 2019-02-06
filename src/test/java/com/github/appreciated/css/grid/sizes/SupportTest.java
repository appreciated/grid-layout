package com.github.appreciated.css.grid.sizes;

import com.github.appreciated.css.grid.interfaces.MinMaxUnit;
import com.github.appreciated.css.grid.interfaces.RowOrColUnit;
import com.github.appreciated.css.grid.interfaces.TemplateRowsAndColsUnit;
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
        Assert.assertFalse(new CustomIdent("test") instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new Int(1) instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new Length("1%") instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new Flex(1) instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new MaxContent() instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new MinContent() instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new MinMax(new Int(1), new Int(2)) instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new Repeat(1, new Int(1), new Int(2)) instanceof TemplateRowsAndColsUnit);
        Assert.assertTrue(new FitContent(new Int(1)) instanceof TemplateRowsAndColsUnit);
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
        Assert.assertFalse(new CustomIdent("test") instanceof MinMaxUnit);
        Assert.assertTrue(new Int(1) instanceof MinMaxUnit);
        Assert.assertTrue(new Length("1%") instanceof MinMaxUnit);
        Assert.assertTrue(new Flex(1) instanceof MinMaxUnit);
        Assert.assertTrue(new MaxContent() instanceof MinMaxUnit);
        Assert.assertTrue(new MinContent() instanceof MinMaxUnit);
        Assert.assertFalse(new MinMax(new Int(1), new Int(2)) instanceof MinMaxUnit);
        Assert.assertFalse(new Repeat(1, new Int(1), new Int(2)) instanceof MinMaxUnit);
        Assert.assertFalse(new FitContent(new Int(1)) instanceof MinMaxUnit);
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
        Assert.assertTrue(new CustomIdent("test") instanceof RowOrColUnit);
        Assert.assertTrue(new Int(1) instanceof RowOrColUnit);
        Assert.assertFalse(new Length("1%") instanceof RowOrColUnit);
        Assert.assertFalse(new Flex(1) instanceof RowOrColUnit);
        Assert.assertFalse(new MaxContent() instanceof RowOrColUnit);
        Assert.assertFalse(new MinContent() instanceof RowOrColUnit);
        Assert.assertFalse(new MinMax(new Int(1), new Int(2)) instanceof RowOrColUnit);
        Assert.assertFalse(new Repeat(1, new Int(1), new Int(2)) instanceof RowOrColUnit);
        Assert.assertFalse(new FitContent(new Int(1)) instanceof RowOrColUnit);
        Assert.assertTrue(new Span(1) instanceof RowOrColUnit);
    }
}
