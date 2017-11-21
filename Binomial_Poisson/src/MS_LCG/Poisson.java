package MS_LCG;

import java.util.ArrayList;
import java.util.List;

public class Poisson {

    private double _Lambda = 25;
    private int k = 0;
    private Generator g;
    private float p;
    private float u;
    private int n;
    private int iterator = 0;
    private double L = Math.exp(-_Lambda);
    private List<Float> myFloatList =
            new ArrayList<Float>();

    public Poisson(float p, int n, Generator g) {
        this.p = p;
        this.n = n;
        this.g = g;
        myFloatList = g.NextSeed();
    }

    public List<Float> getMyFloatList() {
        return myFloatList;
    }

    public int RandomPoisson() {
        do {
            k++;
            u = myFloatList.get(iterator);
            p = p * u;
            ++iterator;
            //System.out.println("p " + p + " > L " + L );
        } while ((p > L) && (k < n));
        return k - 1;

    }
}
