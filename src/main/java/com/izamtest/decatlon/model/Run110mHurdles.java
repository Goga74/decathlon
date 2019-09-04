package com.izamtest.decatlon.model;

import com.izamtest.decatlon.common.Constants;
import com.izamtest.decatlon.common.KindOfSports;

public class Run110mHurdles extends AbstractTrackResult {
    public Run110mHurdles(final String from) {
        super.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.Run110mHurdles.getIndex()]);
    }
}
