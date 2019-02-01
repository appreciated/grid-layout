package com.github.appreciated.grid.grid.sizes;

import java.util.Arrays;

public class Size implements CssGridSize {

    private int size;
    private CssUnit unit;

    public Size(int size, CssUnit unit) {
        this.size = size;
        this.unit = unit;
    }

    @Override
    public String getValue() {
        return String.valueOf(size);
    }

    @Override
    public boolean hasSuffix() {
        return true;
    }

    @Override
    public String getSuffixValue() {
        return unit.getUnitValue();
    }


    public enum CssUnit {
        EM("em"),
        PERCENT("em"),
        PIXEL("px"),
        PX("px"),
        VMIN("vmin"),
        VMAX("vmin"),
        VH("vh"),
        VW("vw");

        private final String unitValue;

        CssUnit(String unitValue) {
            this.unitValue = unitValue;
        }

        static CssUnit toCssUnit(String unitValue, CssUnit defaultValue) {
            return Arrays.stream(values())
                    .filter((unit) -> unit.getUnitValue().equals(unitValue))
                    .findFirst()
                    .orElse(defaultValue);
        }

        String getUnitValue() {
            return this.unitValue;
        }
    }
}
