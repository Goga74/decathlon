package com.izamtest.decatlon.model;

import com.izamtest.decatlon.common.DecathlonConstants;

abstract class AbstractFieldResult extends AbstractDecathlonBaseResult {
    protected int calculate(final DecathlonConstants d) {
        super.setPoints((int) Math.floor(d.getA() * Math.pow((getValue() - d.getB()), d.getC())));
        return getPoints();
    }
}
