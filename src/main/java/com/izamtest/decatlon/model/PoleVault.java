package com.izamtest.decatlon.model;

import com.izamtest.decatlon.common.Constants;
import com.izamtest.decatlon.common.KindOfSports;

public class PoleVault extends AbstractFieldResult {
    public PoleVault(final String from) {
        this.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.PoleVault.getIndex()]);
    }

    protected void parse(final String from) throws NumberFormatException {
        setValue(Double.parseDouble(from) * 100.0); // from metres to centimetres
    }
}
