import Classes.Passagier;
import Classes.Ticket;
import Classes.Vlucht;
import Lijsten.Bestemmingen;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int optie;

        ArrayList<Passagier> passagiers = new ArrayList<>();
        ArrayList<Vlucht> vluchten = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();

        do {
            do {
                System.out.println("Vul het nummer in van de functie die je wilt uitvoeren:");
                System.out.println("1:Passagier aanmaken");
                System.out.println("2:Vlucht aanmaken");
                System.out.println("3:Ticket aanmaken");
                System.out.println("4:Passagier aan vlucht toevoegen");
                System.out.println("5:Personeel aan vlucht toewijzen");
                System.out.println("6:Vlucht info printen");
                System.out.println("7:Applicatie afsluiten");

                optie = input.nextInt();

                if (optie <= 0 || optie > 7) {
                    System.err.println("Je hebt een ongeldige waarde ingegeven!");
                }
            }while (optie <= 0 || optie > 7);

            switch (optie) {
                case 1:
                    System.out.println("Passagier aanmaken");
                    String voornaam;
                    String achternaam;
                    LocalDate geboortedatum;
                    String adress;
                    double bagage;

                    System.out.println("Vul de voornaam in:");
                    do {
                        voornaam = input.nextLine();
                    }while (Objects.equals(voornaam, ""));

                    System.out.println("Vul de achternaam in:");
                    do {
                        achternaam = input.nextLine();
                    }while (Objects.equals(achternaam, ""));

                    System.out.println("Vul de geboortedatum in in(jjjj/mm/dd):");
                    do {
                        geboortedatum = LocalDate.parse(input.nextLine());
                    }while (Objects.equals(geboortedatum, ""));

                    System.out.println("Vul het adress in:");
                    do {
                        adress = input.nextLine();
                    }while (Objects.equals(achternaam, ""));

                    System.out.println("Vul het gewicht van de bagage in(kg):");
                    do {
                        bagage = input.nextDouble();
                    }while (bagage < 0);

                    Passagier p = new Passagier(voornaam, achternaam, geboortedatum, adress, bagage);
                    passagiers.add(p);
                    System.out.println(passagiers);

                    break;
                case 2:
                    System.out.println("Vlucht aanmaken");
                     String vluchtcode;
                     String beginPlaats;
                     String eindBestemming;
                     int econonomyPlaatsen;
                     int businessPlaatsen;
                     double maxGewicht;
                     char vraag;
                     boolean flightCheck = false;

                    System.out.println("Vul de vluchtcode in:");
                    do{
                        vluchtcode = input.nextLine();
                    }while (Objects.equals(vluchtcode, ""));

                    do{
                        System.out.println("Vul de beginplaats in(typ 'opties' om alle geldige plaatsen te zien):");
                        beginPlaats = input.nextLine();

                        if (Objects.equals(beginPlaats, "opties")) {
                            for (Bestemmingen b : Bestemmingen.values()) {
                                System.out.println(b);
                            }
                        }else{
                            try {
                                Bestemmingen plaats = Bestemmingen.valueOf(beginPlaats);
                                break;
                            }catch (IllegalArgumentException e){
                                System.err.println("Je hebt een ongeldige plaats ingegeven!");
                            }
                        }
                    }while (true);

                    do{
                        System.out.println("Vul de eindbestemming in(typ 'opties' om alle geldige plaatsen te zien):");
                        eindBestemming = input.nextLine();

                        if (Objects.equals(eindBestemming, "opties")) {
                            for (Bestemmingen b : Bestemmingen.values()) {
                                System.out.println(b);
                            }
                        }else{
                            try {
                                Bestemmingen plaats = Bestemmingen.valueOf(eindBestemming);

                                if (Objects.equals(beginPlaats, eindBestemming)) {
                                    System.err.println("De beginplaats kan niet dezelfde zijn als de einbestemming!");
                                }else{
                                    break;
                                }
                            }catch (IllegalArgumentException e){
                                System.err.println("Je hebt een ongeldige plaats ingegeven!");
                            }
                        }
                    }while (true);

                    do{
                        System.out.println("Vul het aantal beschikbare economyplaatsen in:");
                        econonomyPlaatsen = input.nextInt();

                        if (econonomyPlaatsen < 0){
                            System.err.println("Je hebt een ongeldige waarde ingegeven!");
                        }
                    }while (econonomyPlaatsen < 0);

                    do{
                        System.out.println("Vul het aantal beschikbare businessplaatsen in:");
                        businessPlaatsen = input.nextInt();

                        if (businessPlaatsen < 0){
                            System.err.println("Je hebt een ongeldige waarde ingegeven!");
                        }
                    }while (businessPlaatsen < 0);

                    do{
                        System.out.println("Vul het max gewicht per passagier in(in kg):");
                        maxGewicht = input.nextDouble();

                        if (maxGewicht < 0){
                            System.err.println("Je hebt een ongeldige waarde ingegeven!");
                        }
                    }while (maxGewicht < 0);

                    do {
                        System.out.println("Is er al een flightcheck uitgevoerd? (j/n)");
                        vraag = input.next().charAt(0);

                        if (vraag == 'j') {
                            flightCheck = true;
                        }else if (vraag == 'n') {
                            flightCheck = false;
                        }else {
                            System.err.println("Je hebt een ongeldige waarde ingegeven!");
                        }
                    }while (vraag != 'j' && vraag != 'n');

                    Vlucht v = new Vlucht(vluchtcode, beginPlaats, eindBestemming, econonomyPlaatsen, businessPlaatsen, maxGewicht, flightCheck);
                    vluchten.add(v);
                    System.out.println(vluchten);
                    break;
                case 3:
                    System.out.println("Ticket aanmaken");
                    String passagier;
                    String vlucht;
                    String klasse;
                    boolean controleP = false;
                    boolean controleV = false;

                    if (passagiers.isEmpty()){
                        System.err.println("Er zijn geen passagiers gevonden!");
                        break;
                    }else if (vluchten.isEmpty()){
                        System.err.println("Er zijn geen beschikbare vluchten!");
                        break;
                    }

                    System.out.println("Vul de voornaam van de passagier in");

                    do{
                        passagier = input.nextLine();

                        for (Passagier P : passagiers){
                            if (P.getVoornaam().equalsIgnoreCase(passagier)){
                                controleP = true;
                                break;
                            }else {
                                System.err.println("Deze passagier bestaat niet!");//foutmelding verschijnt in begin van loop zonder enige input van gebruiker
                            }
                        }
                    }while (!controleP);

                    System.out.println("Vul de vluchtcode in van de vlucht waar je de passagier op wil plaatsen:");

                    do{
                        vlucht = input.nextLine();

                        for (Vlucht V : vluchten){
                            if (V.getVluchtcode().equalsIgnoreCase(vlucht)){
                                controleV = true;
                                break;
                            }else {
                                System.err.println("Deze vlucht bestaat niet!");
                            }
                        }
                    }while (!controleV);

                    System.out.println("Tot welke klasse behoort de passagier(Business/Economy)?");

                    do{
                        klasse = input.nextLine();

                        if (!Objects.equals(klasse, "Business") && !Objects.equals(klasse, "Economy")){
                            System.err.println("Je hebt een ongeldige klasse ingegeven(Let op hoofdletters)!");
                        }
                    }while (!Objects.equals(klasse, "Business") && !Objects.equals(klasse, "Economy"));

                    Passagier gekozenPassagier = null;
                    for (Passagier P : passagiers) {
                        if (P.getVoornaam().equalsIgnoreCase(passagier)) {
                            gekozenPassagier = P;
                            break;
                        }
                    }

                    Vlucht gekozenVlucht = null;
                    for (Vlucht V : vluchten) {
                        if (V.getVluchtcode().equalsIgnoreCase(vlucht)) {
                            gekozenVlucht = V;
                            break;
                        }
                    }

                    Ticket t = new Ticket(gekozenPassagier, gekozenVlucht, klasse);
                    tickets.add(t);
                    System.out.println(tickets);
                    break;
                case 4:
                    System.out.println("Passagier aan vlucht toevoegen");
                    break;
                case 5:
                    System.out.println("Personeel aan vlucht toewijzen");
                    break;
                case 6:
                    System.out.println("Vlucht info printen");
                    break;
            }
        }while (optie != 7);
    }
}