package com.izamtest.decatlon.model;

import com.izamtest.decatlon.common.Constants;
import com.izamtest.decatlon.common.KindOfSports;

public class JavelinThrow extends AbstractFieldResult {
    public JavelinThrow(final String from) {
        super.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.JavelinThrow.getIndex()]);
    }
}
