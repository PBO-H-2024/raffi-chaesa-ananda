import java.util.Scanner;

import BangunRuang.Limas;
import BangunRuang.Tabung;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Hello, World!");
        System.out.println("1. Limas Segitiga");
        System.out.println("2. Tabung");
        System.out.println("3. Exit");
        System.out.print("Pilih > ");
        String choice = myObj.nextLine();

        if (choice.equals("1")) {
            limas(myObj);
        } else if (choice.equals("2")) {
            tabung(myObj);
        } else if (choice == "3") {
            myObj.close();
            return;
        }
    }

    public static void limas(Scanner myObj) {
        System.out.println("Input > ");
        System.out.print("Nilai a: ");
        double a = myObj.nextDouble();
        System.out.print("Nilai b: ");
        double b = myObj.nextDouble();
        System.out.print("Nilai c: ");
        double c = myObj.nextDouble();
        System.out.print("Nilai tinggi limas: ");
        double tinggi = myObj.nextDouble();

        System.out.println("\nOutput > ");
        Limas limas = new Limas(a, b, c, tinggi);
        System.out.println("Luas Segitiga\t\t: " + limas.luas());
        System.out.println("Keliling Segitiga\t: " + limas.keliling());
        System.out.println("Volume Limas\t\t: " + limas.volume());
        System.out.println("Luas Permukaan Limas\t: " + limas.luasPermukaan());
    }

    public static void tabung(Scanner myObj) {
        System.out.println("\nINPUT");
        System.out.print("Input Jari-Jari\t\t: ");
        double r = myObj.nextDouble();
        System.out.print("Input Tinggi Tabung\t: ");
        double tinggi = myObj.nextDouble();

        System.out.println("\nOUTPUT");
        Tabung tabung = new Tabung(r, tinggi);
        System.out.println("Luas Lingkaran\t\t: " + tabung.luas());
        System.out.println("Keliling Lingkaran\t: " + tabung.keliling());
        System.out.println("Volume Tabung\t\t: " + tabung.volume());
        System.out.println("LuasPermukaan Tabung\t: " + tabung.luasPermukaan());
    }
}