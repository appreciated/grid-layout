package com.github.appreciated.css.query.values;

import org.junit.Assert;
import org.junit.Test;

public class ScanTest {
    @Test
    public void testScan() {
        Assert.assertEquals("scan: interlace", new Scan(Scan.ScanType.INTERLACE).getCssValue());
        Assert.assertEquals("scan: progressive", new Scan(Scan.ScanType.PROGRESSIVE).getCssValue());
    }
}