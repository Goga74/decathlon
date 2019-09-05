package com.izamtest.decathlon.service;

import com.izamtest.decathlon.dao.Athlete;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class XMLWriter {
    private static final String START_INDENT = "\t";
    private static final String END_LINE = "\n";

    public static String writeResultsToXML(final Map<Integer, List<Athlete>> resultsMap,
                                           final int athletesListSize) {

        StringBuffer buf = new StringBuffer();
        buf.append("<?xml version=\"1.0\" encoding=\"" + StandardCharsets.UTF_8 + "\" standalone=\"yes\"?>");
        buf.append(END_LINE);
        buf.append("<root>");
        buf.append(END_LINE);
        buf.append(String.format("<results athletes=\"%d\">%s", athletesListSize, END_LINE));

        final AtomicInteger index = new AtomicInteger(); // for counter inside lambda
        index.getAndIncrement(); // places rating should be ordered from 1

        resultsMap.forEach((points, athletesList) -> {
            final String place = athletesList.size() == 1 ?
                    String.format("%d", index.getAndIncrement()) :
                    String.format("%d-%d", index.getAndAdd(athletesList.size() - 1), index.getAndIncrement());

            buf.append(String.format("%s<place id=\"%s\">%s", START_INDENT, place, END_LINE));

            for (Athlete athlete: athletesList) {
                buf.append(String.format("%s%s%s%s", START_INDENT, START_INDENT, athlete.toXMLString(), END_LINE));
            }

            buf.append(START_INDENT);
            buf.append("</place>");
            buf.append(END_LINE);
        });

        buf.append("</results>");
        buf.append(END_LINE);
        buf.append("</root>");
        buf.append(END_LINE);
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
