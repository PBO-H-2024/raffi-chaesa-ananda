import java.util.Scanner;

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
            // hitung limas;
        } else if (choice.equals("2")) {
            // hitung tabung;
        } else if (choice == "3") {
            myObj.close();
            return;
        }
    }
}