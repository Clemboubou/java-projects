package com.dfs_java;

import java.util.*;

public class Student {
    private List<Long> maths;
    private List<Long> french;
    private List<Long> history;
    private double mathAverage;
    private double frenchAverage;
    private double historyAverage;
    private double totalAverage;
    private String name;

    public Student(String name) {
        this.name = name;
        this.maths = new ArrayList<>();
        this.french = new ArrayList<>();
        this.history = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            this.maths.add((long) Math.floor(rand.nextDouble() * 20));
            this.french.add((long) Math.floor(rand.nextDouble() * 20));
            this.history.add((long) Math.floor(rand.nextDouble() * 20));
        }
        this.mathAverage = 0;
        this.frenchAverage = 0;
        this.historyAverage = 0;
        this.totalAverage = 0;
    }

    public void calculateAverages() {
        this.mathAverage = maths.stream().mapToDouble(Long::doubleValue).average().orElse(0);
        this.frenchAverage = french.stream().mapToDouble(Long::doubleValue).average().orElse(0);
        this.historyAverage = history.stream().mapToDouble(Long::doubleValue).average().orElse(0);
        this.totalAverage = (mathAverage + frenchAverage + historyAverage) / 3.0;
    }

    public double getMathAverage() { return mathAverage; }
    public double getFrenchAverage() { return frenchAverage; }
    public double getHistoryAverage() { return historyAverage; }
    public double getTotalAverage() { return totalAverage; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return String.format("%s: Maths=%.2f, French=%.2f, History=%.2f, Total=%.2f", name, mathAverage, frenchAverage, historyAverage, totalAverage);
    }
}
