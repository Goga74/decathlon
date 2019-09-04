package com.izamtest.decathlon.model;

import com.izamtest.decathlon.common.DecathlonConstants;

abstract class AbstractTrackResult extends AbstractDecathlonBaseResult {
    protected int calculate(final DecathlonConstants d) {
        super.setPoints((int) Math.floor(d.getA() * Math.pow((d.getB() - getValue()), d.getC())));
        return getPoints();
    }
}