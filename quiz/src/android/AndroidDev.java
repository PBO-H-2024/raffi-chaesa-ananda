package android;

public class AndroidDev {
    private double exam;
    private double coding;
    private double interview;

    double examWeight = 0.2;
    double codingWeight = 0.5;
    double interviewWeight = 0.3;

    public AndroidDev(double exam, double coding, double interview) {
        this.exam = exam;
        this.coding = coding;
        this.interview = interview;
    }

    public double getAvgAndroid() {
        return (exam * examWeight) + (coding * codingWeight) + (interview * interviewWeight);
    }
}
