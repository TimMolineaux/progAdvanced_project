import Classes.Passagier;
import Classes.Ticket;
import Classes.Vlucht;
import Lijsten.Bestemmingen;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //optie krijgt waarde van scanner toegewezen
        //optie wordt gebruikt voor hoofdmenu keuze
        int optie;

        //lijsten die gemaakte objecten bevatten
        ArrayList<Passagier> passagiers = new ArrayList<>();
        ArrayList<Vlucht> vluchten = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();

        //main loop voor programma zodat gebruike pas stopt bij invoer van gebruiker
        do {
            //loop om te checken of je een correcte optie ingeeft
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

                //foutmelding indien foute optie
                if (optie <= 0 || optie > 7) {
                    System.err.println("Je hebt een ongeldige waarde ingegeven!");
                }
            }while (optie <= 0 || optie > 7);

            //switch die ingegeven functie zal uitvoeren
            switch (optie) {
                //functie om nieuwe passagier aan te maken
                case 1:
                    System.out.println("Passagier aanmaken");
                    String voornaam;
                    String achternaam;
                    LocalDate geboortedatum = LocalDate.now();
                    String adress;
                    double bagage;

                    System.out.println("Vul de voornaam in:");
                    //inputloop
                    do {
                        voornaam = input.nextLine();
                    }while (Objects.equals(voornaam, ""));

                    System.out.println("Vul de achternaam in:");
                    //inputloop
                    do {
                        achternaam = input.nextLine();
                    }while (Objects.equals(achternaam, ""));

                    System.out.println("Vul de geboortedatum in in(jjjj-mm-dd):");
                    //inputloop
                    do {
                        //try catch blok indien je datum fout ingeeft
                        try {
                            geboortedatum = LocalDate.parse(input.nextLine());
                        }catch (DateTimeParseException e) {
                            System.err.println("Je hebt een ongeldige datum ingegeven!");
                        }
                    } while (Objects.equals(geboortedatum, LocalDate.now()));

                    System.out.println("Vul het adress in:");
                    //inputloop
                    do {
                        adress = input.nextLine();
                    }while (Objects.equals(achternaam, ""));

                    System.out.println("Vul het gewicht van de bagage in(kg):");
                    //inputloop
                    do {
                        bagage = input.nextDouble();
                    }while (bagage < 0);
                    //aanmaken nieuw object gebaseerd op input van gebruiker
                    Passagier p = new Passagier(voornaam, achternaam, geboortedatum, adress, bagage);
                    //object aan lijst toevoegen
                    passagiers.add(p);

                    break;
                //functie om vlucht aan te maken
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
                    //inputloop
                    do{
                        vluchtcode = input.nextLine();
                    }while (Objects.equals(vluchtcode, ""));
                    //inputloop voor beginplaats
                    do{
                        System.out.println("Vul de beginplaats in(typ 'opties' om alle geldige plaatsen te zien):");
                        beginPlaats = input.nextLine();

                        //chekt voor specifieke userinput
                        if (Objects.equals(beginPlaats, "opties")) {
                            //laat inhoud van de enum met mogelijke plaatsen zien
                            for (Bestemmingen b : Bestemmingen.values()) {
                                System.out.println(b);
                            }
                        }else{
                            //try catch blok indien gebruiker ongeldige plaats ingeeft
                            try {
                                //checkt of ingegeven plaats in de enum staat
                                Bestemmingen plaats = Bestemmingen.valueOf(beginPlaats);
                                break;
                            }catch (IllegalArgumentException e){
                                //foutmelding indien ingegeven waarde niet in de enum staat
                                System.err.println("Je hebt een ongeldige plaats ingegeven!");
                            }
                        }
                    }while (true);

                    //inputloop voor eindbestemming
                    do{
                        System.out.println("Vul de eindbestemming in(typ 'opties' om alle geldige plaatsen te zien):");
                        eindBestemming = input.nextLine();
                        //checkt voor specifieke userinput
                        if (Objects.equals(eindBestemming, "opties")) {
                            //laat inhoud van enum met mogelijke plaatsen zien
                            for (Bestemmingen b : Bestemmingen.values()) {
                                System.out.println(b);
                            }
                        }else{
                            //try catch blok indien gebruiker ongeldige plaats ingeeft
                            try {
                                //checkt of ingegeven plaats in de enum staat
                                Bestemmingen plaats = Bestemmingen.valueOf(eindBestemming);

                                //checkt of beginplaats dezelfde is als eindbestemming
                                if (Objects.equals(beginPlaats, eindBestemming)) {
                                    System.err.println("De beginplaats kan niet dezelfde zijn als de einbestemming!");
                                }else{
                                    break;
                                }
                            }catch (IllegalArgumentException e){
                                //foutmelding indien ingegeven waarde niet in de enum staat
                                System.err.println("Je hebt een ongeldige plaats ingegeven!");
                            }
                        }
                    }while (true);

                    //inputloop
                    do{
                        System.out.println("Vul het aantal beschikbare economyplaatsen in:");
                        econonomyPlaatsen = input.nextInt();

                        if (econonomyPlaatsen < 0){
                            System.err.println("Je hebt een ongeldige waarde ingegeven!");
                        }
                    }while (econonomyPlaatsen < 0);

                    //inputloop
                    do{
                        System.out.println("Vul het aantal beschikbare businessplaatsen in:");
                        businessPlaatsen = input.nextInt();

                        if (businessPlaatsen < 0){
                            System.err.println("Je hebt een ongeldige waarde ingegeven!");
                        }
                    }while (businessPlaatsen < 0);

                    //input
                    do{
                        System.out.println("Vul het max gewicht per passagier in(in kg):");
                        maxGewicht = input.nextDouble();

                        if (maxGewicht < 0){
                            System.err.println("Je hebt een ongeldige waarde ingegeven!");
                        }
                    }while (maxGewicht < 0);

                    //inputloop
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
                    //maakt nieuw object aan met ingegeven waardan van gebruiker
                    Vlucht v = new Vlucht(vluchtcode, beginPlaats, eindBestemming, econonomyPlaatsen, businessPlaatsen, maxGewicht, flightCheck);
                    //plaatst object in list
                    vluchten.add(v);
                    break;
                //functie om tickets aan te maken
                case 3:
                    System.out.println("Ticket aanmaken");
                    String passagier;
                    String vlucht;
                    String klasse;
                    Passagier gekozenPassagier = null;
                    Vlucht gekozenVlucht = null;

                    //controleert of er wel passagiers/vluchten in de lijsten staan
                    if (passagiers.isEmpty()){
                        System.err.println("Er zijn geen passagiers gevonden!");
                        break;
                    }else if (vluchten.isEmpty()){
                        System.err.println("Er zijn geen beschikbare vluchten!");
                        break;
                    }

                    System.out.println("Vul de voornaam van de passagier in");

                    //inputloop
                    do{
                        passagier = input.nextLine();

                        //checkt of de ingegeven naam in de lijst staat
                        for (Passagier P : passagiers){
                            if (P.getVoornaam().equalsIgnoreCase(passagier)){
                                gekozenPassagier = P;
                                break;
                            }else {
                                //foutmelding als de ingegeven naam niet in de lijst staat
                                System.err.println("Deze passagier bestaat niet!");
                            }
                        }
                    }while (gekozenPassagier == null);

                    System.out.println("Vul de vluchtcode in van de vlucht waar je de passagier op wil plaatsen:");

                    //inputloop
                    do{
                        vlucht = input.nextLine();

                        //checkt of vluchtcode in de lijst staat
                        for (Vlucht V : vluchten){
                            if (V.getVluchtcode().equalsIgnoreCase(vlucht)){
                                gekozenVlucht = V;
                                break;
                            }else {
                                //foutmelding als input niet in de lijst staat
                                System.err.println("Deze vlucht bestaat niet!");
                            }
                        }
                    }while (gekozenVlucht == null);

                    System.out.println("Tot welke klasse behoort de passagier(Business/Economy)?");

                    //inputloop
                    do{
                        klasse = input.nextLine();

                        //chekt of ingegeven waarde geldig is
                        if (!Objects.equals(klasse, "Business") && !Objects.equals(klasse, "Economy")){
                            System.err.println("Je hebt een ongeldige klasse ingegeven(Let op hoofdletters)!");
                        }
                    }while (!Objects.equals(klasse, "Business") && !Objects.equals(klasse, "Economy"));

                    //maak nieuw object aan met ingegeven waardes
                    Ticket t = new Ticket(gekozenPassagier, gekozenVlucht, klasse);
                    //voegt ticket toe aan lijst
                    tickets.add(t);
                    break;
                //functie om passagier op een vlucht te plaatsen
                case 4:
                    System.out.println("Passagier aan vlucht toevoegen");
                    String passagier2;
                    Ticket gekozenTicket = null;

                    //checkt of er wel passagiers of vluchten zijn
                    if (passagiers.isEmpty()){
                        System.err.println("Er zijn geen passagiers gevonden!");
                        break;
                    }else if (vluchten.isEmpty()){
                        System.err.println("Er zijn geen beschikbare vluchten!");
                        break;
                    }

                    System.out.println("Vul de voornaam in van de passagier die je op de vlucht wil plaatsen:");

                    //inputloop
                    do{
                        passagier2 = input.nextLine();

                        //checkt of ingegeven naam een ticket heeft
                        for (Ticket T : tickets){
                            if (T.getPassagier().getVoornaam().equalsIgnoreCase(passagier2)) {
                                gekozenTicket = T;
                                break;
                            }else {
                                //foutmelding als er geen ticket is met de ingegeven naam
                                System.err.println("Deze passagier bestaat niet!");
                            }
                        }
                    }while (gekozenTicket == null);

                    //haal ref. naar vlucht en voegen hieraan het ticket toe
                    gekozenTicket.getVlucht().voegPassagierToe(gekozenTicket);

                    break;
                case 5:
                    System.out.println("Personeel aan vlucht toewijzen");
                    System.err.println("Sorry, deze functionaliteit is momenteel niet beschikbaar!");
                    break;
                //Functie om passagierslijst van een vlucht op een .txt file te zetten
                case 6:
                    System.out.println("Vlucht info printen");
                    String vInput;
                    Vlucht vluchtCode = null;

                    System.out.println("Vul de vluchtcode in van de vlucht waar je een lijst van wilt:");

                    //inputloop
                    do{
                        vInput = input.nextLine();

                        //check of vluchtcode bestaat
                        for (Vlucht V : vluchten){
                            if (V.getVluchtcode().equalsIgnoreCase(vInput)){
                                vluchtCode = V;
                                break;
                            }else {
                                //foutmelding indien vluchtcode niet bestaat
                                System.err.println("Deze vlucht bestaat niet!");
                            }
                        }
                    }while (vluchtCode == null);

                    //maak file aan om lijst op te plaatsen
                    File vluchtInfo = new File("C:\\Users\\timmo\\IdeaProjects\\progAdvanced\\Luchthaven\\vlucht_info.txt");

                    //plaatst de passagierslijst op de .txt file
                    try(FileWriter fileWriter = new FileWriter(vluchtInfo)) {
                        FileWriter writer = new FileWriter(vluchtInfo);

                        //kopieer alle passagiers naar lijst
                        ArrayList<Passagier> lijst = vluchtCode.getPassagiers();
                        //loopt over elke passagier en plaatst deze in het bestand
                        for (Passagier P : lijst){
                            writer.write(P.getVoornaam() + ' ' + P.getAchternaam() + "\n");
                        }
                        writer.close();
                    }catch (IOException e){
                        //foutmelding indien er iets misgaat met bewerken van bestand
                        System.err.println("Bestand kan niet aangemaakt worden");
                    }
                    break;
            }
        //sluit het programma af
        }while (optie != 7);
    }
}