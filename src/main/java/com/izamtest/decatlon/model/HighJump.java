package com.izamtest.decatlon.model;

import com.izamtest.decatlon.common.Constants;
import com.izamtest.decatlon.common.KindOfSports;

public class HighJump extends AbstractFieldResult {
    public HighJump(final String from) {
        this.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.HighJump.getIndex()]);
    }

    protected void parse(final String from) throws NumberFormatException {
        setValue(Double.parseDouble(from) * 100.0); // from metres to centimetres
    }
}
