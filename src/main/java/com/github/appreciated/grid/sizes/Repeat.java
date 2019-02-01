package com.github.appreciated.grid.sizes;

import java.util.Arrays;

public class Repeat implements CssGridFunction {

    public static final String FUNCTION_NAME = "repeat";

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
        return FUNCTION_NAME + "(" + (times == null ? mode.getRepeatModeValue() : times.toString()) + ", ";
    }

    public enum RepeatMode {
        AUTO_FILL("auto-fill"),
        AUTO_FIT("auto-fit");

        private final String repeatValue;

        RepeatMode(String repeatValue) {
            this.repeatValue = repeatValue;
        }

        static RepeatMode toRepeatMode(String repeatValue, RepeatMode defaultValue) {
            return Arrays.stream(values())
                    .filter((repeatMode) -> repeatMode.getRepeatModeValue().equals(repeatValue))
                    .findFirst()
                    .orElse(defaultValue);
        }

        String getRepeatModeValue() {
            return this.repeatValue;
        }
    }
}
