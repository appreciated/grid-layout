package com.github.appreciated.grid.sizes.sizes;

import java.util.Arrays;

public class Repeat implements CssGridFunction {

    private Integer times;
    private RepeatMode mode;
    private CssGridUnit[] sizes;

    public Repeat(int times, CssGridUnit... sizes) {
        this(sizes);
        this.times = times;
    }


    private Repeat(CssGridUnit... sizes) {
        this.sizes = sizes;
    }

    public Repeat(RepeatMode mode, CssGridUnit... sizes) {
        this(sizes);
        this.mode = mode;
    }

    @Override
    public String getValue() {
        return Arrays.stream(sizes).map(CssGridUnit::getCssValue).reduce((unit, unit2) -> unit + " " + unit2).orElse("");
    }

    @Override
    public boolean hasSuffix() {
        return true;
    }

    @Override
    public String getSuffixValue() {
        return ")";
    }

    @Override
    public boolean hasPrefix() {
        return true;
    }

    @Override
    public String getPrefixValue() {
        return RepeatMode.functionName + "(" + (times == null ? mode.getRepeatModeValue() : times.toString()) + ", ";
    }

    public enum RepeatMode {
        AUTO_FILL("auto-fill"),
        AUTO_FIT("auto-fit");

        public static final String functionName = "repeat";
        private final String alignValue;

        RepeatMode(String alignValue) {
            this.alignValue = alignValue;
        }

        static RepeatMode toColumnAlign(String alignValue, RepeatMode defaultValue) {
            return Arrays.stream(values())
                    .filter((repeatMode) -> repeatMode.getRepeatModeValue().equals(alignValue))
                    .findFirst()
                    .orElse(defaultValue);
        }

        String getRepeatModeValue() {
            return this.alignValue;
        }
    }
}
