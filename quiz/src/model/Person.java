package model;

public class Person {
    private String fullName;
    private String nim;
    private double exam;
    private double coding;
    private double interview;

    public Person(String fullName, String nim, double exam, double coding, double interview) {
        this.fullName = fullName;
        this.nim = nim;
        this.exam = exam;
        this.coding = coding;
        this.interview = interview;

        System.out
                .println("Name: " + fullName + "\nNIM: " + nim + "\nWriting exam: " + exam + "\nCoding test: " + coding
                        + "\nInterview test: " + interview);
    }

    public String getFullName() {
        return fullName;
    }

    public String getNIM() {
        return nim;
    }

    public double getExamScore() {
        return exam;
    }

    public double getCodingScore() {
        return coding;
    }

    public double getInterviewScore() {
        return interview;
    }

    @Override
    public String toString() {
        return "Name: " + fullName + "\nNIM: " + nim + "\nWriting exam: " + exam + "\nCoding test: " + coding
                + "\nInterview test: " + interview;
    }
}