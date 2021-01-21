public class Artikel {
    private int artikelNr;
    private String art;
    private int bestand;
    private double preis;
    
    public void bucheAbgang(int menge){
        if(menge < 0){
            throw new IllegalStateException("Menge ist kleiner 0");
        }
        setBestand(bestand -= menge);
    }

    public void bucheZugang(int menge){
        if(menge >= 0){
            setBestand(bestand += menge);
        } else {
            throw new IllegalStateException("Menge ist kleiner 0");
        }
    }

    public int getArtikelNr(){
        return artikelNr;
    }
    
    public String getBezeichnung(){
        return art;
    }

    public int getBestand(){
        return bestand;
    }
    
    public double getPreis(){
        return preis;
    }

    public void setBestand(int bestandNeu){
        if(bestand >= 0){
            bestand = bestandNeu;
        } else {
            throw new IllegalStateException("Bestand ist kleiner 0");
        }
    }
    
    public void setPreis(double neuerPreis){
        if (preis < 0){
            throw new IllegalStateException();
        } else {
            preis = neuerPreis;
        }
    }

    public void aenderePreis(double prozent){
        if(prozent == 0.0){
            throw new IllegalStateException("Preisänderung ist 0%");
        } else {
            preis = preis * prozent;
        }
    }

    @Override
    public String toString(){
        return "Artikelnummer: " + artikelNr + "   Bezeichnung: " + art + "   Bestand: " + bestand + "  Preis: " + preis;
    }


    public Artikel(int artikelNr, String art, int bestand){
        if (artikelNr < 10000 && artikelNr > 999){
            this.artikelNr = artikelNr;
        } else {
            throw new IllegalStateException("Artikelnummer ist nicht vierstellig");
        }
        if (art != null){
            this.art = art;
        } else {
            throw new IllegalStateException("Die Bezeichnung ist null");
        }
        setBestand(bestand);
    }

    public Artikel(int artikelNr, String art, int bestand, double preis){
        if (artikelNr < 10000 && artikelNr > 999){
            this.artikelNr = artikelNr;
        } else {
            throw new IllegalStateException("Artikelnummer ist nicht vierstellig");
        }
        if (art != null){
            this.art = art;
        } else {
            throw new IllegalStateException("Die Bezeichnung ist null");
        }
        setBestand(bestand);

        setPreis(preis);
        
    }

    public Artikel(int artikelNr, String art){
        this(artikelNr, art, 0);
    }


}
