package com.izamtest.decatlon.model;

import com.izamtest.decatlon.common.Constants;
import com.izamtest.decatlon.common.KindOfSports;

public class DiscusThrow extends AbstractFieldResult {
    public DiscusThrow(final String from) {
        super.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.DiscusThrow.getIndex()]);
    }
}
