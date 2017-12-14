package petriNet;

public class Locatie {

    private String tag;
    private int jetoane;

    public Locatie(String tag, int jetoane) {
        this.tag = tag;
        this.jetoane = jetoane;
    }

    public int getJetoane() {
        return jetoane;
    }

    public String getTag() {
        return tag;
    }

    public void setJetoane(int jetoane) {
        this.jetoane = jetoane;
    }
}
