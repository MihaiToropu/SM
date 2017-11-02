package MS_LCG;

import java.util.ArrayList;
import java.util.List;

public class Binomial {


    private int n;
    private double p;
    private Generator a;
    private int x = 0;
    private float u;
    private List<Float> myFloatList =
            new ArrayList<Float>();


    public Binomial(double p, int n, Generator a) {
        this.p = p;
        this.n = n;
        this.a = a;
        myFloatList = a.NextSeed();
    }


    public float Random() {
        for (int i = 0; i <= n - 1; ++i) {
            u = myFloatList.get(i);
            if (u < p)
                x++;
        }
        float y = (float) x / n;
        return y;
    }
}
