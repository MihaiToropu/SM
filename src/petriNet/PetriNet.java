package petriNet;

import java.util.ArrayList;
import java.util.List;

public abstract class PetriNet {

    protected List<Tranzitie> list;
    protected List<Tranzitie> tranzitieValida;

    public PetriNet() {
        list = new ArrayList<Tranzitie>();
        tranzitieValida = new ArrayList<Tranzitie>();
    }


    public abstract void execute(String tranzitie);


    protected void findTranzitieValida() {
        tranzitieValida.clear();
        for(Tranzitie t : list){
            if(t.isValid()){
                tranzitieValida.add(t);
            }
        }
    }
}
