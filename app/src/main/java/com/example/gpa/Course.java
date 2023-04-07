package com.example.gpa;

public class Course {
    private String name;
    private double credit;
    private String grade;

    public Course(String name, double credit, String grade) {
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    public double getCredit() {
        return credit;
    }

    public double getGradePoints() {
        switch (grade) {
            case "O":
                return 10.0 * credit;
            case "A+":
                return 9.0 * credit;
            case "A":
                return 8.0 * credit;
            case "B+":
                return 7.0 * credit;
            case "B":
                return 6.0 * credit;
            case "RA":
                return 0.0 * credit;
            case "AB":
                return 0.0 * credit;
            default:
                return 0.0;
        }
    }
}

