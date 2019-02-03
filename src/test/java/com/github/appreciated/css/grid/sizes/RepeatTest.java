package com.github.appreciated.css.grid.sizes;

import org.junit.Assert;
import org.junit.Test;

public class RepeatTest {
    @Test
    public void constructorTest() {
        Assert.assertEquals("repeat(4, 100px min-content 100px max-content 100px)",
                new Repeat(4, new Length("100px"), new MinContent(), new Length("100px"), new MaxContent(), new Length("100px"))
                        .getCssValue()
        );
        Assert.assertEquals("repeat(auto-fill, 250px)",
                new Repeat(Repeat.RepeatMode.AUTO_FILL, new Length("250px"))
                        .getCssValue()
        );
        Assert.assertEquals("repeat(auto-fit, 250px)",
                new Repeat(Repeat.RepeatMode.AUTO_FIT, new Length("250px"))
                        .getCssValue()
        );

        //repeat(auto-fill, [col-start] 250px [col-end])
        //repeat(auto-fit, [col-start] 250px [col-end])
    }
}