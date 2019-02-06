package com.github.appreciated.css.grid.interfaces;

import com.github.appreciated.css.grid.sizes.*;
import org.junit.Assert;
import org.junit.Test;

public class MinMaxUnitTest {
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
        Assert.assertFalse(new Int(1) instanceof MinMaxUnit);
        Assert.assertTrue(new Length("1%") instanceof MinMaxUnit);
        Assert.assertTrue(new Flex(1) instanceof MinMaxUnit);
        Assert.assertTrue(new MaxContent() instanceof MinMaxUnit);
        Assert.assertTrue(new MinContent() instanceof MinMaxUnit);
        Assert.assertFalse(new MinMax(new Length("10px"), new Length("100px")) instanceof MinMaxUnit);
        Assert.assertFalse(new Repeat(1, new Length("10px"), new Length("100px")) instanceof MinMaxUnit);
        Assert.assertFalse(new FitContent(new Length("10px")) instanceof MinMaxUnit);
        Assert.assertFalse(new Span(1) instanceof MinMaxUnit);
    }

}