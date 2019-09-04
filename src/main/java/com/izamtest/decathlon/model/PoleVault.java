package com.izamtest.decathlon.model;

import com.izamtest.decathlon.common.Constants;
import com.izamtest.decathlon.common.KindOfSports;

public class PoleVault extends AbstractFieldResult {
    public PoleVault(final String from) {
        this.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.PoleVault.getIndex()]);
    }

    protected void parse(final String from) throws NumberFormatException {
        setValue(Double.parseDouble(from) * 100.0); // from metres to centimetres
    }
}
