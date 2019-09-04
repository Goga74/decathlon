package com.izamtest.decathlon.model;

import com.izamtest.decathlon.common.Constants;
import com.izamtest.decathlon.common.KindOfSports;

public class Run400m extends AbstractTrackResult {
    public Run400m(final String from) {
        super.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.Run400m.getIndex()]);
    }
}
