package com.izamtest.decathlon.validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class XMLValidator {
    public static boolean validateFromFile(final String xmlFile, final String schemaFile) {
        try {
            Schema schema = getSchema(schemaFile);
            assert schema != null;
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFile)));
            return true;
        } catch (SAXException | NullPointerException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean validateFromString(final String xmlString, final String schemaFile) {
        try {
            Schema schema = getSchema(schemaFile);
            assert schema != null;
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8))));
            return true;
        } catch (SAXException | NullPointerException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Schema getSchema(final String schemaFile) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            return schemaFactory.newSchema(new File(XMLValidator.class.getClassLoader().getResource(schemaFile).getFile()));
        } catch (SAXException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

}

