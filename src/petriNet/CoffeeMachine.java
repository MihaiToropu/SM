package petriNet;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine extends PetriNet {

    public CoffeeMachine() {
        init();
    }

    @Override
    public void execute(String tranzitie) {
        findTranzitieValida();
        for (Tranzitie t : list) {
            if(t.getTag() == tranzitie && tranzitieValida.contains(t)){
                t.tranzitie(tranzitie);
            }
        }
    }


    private void init() {
        Locatie b0 = new Locatie("0b", 1);
        Locatie b5 = new Locatie("5b", 0);
        Locatie b10 = new Locatie("10b", 0);
        Locatie b15 = new Locatie("15b", 0);
        Locatie b20 = new Locatie("20b", 0);

        List<Arc> l = new ArrayList<Arc>();
        l.add(new Arc(1, b0, Directie.IN));
        l.add(new Arc(1, b5, Directie.OUT));
        list.add(new Tranzitie("5b", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(1, b0, Directie.IN));
        l.add(new Arc(1, b10, Directie.OUT));
        list.add(new Tranzitie("10b", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(1, b5, Directie.IN));
        l.add(new Arc(1, b10, Directie.OUT));
        list.add(new Tranzitie("5b", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(1, b5, Directie.IN));
        l.add(new Arc(1, b15, Directie.OUT));
        list.add(new Tranzitie("10b", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(1, b10, Directie.IN));
        l.add(new Arc(1, b15, Directie.OUT));
        list.add(new Tranzitie("5b", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(1, b10, Directie.IN));
        l.add(new Arc(1, b20, Directie.OUT));
        list.add(new Tranzitie("10b", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(1, b15, Directie.IN));
        l.add(new Arc(1, b20, Directie.OUT));
        list.add(new Tranzitie("5b", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(1, b15, Directie.IN));
        l.add(new Arc(1, b0, Directie.OUT));
        list.add(new Tranzitie("c15", new ArrayList<>(l)));
        l.clear();

        l.add(new Arc(1, b20, Directie.IN));
        l.add(new Arc(1, b0, Directie.OUT));
        list.add(new Tranzitie("c20", new ArrayList<>(l)));
        l.clear();
    }
}
