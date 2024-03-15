package BangunRuang;
import BangunDatar.Lingkaran;

public class Tabung extends Lingkaran implements BangunRuang {
    double tinggiTabung;

    public Tabung(double r, double tinggiTabung) {
        super(r);
        this.tinggiTabung = tinggiTabung;
    }

    public double volume() {
        return luas() * tinggiTabung;
    }

    public double luasPermukaan() {
        return 2 * luas() + keliling() * tinggiTabung;
    }
}
