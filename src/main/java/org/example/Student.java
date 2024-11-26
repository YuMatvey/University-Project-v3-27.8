package org.example;

public class Student {
    private String name;
    private String profile;
    private double score;

    public Student(String name, String profile, double score) {
        this.name = name;
        this.profile = profile;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getProfile() {
        return profile;
    }

    public double getScore() {
        return score;
    }
}

