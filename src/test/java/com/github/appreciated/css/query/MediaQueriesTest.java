package com.github.appreciated.css.query;

import org.junit.Assert;
import org.junit.Test;

import static com.github.appreciated.css.query.values.WidthAttributes.MaxWidth;
import static com.github.appreciated.css.query.values.WidthAttributes.MinWidth;

public class MediaQueriesTest {
    @Test
    public void testMediaQueries() {
        Assert.assertEquals("(min-width: 30em) and (max-width: 60em)", new MediaQuery(new MinWidth("30em"), new MaxWidth("60em")).getCssValue());
    }
}