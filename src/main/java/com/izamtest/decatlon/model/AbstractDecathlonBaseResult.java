package com.izamtest.decatlon.model;

import com.izamtest.decatlon.common.DecathlonConstants;

public abstract class AbstractDecathlonBaseResult {
    private int points;
    private double value;

    public final int getPoints() {
        return points;
    }

    void setPoints(final int newPointsValue) {
        this.points = newPointsValue;
    }

    Double getValue() {
        return this.value;
    }

    void setValue(final double newValue) {
        this.value = newValue;
    }

    protected void parse(final String from) throws NumberFormatException {
        setValue(Double.parseDouble(from));
    }

    protected abstract int calculate(final DecathlonConstants constants);
}
