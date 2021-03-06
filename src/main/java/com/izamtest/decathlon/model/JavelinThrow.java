package com.izamtest.decathlon.model;

import com.izamtest.decathlon.common.Constants;
import com.izamtest.decathlon.common.KindOfSports;

public class JavelinThrow extends AbstractFieldResult {
    public JavelinThrow(final String from) {
        super.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.JavelinThrow.getIndex()]);
    }
}
