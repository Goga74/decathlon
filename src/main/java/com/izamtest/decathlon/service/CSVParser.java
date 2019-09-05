package com.izamtest.decathlon.service;

import com.izamtest.decathlon.common.Constants;
import com.izamtest.decathlon.dao.Athlete;
import com.izamtest.decathlon.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    private static final String SPLITTER = ";";

    public static List<Athlete> parse(final String pathToCsv) {
        try (BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv))) {
            List<Athlete> list = new ArrayList<>();
            String row;
            while ((row = csvReader.readLine()) != null) {
                try {
                    Athlete athlete = readRow(row);
                    if (athlete != null) {
                        list.add(athlete);
                    }
                } catch (NumberFormatException nex) {
                    System.err.format("Cannot parse results of '%s': %s", row, nex.getMessage());
                }
            }
            return list;
        } catch (FileNotFoundException ex) {
            System.err.format("Input file '%s' not found, %s", pathToCsv, ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.format("Error while reading file '%s': %s", pathToCsv, ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public static Athlete readRow(final String row) throws NumberFormatException {
        String[] data = row.split(SPLITTER);
        final ArrayList<AbstractDecathlonBaseResult> results = new ArrayList<>(Constants.DECATH);

        if (data.length == Constants.DECATH + 1) {
            results.add(new Run100m(data[1]));
            results.add(new LongJump(data[2]));
            results.add(new ShotPut(data[3]));
            results.add(new HighJump(data[4]));
            results.add(new Run400m(data[5]));
            results.add(new Run110mHurdles(data[6]));
            results.add(new DiscusThrow(data[7]));
            results.add(new PoleVault(data[8]));
            results.add(new JavelinThrow(data[9]));
            results.add(new Run1500m(data[10]));

            return new Athlete(data[0], results);
        }
        return null;
    }

}
