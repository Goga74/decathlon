package com.izamtest.decatlon.dao;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "results")
public class Results {
    List<Place> places;
    int athletes;

    public Results() {
    }

    public Results(final List<Place> places, final int athletesListSize) {
        this.places = places;
        this.athletes = athletesListSize;
    }

    @XmlAttribute(name = "athletes")
    public int getAthletesListSize() {
        return this.athletes;
    }

    @XmlElement(name = "places")
    public List<Place> getPlaces() {
        return this.places;
    }
}
