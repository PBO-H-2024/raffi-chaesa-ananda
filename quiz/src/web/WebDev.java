package web;

public class WebDev {
    private double exam;
    private double coding;
    private double interview;

    double examWeight = 0.4;
    double codingWeight = 0.35;
    double interviewWeight = 0.25;

    public WebDev(double exam, double coding, double interview) {
        this.exam = exam;
        this.coding = coding;
        this.interview = interview;
    }

    public double getAvgWeb() {
        return (exam * examWeight) + (coding * codingWeight) + (interview * interviewWeight);
    }
}
