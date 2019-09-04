package com.izamtest.decatlon.model;

import com.izamtest.decatlon.common.Constants;
import com.izamtest.decatlon.common.KindOfSports;

public class ShotPut extends AbstractFieldResult {
    public ShotPut(final String from) {
        super.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.ShotPut.getIndex()]);
    }
}
