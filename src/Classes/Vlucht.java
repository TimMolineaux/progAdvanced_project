package Classes;

import java.util.ArrayList;
import java.util.Objects;

public class Vlucht {
    private String vluchtcode;
    private String beginPlaats;
    private String eindBestemming;
    private int econonomyPlaatsen;
    private int businessPlaatsen;
    private double maxGewicht;
    private boolean flightCheck;

    private ArrayList<Passagier> passagiersOpVlucht;

    public Vlucht(String vluchtcode, String beginPlaats, String eindBestemming, int econonomyPlaatsen, int businessPlaatsen, double maxGewicht, boolean flightCheck) {
        this.vluchtcode = vluchtcode;
        this.beginPlaats = beginPlaats;
        this.eindBestemming = eindBestemming;
        this.econonomyPlaatsen = econonomyPlaatsen;
        this.businessPlaatsen = businessPlaatsen;
        this.maxGewicht = maxGewicht;
        this.flightCheck = flightCheck;
        this.passagiersOpVlucht = new ArrayList<>();
    }

    public String getVluchtcode() {
        return vluchtcode;
    }

    public void setVluchtcode(String vluchtcode) {
        this.vluchtcode = vluchtcode;
    }

    public String getBeginPlaats() {
        return beginPlaats;
    }

    public void setBeginPlaats(String beginPlaats) {
        this.beginPlaats = beginPlaats;
    }

    public String getEindBestemming() {
        return eindBestemming;
    }

    public void setEindBestemming(String eindBestemming) {
        this.eindBestemming = eindBestemming;
    }

    public int getEcononomyPlaatsen() {
        return econonomyPlaatsen;
    }

    public void setEcononomyPlaatsen(int econonomyPlaatsen) {
        this.econonomyPlaatsen = econonomyPlaatsen;
    }

    public int getBusinessPlaatsen() {
        return businessPlaatsen;
    }

    public void setBusinessPlaatsen(int businessPlaatsen) {
        this.businessPlaatsen = businessPlaatsen;
    }

    public double getMaxGewicht() {
        return maxGewicht;
    }

    public void setMaxGewicht(double maxGewicht) {
        this.maxGewicht = maxGewicht;
    }

    public boolean isFlightCheck() {
        return flightCheck;
    }

    public void setFlightCheck(boolean flightCheck) {
        this.flightCheck = flightCheck;
    }

    @Override
    public String toString() {
        return "Vlucht{" +
                "vluchtcode='" + vluchtcode + '\'' +
                ", beginPlaats='" + beginPlaats + '\'' +
                ", eindBestemming='" + eindBestemming + '\'' +
                ", econonomyPlaatsen=" + econonomyPlaatsen +
                ", businessPlaatsen=" + businessPlaatsen +
                ", maxGewicht=" + maxGewicht +
                ", flightCheck=" + flightCheck +
                '}';
    }

    public void voegPassagierToe (Ticket ticket) {
        passagiersOpVlucht.add(ticket.getPassagier());

        if (Objects.equals(ticket.getKlasse(), "Business")) {
            businessPlaatsen--;
        }else if (Objects.equals(ticket.getKlasse(), "Economy")) {
            econonomyPlaatsen--;
        }
    }

    public ArrayList<Passagier> getPassagiers() {
        return passagiersOpVlucht;
    }
}
