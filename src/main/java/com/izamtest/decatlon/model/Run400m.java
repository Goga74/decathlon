package com.izamtest.decatlon.model;

import com.izamtest.decatlon.common.Constants;
import com.izamtest.decatlon.common.KindOfSports;

public class Run400m extends AbstractTrackResult {
    public Run400m(final String from) {
        super.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.Run400m.getIndex()]);
    }
}
