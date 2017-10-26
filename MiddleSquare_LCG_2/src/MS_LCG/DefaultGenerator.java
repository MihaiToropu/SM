package MS_LCG;

import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class DefaultGenerator extends Common implements Generator {

    private int seed;
    private int i = 0;



    @Override
    public float NextSeed() {



        seed = ThreadLocalRandom.current().nextInt(1, 10000 + 1);


        return  ((float)seed * ((float)1 / _pow(10, 4)));

    }
}
