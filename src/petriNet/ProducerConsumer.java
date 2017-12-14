package petriNet;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer extends PetriNet {

    public ProducerConsumer() {
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
        Locatie p = new Locatie("p", 1);
        Locatie prodReady = new Locatie("prodReady", 0);
        Locatie c = new Locatie("c", 1);
        Locatie consReady = new Locatie("consReady", 0);
        Locatie mutex = new Locatie("mutex", 1);
        Locatie empty = new Locatie("empty", 1);
        Locatie full = new Locatie("full", 0);
        List<Arc> l = new ArrayList<Arc>();

        l.add(new Arc(1, p, Directie.IN));
        l.add(new Arc(1, prodReady, Directie.OUT));
        list.add(new Tranzitie("produce", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(1, prodReady, Directie.IN));
        l.add(new Arc(1, p, Directie.OUT));
        l.add(new Arc(1, empty, Directie.IN));
        l.add(new Arc(1, mutex, Directie.IN));
        l.add(new Arc(1, mutex, Directie.OUT));
        l.add(new Arc(1, full, Directie.OUT));
        list.add(new Tranzitie("push", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(1, full, Directie.IN));
        l.add(new Arc(1, mutex, Directie.IN));
        l.add(new Arc(1, mutex, Directie.OUT));
        l.add(new Arc(1, empty, Directie.OUT));
        l.add(new Arc(1, consReady, Directie.OUT));
        l.add(new Arc(1, c, Directie.IN));
        list.add(new Tranzitie("pop", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(1, consReady, Directie.IN));
        l.add(new Arc(1, c, Directie.OUT));
        list.add(new Tranzitie("consume", new ArrayList<>(l)));
        l.clear();
    }
}
