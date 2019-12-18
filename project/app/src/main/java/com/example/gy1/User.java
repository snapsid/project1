package com.example.gy1;

public class User {

    public  String name, course, year, email;

    User() {
    }
    User(String name, String course, String year, String email) {
        this.name = name;
        this.course = course;
        this.year = year;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getYear() {
        return year;
    }

    public String getEmail() {
        return email;
    }
}
