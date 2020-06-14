package projekt.infa;

public class Wladca {

    private String imie;
    private String nazwisko;
    private int rokUrodzenia;
    private int rokRozpoczeciaRzadow;
    private int rokZakonczeniaRzadow;
    private int rokSmierci;
    private String opis;

    public Wladca() {
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }

    public int getRokRozpoczeciaRzadow() {
        return rokRozpoczeciaRzadow;
    }

    public void setRokRozpoczeciaRzadow(int rokRozpoczeciaRzadow) {
        this.rokRozpoczeciaRzadow = rokRozpoczeciaRzadow;
    }

    public int getRokZakonczeniaRzadow() {
        return rokZakonczeniaRzadow;
    }

    public void setRokZakonczeniaRzadow(int rokZakonczeniaRzadow) {
        this.rokZakonczeniaRzadow = rokZakonczeniaRzadow;
    }

    public int getRokSmierci() {
        return rokSmierci;
    }

    public void setRokSmierci(int rokSmierci) {
        this.rokSmierci = rokSmierci;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean waliduj() {
        if (rokSmierci < rokUrodzenia) {
            System.out.println("Rok śmierci nie może być przed rokiem urodzenia!");
            return false;
        } else if (rokZakonczeniaRzadow < rokRozpoczeciaRzadow) {
            System.out.println("Rok rozpoczęcia rządów nie może być przed rokiem zakończenia rządów!");
            return false;
        } else if (rokZakonczeniaRzadow >= rokSmierci || rokZakonczeniaRzadow <= rokUrodzenia) {
            System.out.println("Rok zakończenia rządów nie zawiera się w datach życia władcy!");
            return false;
        } else if (rokRozpoczeciaRzadow <= rokUrodzenia) {
            System.out.println("Rok rozpoczęcia rządów nie zawiera się w datach życia władcy!");
            return false;
        }

        return true;
    }
}
