package petriNet;

import java.util.List;

public class Tranzitie {
    protected List<Arc> list;
    private String tag;


    public Tranzitie(String tag, List<Arc> list){
        this.tag = tag;
        this.list = list;
    }


    public boolean isValid() {
        boolean result = true;

        for (Arc a : list) {
            if(a.getDirectie() == Directie.IN){
                if(a.isValid() == false) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public String getTag() {
        return tag;
    }


    public void tranzitie(String tranzitie){
        for(Arc a : list){
            a.update();
        }
    }
}
