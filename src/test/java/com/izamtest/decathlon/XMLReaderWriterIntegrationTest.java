package com.izamtest.decathlon;

import com.izamtest.decathlon.dao.Athlete;
import com.izamtest.decathlon.service.CSVParser;
import com.izamtest.decathlon.service.SAXXMLWriter;
import com.izamtest.decathlon.service.XMLWriter;
import com.izamtest.decathlon.validation.XMLValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class XMLReaderWriterIntegrationTest {
    private List<Athlete> list = new ArrayList<>(1);
    private Map<Integer, List<Athlete>> map = new HashMap<>();

    @BeforeEach
    private void setUp() {
        Athlete a = CSVParser.readRow("Bruno Gordo;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6.50.76");
        list.add(a);
        map.put(3202, list);
    }

    @AfterEach
    private void clear() {
        list.clear();
        map.clear();
    }

    @Test
    void XMLValidationTest_passedOk() {
        assertTrue(XMLValidator.validateFromString(XMLWriter.writeResultsToXML(map, list.size()), Application.SCHEMA_FILE));
    }

    @Test
    void XMLSAXValidationTest_passedOk() {
        SAXXMLWriter.writeResultsToXML(map, list.size(), "temp.xml");
        String xml = readStringFromFile("temp.xml");
        assertTrue(XMLValidator.validateFromString(xml, Application.SCHEMA_FILE));
    }

    private String readStringFromFile(final String filename) {
        StringBuilder buf = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String row;
            while ((row = reader.readLine()) != null) {
                try {
                    buf.append(row);
                } catch (NumberFormatException nex) {
                    System.err.format("Cannot parse results of '%s': %s", row, nex.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }
}
