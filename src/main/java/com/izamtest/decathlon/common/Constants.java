package com.izamtest.decathlon.common;

public class Constants {
    public static final int DECATH = 10;
    public static final String DECIMAL_DELIMITER = ".";

    public static final DecathlonConstants[] decathlonConstants = {
            new DecathlonConstants(25.4347, 18.0, 1.81), // 100m
            new DecathlonConstants(0.14354, 220.0, 1.4), // Long Jump
            new DecathlonConstants(51.39, 1.5, 1.05), // Shot put
            new DecathlonConstants(0.8465, 75.0, 1.4215), // High Jump
            new DecathlonConstants(1.53775, 82.0, 1.81), // 400m
            new DecathlonConstants(5.74352, 28.5, 1.92), // 110m hudles
            new DecathlonConstants(12.91, 4.0, 1.1), // Discus throw
            new DecathlonConstants(0.2799, 100.0, 1.35), // Pole vault
            new DecathlonConstants(10.14, 7.0, 1.08), // Javelin throw
            new DecathlonConstants(0.03768, 480.0, 1.85) // 1500m
    };

}
