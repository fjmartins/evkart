package com.fjmartins.evkart.model;

import java.util.ArrayList;

public class Kart extends LogEntry {

    private String name;
    private ArrayList<LogEntry> logEntries = new ArrayList<>();

    public Kart(String name) {
        super();
        this.name = name;
    }

    public void addLog(LogEntry entry) {
        logEntries.add(entry);
    }

    public String getStats() {
        return "\n" + name + "\n" + (logEntries.isEmpty() ? "" : logEntries.get(logEntries.size() - 1).toString());
    }
}
