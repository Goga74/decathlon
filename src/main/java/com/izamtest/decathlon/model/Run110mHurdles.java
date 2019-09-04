package com.izamtest.decathlon.model;

import com.izamtest.decathlon.common.Constants;
import com.izamtest.decathlon.common.KindOfSports;

public class Run110mHurdles extends AbstractTrackResult {
    public Run110mHurdles(final String from) {
        super.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.Run110mHurdles.getIndex()]);
    }
}
