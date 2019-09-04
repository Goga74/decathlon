package com.izamtest.decatlon.common;

public enum KindOfSports {
    Run100m(0) ,
    LongJump(1),
    ShotPut(2),
    HighJump(3),
    Run400m(4),
    Run110mHurdles(5),
    DiscusThrow(6),
    PoleVault(7),
    JavelinThrow(8),
    Run1500m(9);

    private Integer index;

    KindOfSports(final int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }
}
