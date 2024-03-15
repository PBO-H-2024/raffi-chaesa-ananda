package BangunDatar;

public class Lingkaran {
    double phi, r;

    public Lingkaran(double r) {
        this.phi = 22.0 / 7.0;
        this.r = r;
    }

    public double luas() {
        return phi * r * r;
    }

    public double keliling() {
        return 2 * phi * r;
    }
}
