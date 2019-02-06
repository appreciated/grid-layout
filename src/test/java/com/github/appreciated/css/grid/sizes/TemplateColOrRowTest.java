package com.github.appreciated.css.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class TemplateColOrRowTest {
    @Test
    public void constructorTest() {
        Assert.assertEquals("[test]", new TemplateColOrRow("test").getCssValue());
        Assert.assertEquals("[test] 1.0fr", new TemplateColOrRow("test", new Flex(1)).getCssValue());
    }
}