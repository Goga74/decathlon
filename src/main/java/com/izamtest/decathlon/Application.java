package com.izamtest.decathlon;

import com.izamtest.decathlon.dao.Athlete;
import com.izamtest.decathlon.service.CSVParser;
import com.izamtest.decathlon.service.FilenameUtils;
import com.izamtest.decathlon.service.SAXXMLWriter;
import com.izamtest.decathlon.service.XMLWriter;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    static final String SCHEMA_FILE = "results.xsd";

    public static void main(final String args[]) {
        if (args.length < 1 || args.length > 2) {
            System.out.println("Parameter: <input filename> [xml write method=SAX|simple]");
            return;
        }
        String inputFilename = args[0];
        if (!"csv".equals(FilenameUtils.getFileType(inputFilename).toLowerCase())) {
            System.out.println("Unsupported file type, please use .csv format");
            return;
        }

        List<Athlete> list = CSVParser.parse(args[0]);

        try {
            // get list which is sorted by points descending,
            // and then group results byh points in map
            // to process situation with equals results and sharing medals
            assert list != null;
            Map<Integer, List<Athlete>> groupingByPoints = list.stream().
                    collect(Collectors.groupingBy(Athlete::getTotalPoints)).
                    entrySet().stream().
                    sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).
                    collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            String outFilename = FilenameUtils.getFileNameWithoutExtension(inputFilename) + ".xml";

            if (args.length > 1 && "SAX".equals(args[1])) {
                SAXXMLWriter.writeResultsToXML(groupingByPoints, list.size(), outFilename);
            } else {
                XMLWriter.writeContentToFile(outFilename, XMLWriter.writeResultsToXML(groupingByPoints, list.size()));
            }
        } catch (NullPointerException npe) {
            System.err.format("IOException failed during processing results %s%n", npe);
            npe.printStackTrace();
        }
    }
}