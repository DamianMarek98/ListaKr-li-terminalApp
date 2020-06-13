package projekt.infa;

import java.util.Scanner;

public class Kontroler {

    public void uruchom() {
        Wladcy wladcy = new Wladcy();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Akcje: d - dodaj króla, u - usuń króla, s - zamień króli, o - opis króla, w - wczytaj zapis, z - zapisz");
            wladcy.wypiszWladcow();

            switch (scanner.nextLine()) {
                case "o":
                    opisWladcy(wladcy, scanner);
                    break;
                case "w":
                    wladcy.wczytajWladcowZPliku();
                    break;
                case "z":
                    wladcy.zapiszWladcowDoPliku();
                    break;
            }

        } while (true);
    }

    private static void opisWladcy(Wladcy wladcy, Scanner scanner) {
        System.out.println("Podaj numer władcy, którego opis chcesz wypisać:");
        int numer = Integer.parseInt(scanner.nextLine());
        wladcy.opisWladcy(numer);
    }
}
