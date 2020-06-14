package projekt.infa;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Kontroler {

    public void uruchom() {
        Wladcy wladcy = new Wladcy();
        wladcy.wczytajWladcowZPliku();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Akcje: d - dodaj króla, u - usuń króla, e - edytuj króla, s - zamień króli, o - opis króla, w - wczytaj zapis, z - zapisz");
            wladcy.wypiszWladcow();

            switch (scanner.nextLine()) {
                case "d":
                    dodajWladce(wladcy, scanner);
                    break;
                case "u":
                    usunWladce(wladcy, scanner);
                    break;
                case "e":
                    edytujWladce(wladcy, scanner);
                    break;
                case "s":
                    zamienKroli(wladcy, scanner);
                    break;
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

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("Błąd podczas opóźnienia po operafcji");
            }
        } while (true);
    }

    private static void dodajWladce(Wladcy wladcy, Scanner scanner) {
        Wladca wladca = new Wladca();
        System.out.println("Podaj numer miejsca, w którym ma zostać umieszczony nowy władca:");
        try {
            int numer = Integer.parseInt(scanner.nextLine());
            if (numer > wladcy.pobierzIloscWladcow() + 1 || numer < 1) {
                System.out.println("Podany numer władcy poza zakresem listy!");
            } else {
                System.out.println("Podaj imię nowego władcy:");
                wladca.setImie(scanner.nextLine());
                System.out.println("Podaj nazwisko nowego władcy:");
                wladca.setNazwisko(scanner.nextLine());
                System.out.println("Podaj rok urodzenia nowego władcy:");
                wladca.setRokUrodzenia(Integer.parseInt(scanner.nextLine()));
                System.out.println("Podaj rok śmierci nowego władcy:");
                wladca.setRokSmierci(Integer.parseInt(scanner.nextLine()));
                System.out.println("Podaj rok rozpoczęcia rządów nowego władcy:");
                wladca.setRokRozpoczeciaRzadow(Integer.parseInt(scanner.nextLine()));
                System.out.println("Podaj rok zakończenia rządów nowego władcy:");
                wladca.setRokZakonczeniaRzadow(Integer.parseInt(scanner.nextLine()));
                System.out.println("Podaj opis nowego władcy:");
                wladca.setOpis(scanner.nextLine());

                if (wladca.waliduj()) {
                    wladcy.dodajWladce(numer, wladca);
                    System.out.println("Poprawnie dodano nowego władcę!");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Błąd podaj liczbę!");
        }
    }

    private static void edytujWladce(Wladcy wladcy, Scanner scanner) {
        System.out.println("Podaj numer miejsca, w którym ma zostać umieszczony nowy władca:");
        try {
            int numer = Integer.parseInt(scanner.nextLine());
            if (numer > wladcy.pobierzIloscWladcow() || numer < 1) {
                System.out.println("Podany numer władcy poza zakresem listy!");
            } else {
                Wladca wladca = wladcy.pobierzWladceONumerze(numer);

                System.out.println("Imie władcy: " + wladca.getImie() + " chcesz zmienić? (t - zmień)");
                if (scanner.nextLine().equalsIgnoreCase("t")) {
                    System.out.println("Zmień imie władcy:");
                    wladca.setImie(scanner.nextLine());
                }

                System.out.println("Nazwisko władcy: " + wladca.getNazwisko() + " chcesz zmienić? (t - zmień)");
                if (scanner.nextLine().equalsIgnoreCase("t")) {
                    System.out.println("Zmień nazwisko władcy:");
                    wladca.setNazwisko(scanner.nextLine());
                }

                System.out.println("Rok urodzenia władcy: " + wladca.getRokUrodzenia() + " chcesz zmienić? (t - zmień)");
                if (scanner.nextLine().equalsIgnoreCase("t")) {
                    System.out.println("Zmień rok urodzenia władcy:");
                    wladca.setRokUrodzenia(Integer.parseInt(scanner.nextLine()));
                }

                System.out.println("Rok śmierci władcy: " + wladca.getRokSmierci() + " chcesz zmienić? (t - zmień)");
                if (scanner.nextLine().equalsIgnoreCase("t")) {
                    System.out.println("Zmień rok śmierci władcy:");
                    wladca.setRokSmierci(Integer.parseInt(scanner.nextLine()));
                }

                System.out.println("Rok rozpoczęcia rządów władcy: " + wladca.getRokRozpoczeciaRzadow() + " chcesz zmienić? (t - zmień)");
                if (scanner.nextLine().equalsIgnoreCase("t")) {
                    System.out.println("Zmień rok rozpoczęcia rządów władcy:");
                    wladca.setRokRozpoczeciaRzadow(Integer.parseInt(scanner.nextLine()));
                }

                System.out.println("Rok zakończenia rządów władcy: " + wladca.getRokRozpoczeciaRzadow() + " chcesz zmienić? (t - zmień)");
                if (scanner.nextLine().equalsIgnoreCase("t")) {
                    System.out.println("Zmień rok zakończenia rządów władcy:");
                    wladca.setRokZakonczeniaRzadow(Integer.parseInt(scanner.nextLine()));
                }

                System.out.println("Opis władcy: " + wladca.getOpis() + " chcesz zmienić? (t - zmień)");
                if (scanner.nextLine().equalsIgnoreCase("t")) {
                    System.out.println("Zmień opis władcy:");
                    wladca.setOpis(scanner.nextLine());
                }

                if (wladca.waliduj()) {
                    wladcy.edytujWladce(numer, wladca);
                    System.out.println("Poprawnie wyedytowno władcę!");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Błąd podaj liczbę!");
        }
    }

    private static void opisWladcy(Wladcy wladcy, Scanner scanner) {
        System.out.println("Podaj numer władcy, którego opis chcesz wypisać:");
        try {
            int numer = Integer.parseInt(scanner.nextLine());
            if (numer > wladcy.pobierzIloscWladcow() || numer < 1) {
                System.out.println("Podany numer władcy poza zakresem listy!");
            } else {
                wladcy.opisWladcy(numer);
            }
        } catch (NumberFormatException e) {
            System.out.println("Błąd podaj liczbę!");
        }
    }

    private static void usunWladce(Wladcy wladcy, Scanner scanner) {
        System.out.println("Podaj numer władcy, którego chcesz usunąć:");
        try {
            int numer = Integer.parseInt(scanner.nextLine());
            if (numer > wladcy.pobierzIloscWladcow() || numer < 1) {
                System.out.println("Podany numer władcy poza zakresem listy!");
            } else {
                wladcy.usunWladce(numer);
                System.out.println("Usunięto króla!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Błąd podaj liczbę!");
        }
    }

    private static void zamienKroli(Wladcy wladcy, Scanner scanner) {
        System.out.println("Podaj numer pierwszego władcy do zamiany:");
        try {
            int numer1 = Integer.parseInt(scanner.nextLine());
            if (numer1 > wladcy.pobierzIloscWladcow() || numer1 < 1) {
                System.out.println("Podany numer władcy poza zakresem listy!");
            } else {
                System.out.println("Podaj numer drugiego władcy do zamiany:");
                int numer2 = Integer.parseInt(scanner.nextLine());
                if (numer2 > wladcy.pobierzIloscWladcow() || numer2 < 1) {
                    System.out.println("Podany numer władcy poza zakresem listy!");
                } else {
                    wladcy.zamienWladcowMiejscami(numer1, numer2);
                    System.out.println("Poprawnie zamieniono króli!");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Błąd podaj liczbę!");
        }
    }
}
