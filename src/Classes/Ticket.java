package Classes;

public class Ticket {
    Passagier passagier;
    Vlucht vlucht;
    String klasse;

    public Ticket(Passagier passagier, Vlucht vlucht, String klasse) {
        this.passagier = passagier;
        this.vlucht = vlucht;
        this.klasse = klasse;
    }

    public Passagier getPassagier() {
        return passagier;
    }

    public void setPassagier(Passagier passagier) {
        this.passagier = passagier;
    }

    public Vlucht getVlucht() {
        return vlucht;
    }

    public void setVlucht(Vlucht vlucht) {
        this.vlucht = vlucht;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "passagier=" + passagier +
                ", vlucht=" + vlucht +
                ", klasse='" + klasse + '\'' +
                '}';
    }
}
