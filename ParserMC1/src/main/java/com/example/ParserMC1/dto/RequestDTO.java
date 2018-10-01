package com.example.ParserMC1.dto;

public class RequestDTO {
    private String query ;
    private boolean turnOff;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public boolean isTurnOff() {
        return turnOff;
    }

    public void setTurnOff(boolean turnOff) {
        this.turnOff = turnOff;
    }
}
