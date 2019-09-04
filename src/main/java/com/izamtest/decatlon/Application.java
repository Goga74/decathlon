package com.izamtest.decatlon;

import com.izamtest.decatlon.dao.Athlete;
import com.izamtest.decatlon.service.CSVParser;
import com.izamtest.decatlon.service.FilenameUtils;
import com.izamtest.decatlon.service.XMLWriter;

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

        ArrayList<Athlete> list = CSVParser.parse(args[0]);

        // get list which is sorted by points descending,
        // and then group results byh points in map
        // to process situation with equals results and sharing medals
        Map<Integer, List<Athlete>> groupingByPoints = list.stream().
                collect(Collectors.groupingBy(Athlete::getTotalPoints)).
                entrySet().stream().
                sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        XMLWriter.writeResultsToXMLFile(groupingByPoints, list.size(),
                FilenameUtils.getFileNameWithoutExtension(inputFilename) + ".xml");

    }
}
