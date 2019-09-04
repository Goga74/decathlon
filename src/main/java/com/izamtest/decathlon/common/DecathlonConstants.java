package com.izamtest.decathlon.common;

public class DecathlonConstants {
    private double A,B,C;

    public DecathlonConstants(final Double a, final Double b, final Double c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }

    public Double[] getConstants() {
        Double[] result = {A,B,C};
        return result;
    }

    public Double getA() {
        return this.A;
    }

    public Double getB() {
        return this.B;
    }

    public Double getC() {
        return this.C;
    }
}
