import java.util.Scanner;


public class Dialog {

    public int leseInt(){
        Scanner input = new Scanner(System.in);
        int intEingabe = input.nextInt();
        return intEingabe;
    }

    public String leseString(){
        Scanner input = new Scanner(System.in);
        String stringEingabe = input.nextLine();
        return stringEingabe;
    }

    public int leseArtikelNr(){
        System.out.print("Artikelnummer: ");
        int geleseneArtikelNr = leseInt();
        return geleseneArtikelNr;
    }

    public String leseBezeichnung(){
        System.out.print("Bezeichnung: ");
        String geleseneBezeichnung = leseString();
        return geleseneBezeichnung;
    }

    public int leseBestand(){
        System.out.print("Bestand: ");
        int gelesenerBestand = leseInt();
        return gelesenerBestand;
    }

    public int leseMenge(){
        System.out.print("Menge: ");
        int geleseneMenge = leseInt();
        return geleseneMenge;
    }

    public int leseNutzerEingabe(){
        System.out.print("Auswahl: ");
        int geleseneNutzerEingabe = leseInt();
        return geleseneNutzerEingabe;
    }

    public Artikel konstruiereArtikel3(){
        return new Artikel(leseArtikelNr(), leseBezeichnung(), leseBestand());
    }

    public Artikel konstruiereArtikel2(){
        return new Artikel(leseArtikelNr(), leseBezeichnung());
    }

    

    public void start(){
        final int ARTIKELMIT = 1;
        final int ARTIKELOHNE = 2;
        final int ZUBUCHEN = 3;
        final int ABBUCHEN = 4;
        final int SHOWARTIKEL = 5;
        final int BEENDEN = 0;
        Artikel a1 = null;
        int eingabe = -1;

        while(eingabe != BEENDEN){
            System.out.println("Artikel mit Bestand :   " + ARTIKELMIT +
                               "   Artikel ohne Bestand   " + ARTIKELOHNE +
                               "   Bestand zubuchen   " + ZUBUCHEN +
                               "   Bestand abbuchen   " + ABBUCHEN +
                               "   Artikel anzeigen   " + SHOWARTIKEL +
                               "   Beenden   " + BEENDEN);  
            try {
                eingabe = leseNutzerEingabe();
                if(eingabe == ARTIKELMIT){
                a1 = konstruiereArtikel3();
                } else if (eingabe == ARTIKELOHNE){
                a1 = konstruiereArtikel2();
                } else if (eingabe == ZUBUCHEN){
                    if(a1 != null){
                        a1.bucheZugang(leseMenge());
                    } else {
                        throw new IllegalStateException("Kein Artikel vorhanden");
                    }
                } else if (eingabe == ABBUCHEN){
                    if(a1 != null){
                        a1.bucheAbgang(leseMenge());
                    } else {
                        throw new IllegalStateException("Kein Artikel vorhanden");
                    }
                } else if(eingabe == SHOWARTIKEL){
                    if(a1 != null){
                        System.out.println(a1);
                    } else {
                        throw new IllegalStateException("Kein Artikel vorhanden");
                    }
                } else if(eingabe == BEENDEN){
                    return;
                } else if(eingabe > 6){
                    throw new IllegalStateException("Keine Funktion mit der Nummer vorhanden");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public static void main(String[] args) {
        new Dialog().start();
    }
}

