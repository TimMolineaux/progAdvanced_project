package Classes;

import java.time.LocalDate;

public class Passagier extends Persoon{
    private int bagage;

    public Passagier(String voornaam, String achternaam, LocalDate geboortedatum, String adress, int bagage) {
        super(voornaam, achternaam, geboortedatum, adress);
        this.bagage = bagage;
    }

    public int getBagage() {
        return bagage;
    }

    public void setBagage(int bagage) {
        this.bagage = bagage;
    }

    @Override
    public String toString() {
        return "Passagier{" +
                "bagage=" + bagage +
                '}';
    }
}
