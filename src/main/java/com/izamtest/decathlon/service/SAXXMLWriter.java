package com.izamtest.decathlon.service;

import com.izamtest.decathlon.dao.Athlete;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SAXXMLWriter {
    public static void writeResultsToXML(final Map<Integer, List<Athlete>> resultsMap,
                                         final int athletesListSize,
                                         final String filename) {

        try (OutputStream outputStream = new FileOutputStream(new File(filename))) {
            XMLStreamWriter out = XMLOutputFactory.newInstance().createXMLStreamWriter(
                    new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

            out.writeStartDocument();
            out.writeStartElement("root");
            out.writeStartElement("results");
            out.writeAttribute("athletes", String.format("%d", athletesListSize));

            final AtomicInteger index = new AtomicInteger(); // for counter inside lambda
            index.getAndIncrement(); // places rating should be ordered from 1

            resultsMap.forEach((points, athletesList) -> {
                final String place = athletesList.size() == 1 ?
                        String.format("%d", index.getAndIncrement()) :
                        String.format("%d-%d", index.getAndAdd(athletesList.size() - 1),
                                index.getAndIncrement());

                try {
                    out.writeStartElement("place");
                    out.writeAttribute("id", place);

                    for (Athlete athlete : athletesList) {
                        out.writeStartElement("athlete");
                        out.writeAttribute("name", athlete.getName());
                        out.writeAttribute("points", String.format("%d", athlete.getTotalPoints()));
                        out.writeEndElement();
                    }

                    out.writeEndElement();
                } catch (XMLStreamException xex) {
                    System.err.format("Error while writing athlete (place id:%d) %s",
                            index.get(), xex.getMessage());
                }
            });

            out.writeEndElement();
            out.writeEndElement();
            out.writeEndDocument();

            out.close();
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

}
