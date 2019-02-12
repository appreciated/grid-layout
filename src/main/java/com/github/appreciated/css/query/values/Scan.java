package com.github.appreciated.css.query.values;

import com.github.appreciated.css.query.MediaQueryUnit;

public class Scan implements MediaQueryUnit {

    private ScanType scanType;

    public Scan(ScanType scanType) {
        this.scanType = scanType;
    }

    @Override
    public String getValue() {
        return scanType.getCssValue();
    }

    @Override
    public boolean hasPrefix() {
        return true;
    }

    @Override
    public String getPrefixValue() {
        return "scan: ";
    }

    enum ScanType {
        PROGRESSIVE("progressive"), INTERLACE("interlace");

        private String cssValue;

        ScanType(String cssValue) {
            this.cssValue = cssValue;
        }

        public String getCssValue() {
            return cssValue;
        }
    }
}

