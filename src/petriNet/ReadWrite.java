package petriNet;

import java.util.ArrayList;
import java.util.List;

public class ReadWrite extends PetriNet {
    private int k;  //workeri

    public ReadWrite(int k) {
        this.k = k;
        init();
    }


    @Override
    public void execute(String tranzitie) {
        findTranzitieValida();
        for (Tranzitie t : list) {
            if (t.getTag() == tranzitie && tranzitieValida.contains(t)) {
                t.tranzitie(tranzitie);
            }
        }
    }


    private void init() {
        Locatie first = new Locatie("first", k);
        Locatie reading = new Locatie("reading", 0);
        Locatie writing = new Locatie("writing", 0);
        List<Arc> l = new ArrayList<Arc>();

        l.add(new Arc(1 , first, Directie.IN));
        l.add(new Arc(1, reading, Directie.OUT));
        list.add(new Tranzitie("StartReading", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(1, reading, Directie.IN));
        l.add(new Arc(1, first, Directie.OUT));
        list.add(new Tranzitie("StopReading", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(k, first, Directie.IN));
        l.add(new Arc(k, writing, Directie.OUT));
        list.add(new Tranzitie("StartWriting", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(k, writing, Directie.IN));
        l.add(new Arc(k, first, Directie.OUT));
        list.add(new Tranzitie("StopWriting", new ArrayList<>(l)));
        l.clear();
    }
}
