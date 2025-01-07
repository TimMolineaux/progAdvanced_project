import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int optie = 0;
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
                    break;
                case 2:
                    System.out.println("Vlucht aanmaken");
                    break;
                case 3:
                    System.out.println("Ticket aanmaken");
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