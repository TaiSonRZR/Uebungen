/**
 * PatientenWarteschlange
 */
public class Patient {
    private int pnr;
    private String name;


    public Patient (int pnr, String name){
        if(pnr < 1000 || pnr >= 10000 ){
            throw new IllegalStateException("Patientennummer ist nicht 4 stellig");
        }
        this.pnr = pnr;

        if(name == null){
            throw new IllegalStateException("Name ist null");
        }
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPnr(){
        return pnr;
    }


}