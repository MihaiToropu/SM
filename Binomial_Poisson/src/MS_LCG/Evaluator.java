package MS_LCG;

import java.util.ArrayList;
import java.util.List;

public class Evaluator {

    private int count;  //numarul de puncte din sfertul de cerc
    private final double pi = 3.14;
    private int nrPctPatrat = 10000;
    private Generator a;
    private List<Float> myFloatListX =
            new ArrayList<Float>();
    private List<Float> myFloatListY =
            new ArrayList<Float>();

    public Evaluator(int nrPctPatrat, Generator a) {
        this.nrPctPatrat = nrPctPatrat;
        this.a = a;
        myFloatListX = a.NextSeed();
        myFloatListY = a.NextSeed();
    }


    public float accuracy() {
        float x;
        float y;
        float accuracy;

        for (int i = 0; i < nrPctPatrat; ++i) {
            x = myFloatListX.get(i);
            //System.out.println("x = " + x);
            y = myFloatListY.get(i);
            //System.out.println("y = " + y);

            if (x * x + y * y <= 1) {
                count++;
            }
        }

        accuracy = (count / 2500.0f);
        return (float)pi-accuracy;

    }
}
