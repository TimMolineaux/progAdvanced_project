package Classes;

import java.time.LocalDate;

public class Personeel extends Persoon{
    private String rol;

    public Personeel(String voornaam, String achternaam, LocalDate geboortedatum, String adress, String rol) {
        super(voornaam, achternaam, geboortedatum, adress);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Personeel{" +
                "rol='" + rol + '\'' +
                '}';
    }
}
