package org.example;


public class University {
    private String name;
    private String profile;

    public University(String name, String profile) {
        this.name = name;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public String getProfile() {
        return profile;
    }
}