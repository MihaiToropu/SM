package MS_LCG;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DefaultGenerator extends Common implements Generator {

    private int seed;
    private int i = 0;
    private int numereGenerate = 1;
    private List<Float> myFloatList =
            new ArrayList<Float>();

    public DefaultGenerator(int numereGenerate) {
        this.numereGenerate = numereGenerate;
    }

    @Override
    public List<Float> NextSeed() {

        for (int i = 0; i < numereGenerate; i++) {
            seed = ThreadLocalRandom.current().nextInt(1, 10000 + 1);
            myFloatList.add(((float) seed * ((float) 1 / _pow(10, 4))));
        }
        return myFloatList;

    }
}
