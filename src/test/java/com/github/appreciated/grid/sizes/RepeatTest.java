package com.github.appreciated.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class RepeatTest {
    @Test
    public void constructorTest() {
        Assert.assertEquals("repeat(4, 100px min-content 100px max-content 100px)",
                new Repeat(4, new Size("100px"), new MinContent(), new Size("100px"), new MaxContent(), new Size("100px"))
                        .getCssValue()
        );
        Assert.assertEquals("repeat(auto-fill, 250px)",
                new Repeat(Repeat.RepeatMode.AUTO_FILL, new Size("250px"))
                        .getCssValue()
        );
        Assert.assertEquals("repeat(auto-fit, 250px)",
                new Repeat(Repeat.RepeatMode.AUTO_FIT, new Size("250px"))
                        .getCssValue()
        );

        //repeat(auto-fill, [col-start] 250px [col-end])
        //repeat(auto-fit, [col-start] 250px [col-end])
    }
}