package com.izamtest.decathlon.service;

import com.izamtest.decathlon.dao.Athlete;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class XMLWriter {
    public static String writeResultsToXML(final Map<Integer, List<Athlete>> resultsMap,
                                           final int athletesListSize) {

        StringBuffer buf = new StringBuffer();
        buf.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
        buf.append(String.format("<results athletes=\"%d\">\n", athletesListSize));

        final AtomicInteger index = new AtomicInteger(); // for counter inside lambda
        index.getAndIncrement(); // places rating should be ordered from 1

        resultsMap.forEach((points, athletesList) -> {
            final String place = athletesList.size() == 1 ?
                    String.format("%d", index.getAndIncrement()) :
                    String.format("%d-%d", index.getAndAdd(athletesList.size() - 1), index.getAndIncrement());

            buf.append(String.format("\t<place id=\"%s\">\n", place));

            for (Athlete athlete : athletesList) {
                buf.append("\t\t" + athlete.toXMLString() + "\n");
            }

            buf.append("\t</place>\n");
        });

        buf.append("</results>\n");
        return buf.toString();
    }


    public static void writeContentToFile(final String filename, final String content) {
        // If the file exists, overwrite
        try (FileWriter writer = new FileWriter(filename, false);
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(content);
        } catch (IOException e) {
            System.err.format("IOException failed during writing output file '%s': %s%n", filename, e);
        }
    }
}
