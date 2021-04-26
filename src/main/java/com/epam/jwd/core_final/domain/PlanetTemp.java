package com.epam.jwd.core_final.domain;

public enum PlanetTemp {
    GENERAL;
    private static String from;
    private static String to;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        PlanetTemp.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String name) {
        PlanetTemp.from = name;
    }
}
