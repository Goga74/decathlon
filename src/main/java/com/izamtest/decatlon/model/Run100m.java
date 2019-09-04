package com.izamtest.decatlon.model;

import com.izamtest.decatlon.common.Constants;
import com.izamtest.decatlon.common.KindOfSports;

public class Run100m extends AbstractTrackResult {
    public Run100m(final String from) {
        super.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.Run100m.getIndex()]);
    }
}
