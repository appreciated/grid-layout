package com.github.appreciated.css.query;

import com.github.appreciated.css.inteface.CssUnit;

import java.util.Arrays;

public class MediaQuery implements CssUnit {

    private MediaQueryUnit[] queries;

    public MediaQuery(MediaQueryUnit... queries) {
        this.queries = queries;
    }

    @Override
    public String getValue() {
        return Arrays.stream(queries)
                .map(CssUnit::getCssValue)
                .map(s -> "(" + s + ")")
                .reduce((unit, unit2) -> unit + " and " + unit2)
                .orElse("");
    }
}
