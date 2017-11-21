package MS_LCG;

import java.util.ArrayList;
import java.util.List;

public class Lcg extends Common implements Generator {
    private int seed;
    private int old_seed;
    private int a;
    private int c;
    private int m;
    private int numberOfDigits = 4;

    private List<Float> myFloatList;

    public Lcg(int seed, int a, int c, int m, int numberOfDigits) {
        old_seed = seed;
        this.a = a;
        this.c = c;
        this.m = m;
        this.numberOfDigits = numberOfDigits;
        myFloatList = new ArrayList<Float>();

    }

    @Override
    public List<Float> NextSeed() {
        for (int iterator = 0; iterator < m; iterator++) {
            seed = (a * old_seed + c) % m;
            myFloatList.add(((float) seed * ((float) 1 / _pow(10, numberOfDigits))));
            //System.out.println(seed * (1 / _pow(10, numberOfDigits)));
            old_seed = seed;
        }

        return myFloatList;
    }
}
