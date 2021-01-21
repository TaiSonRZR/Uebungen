public class Lager {

    private Artikel[] lager;


    public Lager(int dimension){
        if(dimension < 0){
            throw new IllegalArgumentException();
        } else {
            lager = new Artikel[dimension];
        }
    }

    public Lager(){
        lager = new Artikel[10];
    }

    public int pruefIndex(){
        for(int i = 0; i < lager.length ; i++){
            if (lager[i] == null){
                return i;
            }
        }
            throw new IllegalArgumentException();
    }


    public void legeAnArtikel(Artikel artikel){
        try {
            if (artikel != null) {
                lager[pruefIndex()] = artikel;    
            } else {
                throw new IllegalStateException("Kein Artikel vorhanden.");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void entferneArtikel(int artikelNr){
        for(int i = 0; i < lager.length; i++){
            if(lager[i].getArtikelNr() == artikelNr){
                lager[i] = null;
            }
        }
    }

    public void bucheZugang(int artikelNr, int menge){
        for(int i = 0; i < lager.length; i++){
            if(lager[i].getArtikelNr() == artikelNr){
                lager[i].bucheZugang(menge);
            }
        }
    }

    public void bucheAbgang(int artikelNr, int menge){
        for(int i = 0; i < lager.length; i++){
            if(lager[i].getArtikelNr() == artikelNr){
                lager[i].bucheAbgang(menge);;
            }
        }
    }

    public void aenderePreisAllerArtikel(double prozent){
        for(int i = 0; i < lager.length; i++){
            if(lager[i] != null){
                lager[i].aenderePreis(prozent);
            }
        }
    }



    public int getArtikelAnzahl(){
        for(int i = 0; i < lager.length; i++){
            if(lager[i] == null){
                return i;
            }
        }
        return -1;
    }

    public int getLagerGroesse(){
        int i = lager.length;
        return i;
    }

}
