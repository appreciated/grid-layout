package com.github.appreciated.css.grid.interfaces;

import com.github.appreciated.css.inteface.CssUnit;
import org.junit.Assert;
import org.junit.Test;

public class CssUnitTest {
    /**
     * auto
     * custom-ident
     * span && [ <integer> || <custom-ident> ]
     */
    @Test
    public void testCssUnitTest() {
        TestCssUnit unit = new TestCssUnit("test");
        Assert.assertEquals("test", unit.getCssValue());
        TestCssUnitPrefix unitPrefix = new TestCssUnitPrefix("test");
        Assert.assertEquals("[test", unitPrefix.getCssValue());
        TestCssUnitSuffix unitSuffix = new TestCssUnitSuffix("test");
        Assert.assertEquals("test]", unitSuffix.getCssValue());
        TestCssUnitPrefixAndSuffix unitPrefixAndSuffix = new TestCssUnitPrefixAndSuffix("test");
        Assert.assertEquals("[test]", unitPrefixAndSuffix.getCssValue());
    }


    class TestCssUnit implements CssUnit {
        private String test;

        public TestCssUnit(String test) {
            this.test = test;
        }

        @Override
        public String getValue() {
            return test;
        }
    }

    class TestCssUnitSuffix implements CssUnit {
        private String test;

        public TestCssUnitSuffix(String test) {
            this.test = test;
        }

        @Override
        public String getValue() {
            return test;
        }

        @Override
        public boolean hasSuffix() {
            return true;
        }

        @Override
        public String getSuffixValue() {
            return "]";
        }
    }

    class TestCssUnitPrefix implements CssUnit {
        private String test;

        public TestCssUnitPrefix(String test) {
            this.test = test;
        }

        @Override
        public String getValue() {
            return test;
        }

        @Override
        public boolean hasPrefix() {
            return true;
        }

        @Override
        public String getPrefixValue() {
            return "[";
        }
    }

    class TestCssUnitPrefixAndSuffix implements CssUnit {
        private String test;

        public TestCssUnitPrefixAndSuffix(String test) {
            this.test = test;
        }

        @Override
        public String getValue() {
            return test;
        }

        @Override
        public boolean hasSuffix() {
            return true;
        }

        @Override
        public String getSuffixValue() {
            return "]";
        }

        @Override
        public boolean hasPrefix() {
            return true;
        }

        @Override
        public String getPrefixValue() {
            return "[";
        }
    }
}