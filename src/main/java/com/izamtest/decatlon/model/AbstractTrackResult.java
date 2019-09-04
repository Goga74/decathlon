package com.izamtest.decatlon.model;

import com.izamtest.decatlon.common.DecathlonConstants;

abstract class AbstractTrackResult extends AbstractDecathlonBaseResult {
    protected int calculate(final DecathlonConstants d) {
        super.setPoints((int) Math.floor(d.getA() * Math.pow((d.getB() - getValue()), d.getC())));
        return getPoints();
    }
}