package com.izamtest.decathlon.dao;

import com.izamtest.decathlon.model.AbstractDecathlonBaseResult;

import java.util.ArrayList;

public class Athlete {
    private String name;
    private ArrayList<AbstractDecathlonBaseResult> results;
    private int totalPoints;

    public Athlete(final String newName, final ArrayList<AbstractDecathlonBaseResult> newResults) {
        this.name = newName;
        this.results = newResults;
        this.totalPoints = getResults().stream().mapToInt(AbstractDecathlonBaseResult::getPoints).sum();
    }

    public final ArrayList<AbstractDecathlonBaseResult> getResults() {
        return this.results;
    }

    public String getName() {
        return this.name;
    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    public String toString() {
        return String.format("%s: %d", this.name, this.totalPoints);
    }

    public String toXMLString() {
        return String.format("<athlete name=\"%s\" points=\"%d\"/>", this.name, this.totalPoints);
    }

}
