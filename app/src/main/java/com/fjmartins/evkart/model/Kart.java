package com.fjmartins.evkart.model;

import java.util.ArrayList;

public class Kart {

    private String name;
    private ArrayList<Log> logEntries = new ArrayList<>();

    public Kart(String name) {
        super();
        this.name = name;
    }

    public void addLog(Log entry) {
        logEntries.add(entry);
    }
}
