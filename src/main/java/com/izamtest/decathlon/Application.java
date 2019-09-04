package com.izamtest.decathlon;

import com.izamtest.decathlon.dao.Athlete;
import com.izamtest.decathlon.service.CSVParser;
import com.izamtest.decathlon.service.FilenameUtils;
import com.izamtest.decathlon.service.XMLWriter;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(final String args[]) {
        if (args.length < 1) {
            System.out.println("Parameter: <input filename>");
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

            String content = XMLWriter.writeResultsToXML(groupingByPoints, list.size());
            System.out.println(content);
            XMLWriter.writeContentToFile(FilenameUtils.getFileNameWithoutExtension(inputFilename) + ".xml",
                    content);
        } catch (NullPointerException npe) {
            System.err.format("IOException failed during processing results %s%n", npe);
            return;
        }
    }
}