package MS_LCG;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.pow;


public class MiddleSquare extends Common implements Generator {

    int x = 0;       //used for do while
    private int seed;
    private int lastSeed;
    private int cifreDe0 = 0;
    private int seedNumber;
    private int numereGenerate = 1;
    private int samallestSeedPossible;
    private int biggestSeedPossible;
    private int value = 1;          //value of treemap


    private static TreeMap<Integer, Integer> tmap;

    private List<Integer> myList;

    private List<Float> myFloatList;

    public MiddleSquare(int seed, int numereGenerate) {
        this.seed = seed;
        lastSeed = seed;
        tmap = new TreeMap<Integer, Integer>();
        myList = new ArrayList<Integer>();
        myFloatList = new ArrayList<Float>();
        this.numereGenerate = numereGenerate;
        seedNumber = countNumbers(seed);
        samallestSeedPossible = _pow(10, seedNumber - 1);
        biggestSeedPossible = _pow(10, seedNumber) - 1;
        x = 0;
        value = 1;
        cifreDe0 = 0;

    }


    @Override
    public List<Float> NextSeed() {


        do {
            if (0 == x) {
                tmap.put(seed, value);       //put first seed in treemap
                myList.add(seed);
                //System.out.println(seed);
            }

            seed = NextSeed2();

            if (seed == lastSeed) {
                do {
                    ++seed;
                } while (seed == lastSeed);
            }

            if (0 == (int) (seed % pow(10, seedNumber))) {  //if number is 0 generate a new seed
                seed = ThreadLocalRandom.current().nextInt(_pow(10, seedNumber - 1), _pow(10, seedNumber));  //new seed
            }

            int temp = seed;
            if (samallestSeedPossible > seed) {//numbers which starts with 0
                do {
                    cifreDe0++;
                    temp *= 10;
                } while (temp < samallestSeedPossible);
                temp = rotateSeedtoLeft(lastSeed, cifreDe0);
                if (temp > biggestSeedPossible) {
                    do {
                        temp /= 10;
                    } while (temp > biggestSeedPossible);
                }
                seed = temp;
            }

            boolean blnExists = tmap.containsKey(seed);   //check if the treemap contains the seed

            while ((blnExists && (value % 2 == 0)) || (blnExists && (value < (int) (0.5 * numereGenerate)))) {
                if (seed == (_pow(10, seedNumber) - 1)) {
                    seed = ThreadLocalRandom.current().nextInt(_pow(10, seedNumber - 1), _pow(10, seedNumber));  //new seed
                } else {
                    ++seed;
                }
                blnExists = tmap.containsKey(seed);
            }
            myList.add(seed);
            tmap.put(seed, value);


            //System.out.println(seed);
            lastSeed = seed;
            x++;
            value++;

        } while (x < numereGenerate);

        /*Set set = tmap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            //System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getKey());
            //System.out.println(mentry.getValue());
        }*/

        for (Integer integer : myList) {
            myFloatList.add(((float) integer * ((float) 1 / _pow(10, countNumbers(integer)))));
        }


        return myFloatList;
        //return ((float) seed * ((float) 1 / _pow(10, countNumbers(seed))));

    }

    public List<Integer> getNumbers() {
        return myList;
    }

    public int NextSeed2() {

        seed = (seed * seed) / _pow(10, seedNumber / 2) % _pow(10, seedNumber);

        return seed;
    }
}