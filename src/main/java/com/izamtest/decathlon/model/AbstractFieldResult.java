package com.izamtest.decathlon.model;

import com.izamtest.decathlon.common.DecathlonConstants;

abstract class AbstractFieldResult extends AbstractDecathlonBaseResult {
    protected int calculate(final DecathlonConstants d) {
        super.setPoints((int) Math.floor(d.getA() * Math.pow((getValue() - d.getB()), d.getC())));
        return getPoints();
    }
}
