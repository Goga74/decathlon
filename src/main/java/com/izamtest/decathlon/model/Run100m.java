package com.izamtest.decathlon.model;

import com.izamtest.decathlon.common.Constants;
import com.izamtest.decathlon.common.KindOfSports;

public class Run100m extends AbstractTrackResult {
    public Run100m(final String from) {
        super.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.Run100m.getIndex()]);
    }
}
