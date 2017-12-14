package petriNet;

public class Arc {

    private int capacitate;
    private Locatie locatie;
    private Directie directie;

    public Arc(int capacitate, Locatie locatie, Directie directie) {
        this.capacitate = capacitate;
        this.locatie = locatie;
        this.directie = directie;
    }


    public Directie getDirectie() {
        return directie;
    }

    public Locatie getLocatie() {
        return locatie;
    }


    public boolean isValid() {
        boolean result = true;
        if (capacitate > locatie.getJetoane()) {
            result = false;
        }
        return result;
    }


    public void update() {
        if (directie == Directie.IN) {
            locatie.setJetoane(locatie.getJetoane() - capacitate);
            System.out.println("Ia jeton din " + locatie.getTag());
        } else {
            System.out.println("Pune jeton la " + locatie.getTag());
            locatie.setJetoane(locatie.getJetoane() + capacitate);
        }
    }

}
