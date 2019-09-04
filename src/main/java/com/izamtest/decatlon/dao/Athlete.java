package com.izamtest.decatlon.dao;

import com.izamtest.decatlon.model.AbstractDecathlonBaseResult;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "athlete")
public class Athlete {
    private String name;
    private ArrayList<AbstractDecathlonBaseResult> results;
    private int totalPoints;

    public Athlete() {
    }

    public Athlete(final String newName, final ArrayList<AbstractDecathlonBaseResult> newResults) {
        this.name = newName;
        this.results = newResults;
        this.totalPoints = getResults().stream().mapToInt(AbstractDecathlonBaseResult::getPoints).sum();
    }

    public final ArrayList<AbstractDecathlonBaseResult> getResults() {
        return this.results;
    }

    @XmlAttribute(name = "name")
    public String getName() {
        return this.name;
    }

    @XmlAttribute(name = "points")
    public int getTotalPoints() {
        return this.totalPoints;
    }

    public String toString() {
        return String.format("%s: %d", this.name, this.totalPoints);
    }

}
