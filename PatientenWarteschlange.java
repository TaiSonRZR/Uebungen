public class PatientenWarteschlange {
    private Patient[] pw;

    public PatientenWarteschlange(int groesse) {
        if (groesse > 10) {
            throw new IllegalStateException("Warteschlanger ist größer als 10");
        }
        pw = new Patient[groesse];
    }

    public void neuerPatient(int pnr, String name) {
        if (schlangeVoll() == true) {
            throw new IllegalStateException("Schlange voll");
        }
        for (int i = 0; i < pw.length; i++) {
            if (pw[i] == null) {
                pw[i] = new Patient(pnr, name);
                return;
            }
        }
    }

    public String entfernePatient(int pnr) {
        String s = "Patient gelöscht: ";
        for (int i = 0; i < pw.length; i++) {
            if (pw[i] != null && pw[i].getPnr() == pnr) {
                s += pw[i].getPnr() + "\t" + pw[i].getName();
                pw[i] = null;
                return s;
            }
            // if (pw[i] != null && pw[i].getPnr() == pnr && getLaengeSchlange() != 0) {
            // // pw[i] = null;
            // pw[i] = pw[getLaengeSchlange()];
            // if(pw[i] == null){
            // throw new IllegalStateException("Ungültiger Wert für pw[i]");
            // }
            // s += pw[i].getPnr() + "\t" + pw[i].getName();
            // pw[getLaengeSchlange()] = null;
            // //return "Patient gelöscht: " + pw[i].getPnr() + "\t" + pw[i].getName();
            // //return "Patient gelöscht: ";
            // return s;
            // }
        }
        return "Patient nicht gefunden";
    }

    public Patient derNaechsteBitte() {
        if (pw[0] == null) {
            throw new IllegalStateException("Kein Patient vorhanden");
        }
        return pw[0];
        // String s = "Nächster Patient: ";
        // if (pw[0] == null) {
        // return "Kein Patient in der Warteschlange";
        // }
        // s += pw[0].getPnr() + "\t" + pw[0].getName();
        // return s;

    }

    public Boolean schlangeVoll() {
        for (int i = 0; i < pw.length; i++) {
            if (pw[i] == null) {
                return false;
            }
        }
        return true;
    }

    public int getLaengeSchlange() {
        for (int i = 0; i < pw.length; i++) {
            if (pw[i] == null) {
                return i - 1;
            }
        }
        return -1;
    }

    public String toString() {
        String s = "Wartliste\n";
        s += "\tPnr\tName\n";
        // if (pw[0] != null) {
        // s += pw[0].getPnr() + "\t" + pw[0].getName();
        // }
        for (int i = 0; i < pw.length; i++) {
            if (pw[i] != null) {
                s += i + "\t" + pw[i].getPnr() + "\t" + pw[i].getName() + "\n";
                // } else {
                // s += i + "\t" + "Warteliste Position " + i + " ist null\n";
            }
        }
        return s;
        // return ("Warteliste\nPnr\tName\n");
    }

    public static void main(String[] args) {
        PatientenWarteschlange pw = new PatientenWarteschlange(10);

        pw.neuerPatient(4711, "Löw, Jogi"); // Neuen Patient anfügen
        pw.neuerPatient(1234, "Kroos, Toni");
        pw.neuerPatient(1111, "Neuer, Manuel");
        pw.neuerPatient(2222, "Gnabry, Serge");
        System.out.println(pw); // Warteschlange ausgeben
        System.out.println(pw.entfernePatient(1111)); // Patient entfernen
        Patient naechster = pw.derNaechsteBitte(); // nächsten Patient herausholen
        System.out.println("Nächster Patient: " + naechster);
        System.out.println(pw);
    }
}
