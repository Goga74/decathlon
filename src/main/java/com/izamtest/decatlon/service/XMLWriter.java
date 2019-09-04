package com.izamtest.decatlon.service;

import com.izamtest.decatlon.dao.Athlete;
import com.izamtest.decatlon.dao.Place;
import com.izamtest.decatlon.dao.Results;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class XMLWriter {
    public static void writeResultsToXMLFile(final Map<Integer, List<Athlete>> resultsMap,
                                             final int athletesListSize,
                                             final String filename) {

        List<Place> places = new ArrayList<Place>(resultsMap.size());

        final AtomicInteger index = new AtomicInteger(); // for counter inside lambda
        index.getAndIncrement(); // places rating should be ordered from 1

        resultsMap.forEach((k, v) -> {
            final String place = v.size() == 1 ?
                    String.format("%d", index.getAndIncrement()) :
                    String.format("%d-%d", index.getAndAdd(v.size() - 1), index.getAndIncrement());
            places.add(new Place(v, place));
        });

        Results results = new Results(places, athletesListSize);

        try {
            JAXBContext context = JAXBContext.newInstance(Results.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(results, System.out);

            m.marshal(results, new File(filename));
        } catch (JAXBException jex) {
            System.out.println(String.format("Error while writing XML output file '%s', %s", filename, jex.getMessage()));
        }
    }
}
