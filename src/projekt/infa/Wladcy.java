package projekt.infa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wladcy {

    public static final String SCIEZKA_PLIK = "C:\\Users\\Deny\\Downloads\\ListaKr-li-terminalApp\\zasoby\\plikWladcow.txt";
    private List<Wladca> listaWladcow = new ArrayList<>();


    public void dodajWladce(Wladca wladca) {
        listaWladcow.add(wladca);
    }

    public void usunWladce(Wladca wladca) {
        listaWladcow.remove(wladca);
    }

    public int pobierzIloscWladcow() {
        return listaWladcow.size();
    }

    public Wladca pobierzWladceONumerze(int numer) {
        return listaWladcow.get(numer - 1);
    }

    public void zamienWladcowMiejscami(int numerWladcy1, int numerWladcy2) {
        Wladca wladca1 = listaWladcow.get(numerWladcy1);
        Wladca wladca2 = listaWladcow.get(numerWladcy2);
        listaWladcow.set(numerWladcy2, wladca1);
        listaWladcow.set(numerWladcy1, wladca2);
    }

    public void dodajWladceWMiejscu(Wladca wladca, int numer) {
        listaWladcow.add(numer - 1, wladca);
    }

    public void zapiszWladcowDoPliku() {
        try {
            FileWriter fileWriter = new FileWriter(SCIEZKA_PLIK);

            for (Wladca wladca : listaWladcow) {
                fileWriter.write(tekstWladcyDoZapisu(wladca));
                fileWriter.write(System.lineSeparator());
            }

            System.out.println("Poprawnie zapisano do pliku!");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Problem z zapisem do pliku.");
        }
    }

    private String tekstWladcyDoZapisu(Wladca wladca) {
        return wladca.getImie() + "," +
                wladca.getNazwisko() + "," +
                wladca.getRokUrodzenia() + "," +
                wladca.getRokSmierci() + "," +
                wladca.getRokRozpoczeciaRzadow() + "," +
                wladca.getRokZakonczeniaRzadow() + "," +
                wladca.getOpis();
    }

    public void wczytajWladcowZPliku() {
        listaWladcow.clear();
        try {
            Scanner scanner = new Scanner(new File(SCIEZKA_PLIK));
            while (scanner.hasNextLine()) {
                wladcaZTekstu(scanner.nextLine());
            }

            System.out.println("Poprawnie wczytano z pliku!");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!");
        }
    }

    private void wladcaZTekstu(String tekst) {
        String[] pola = tekst.split(",");
        Wladca wladca = new Wladca();
        wladca.setImie(pola[0]);
        wladca.setNazwisko(pola[1]);
        wladca.setRokUrodzenia(Integer.parseInt(pola[2]));
        wladca.setRokSmierci(Integer.parseInt(pola[3]));
        wladca.setRokRozpoczeciaRzadow(Integer.parseInt(pola[4]));
        wladca.setRokZakonczeniaRzadow(Integer.parseInt(pola[5]));
        wladca.setOpis(pola[6]);

        listaWladcow.add(wladca);
    }

    public void wypiszWladcow() {
        if (!listaWladcow.isEmpty()) {
            int numer = 1;
            System.out.println("Lista Wladcow:");
            for (Wladca wladca : listaWladcow) {
                System.out.println(numer + ". Imie: " + wladca.getImie()
                        + " Nazwisko: " + wladca.getNazwisko()
                        + " (" + wladca.getRokUrodzenia() + "-" + wladca.getRokSmierci() + ")"
                        + " królował w latach: "
                        + wladca.getRokRozpoczeciaRzadow() + "-" + wladca.getRokZakonczeniaRzadow());

                numer++;
            }
        }
    }

    public void opisWladcy(int numer) {
        Wladca wladca = listaWladcow.get(numer - 1);
        System.out.println("Opis władcy " + wladca.getImie() + " " + wladca.getNazwisko() + ":");
        System.out.println(wladca.getOpis());
    }
}
