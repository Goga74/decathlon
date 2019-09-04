package com.izamtest.decathlon.model;

import com.izamtest.decathlon.common.Constants;
import com.izamtest.decathlon.common.KindOfSports;

public class ShotPut extends AbstractFieldResult {
    public ShotPut(final String from) {
        super.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.ShotPut.getIndex()]);
    }
}
