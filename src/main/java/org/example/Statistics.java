package org.example;

import java.util.List;

public class Statistics {
    private String profile; // Профиль обучения
    private double averageScore; // Средний балл за экзамен
    private int studentCount; // Количество студентов по профилю
    private int universityCount; // Количество университетов по профилю
    private List<String> universityNames; // Названия университетов

    public Statistics(String profile, double averageScore, int studentCount, int universityCount, List<String> universityNames) {
        this.profile = profile;
        this.averageScore = averageScore;
        this.studentCount = studentCount;
        this.universityCount = universityCount;
        this.universityNames = universityNames;
    }

    // Геттеры и сеттеры
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getUniversityCount() {
        return universityCount;
    }

    public void setUniversityCount(int universityCount) {
        this.universityCount = universityCount;
    }

    public List<String> getUniversityNames() {
        return universityNames;
    }

    public void setUniversityNames(List<String> universityNames) {
        this.universityNames = universityNames;
    }
}

