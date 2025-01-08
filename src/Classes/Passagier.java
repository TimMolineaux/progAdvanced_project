package Classes;

import java.time.LocalDate;

public class Passagier extends Persoon{
    private double bagage;

    public Passagier(String voornaam, String achternaam, LocalDate geboortedatum, String adress, double bagage) {
        super(voornaam, achternaam, geboortedatum, adress);
        this.bagage = bagage;
    }

    public double getBagage() {
        return bagage;
    }

    public void setBagage(double bagage) {
        this.bagage = bagage;
    }

    @Override
    public String toString() {
        return "Passagier{" +
                "bagage=" + bagage +
                '}';
    }
}
