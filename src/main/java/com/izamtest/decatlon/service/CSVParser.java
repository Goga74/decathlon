package com.izamtest.decatlon.service;

import com.izamtest.decatlon.common.Constants;
import com.izamtest.decatlon.dao.Athlete;
import com.izamtest.decatlon.model.*;

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
            List<Athlete> list = new ArrayList<Athlete>();
            String row;
            while ((row = csvReader.readLine()) != null) {
                try {
                    Athlete athlete = readRow(row);
                    if (athlete != null) {
                        list.add(athlete);
                    }
                } catch (NumberFormatException nex) {
                    System.out.println(String.format("Cannot parse results of '%s': %s", row, nex.getMessage()));
                }
            }
            System.out.println(String.format("Results loaded, total amount of athletes: %d", list.size()));
            return list;
        } catch (FileNotFoundException fex) {
            System.out.println(String.format("Input file '%s' not found, %s", pathToCsv, fex.getMessage()));
        } catch (IOException iex) {
            System.out.println(String.format("Error while parsing file '%s': %s", pathToCsv, iex.getMessage()));
        }
        return null;
    }

    private static Athlete readRow(final String row) throws NumberFormatException {
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
