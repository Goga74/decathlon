package com.izamtest.decathlon.model;

import com.izamtest.decathlon.common.Constants;
import com.izamtest.decathlon.common.KindOfSports;

public class DiscusThrow extends AbstractFieldResult {
    public DiscusThrow(final String from) {
        super.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.DiscusThrow.getIndex()]);
    }
}
