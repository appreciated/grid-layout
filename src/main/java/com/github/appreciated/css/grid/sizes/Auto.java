package com.github.appreciated.css.grid.sizes;

import com.github.appreciated.css.grid.interfaces.*;
import com.github.appreciated.css.interfaces.*;
import com.github.appreciated.grid.interfaces.*;

public class Auto implements AutoRowAndColUnit, RowOrColUnit, TemplateRowsAndColsUnit, MinMaxUnit, AreaUnit {
    @Override
    public String getValue() {
        return "auto";
    }

    @Override
    public boolean hasSuffix() {
        return false;
    }

    @Override
    public String getSuffixValue() {
        return null;
    }
}
