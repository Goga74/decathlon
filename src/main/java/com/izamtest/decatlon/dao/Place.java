package com.izamtest.decatlon.dao;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "place")
public class Place {
    private List<Athlete> list;
    private String place;

    public Place() {
    }

    public Place(final List<Athlete> athletesList, final String place) {
        this.list = athletesList;
        this.place = place;
    }

    @XmlAttribute(name = "id")
    public String getPlace() {
        return this.place;
    }

    @XmlElement(name = "athlete")
    public List<Athlete> getAthletes() {
        return this.list;
    }

}
