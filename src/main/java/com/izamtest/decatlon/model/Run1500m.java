package com.izamtest.decatlon.model;

import com.izamtest.decatlon.common.Constants;
import com.izamtest.decatlon.common.KindOfSports;

public class Run1500m extends AbstractTrackResult {
    public Run1500m(final String from) {
        this.parse(from);
        super.calculate(Constants.decathlonConstants[KindOfSports.Run1500m.getIndex()]);
    }

    protected void parse(final String from) throws NumberFormatException {
        if (null == from || from.isEmpty()) {
            super.setValue(0.0);
            return;
        }
        String[] data = from.trim().split("\\" + Constants.DECIMAL_DELIMITER, 2);
        if (data.length == 2) {
            // minutes, seconds and parts of seconds
            super.setValue(Double.parseDouble(data[0]) * 60 + Double.parseDouble(data[1]));
        } else {
            throw new NumberFormatException(String.format("Wrong input data for %s",
                    this.getClass().getName()));
        }
    }
}
