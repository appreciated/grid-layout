package com.github.appreciated.css.grid.interfaces;

import com.github.appreciated.css.grid.sizes.*;
import org.junit.Assert;
import org.junit.Test;

public class AutoRowAndColUnitTest {
    /**
     * auto
     * custom-ident
     * span && [ <integer> || <custom-ident> ]
     */
    @Test
    public void testAutoRowOrColSupport() {
        Assert.assertTrue(new Auto() instanceof AutoRowAndColUnit);
        Assert.assertFalse(new CustomIdent("test") instanceof AutoRowAndColUnit);
        Assert.assertFalse(new Int(1) instanceof AutoRowAndColUnit);
        Assert.assertTrue(new Length("1%") instanceof AutoRowAndColUnit);
        Assert.assertTrue(new Flex(1) instanceof AutoRowAndColUnit);
        Assert.assertTrue(new MaxContent() instanceof AutoRowAndColUnit);
        Assert.assertTrue(new MinContent() instanceof AutoRowAndColUnit);
        Assert.assertTrue(new MinMax(new Length("10px"), new Length("100px")) instanceof AutoRowAndColUnit);
        Assert.assertFalse(new Repeat(1, new Length("10px"), new Length("100px")) instanceof AutoRowAndColUnit);
        Assert.assertTrue(new FitContent(new Length("10px")) instanceof AutoRowAndColUnit);
        Assert.assertFalse(new Span(1) instanceof AutoRowAndColUnit);
    }
}