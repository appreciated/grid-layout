package com.github.appreciated.css.grid.interfaces;

import com.github.appreciated.css.grid.sizes.*;
import org.junit.Assert;
import org.junit.Test;

public class RowOrColUnitTest {
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
        Assert.assertFalse(new MinMax(new Length("10px"), new Length("100px")) instanceof RowOrColUnit);
        Assert.assertFalse(new Repeat(1, new Length("10px"), new Length("100px")) instanceof RowOrColUnit);
        Assert.assertFalse(new FitContent(new Length("10px")) instanceof RowOrColUnit);
        Assert.assertTrue(new Span(1) instanceof RowOrColUnit);
    }

}