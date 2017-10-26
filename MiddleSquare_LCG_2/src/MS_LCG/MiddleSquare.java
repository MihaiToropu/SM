package MS_LCG;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import static java.lang.Math.pow;


public class MiddleSquare extends Common implements Generator
{

    private int seed;
    private int _number;
    //int numereGenerate = 10000;
    private int lastSeed;
    private Random rand = new Random();
    TreeMap<String, Integer> tmap =
            new TreeMap<>();


    public MiddleSquare(int seed)
    {
        this.seed = seed;
        //this.numereGenerate = numereGenerate;
    }

    @Override
    public float NextSeed()
    {

        int i = 0;
        int seedNumber = countNumbers(seed);

        if(0 == i){
            lastSeed = seed;
            tmap.put("Data_" + i, lastSeed);
            ++i;
        }



        seed = NextSeed2();

        if (0 == (int) (seed / pow(10, seedNumber - 1))) {//numere care incep cu 0
            seed = (int) (seed + pow(10, seedNumber - 1) * ThreadLocalRandom.current().nextInt(1, 9 + 1));
        }
        if (0 == seed % (seedNumber / 2)){                     //numere care se termina cu (_numberOfNumbers / 2) 0-uri
            seed = seed + ThreadLocalRandom.current().nextInt(1, (int) (pow(10, seedNumber - 1)));
        }
        if (seed == lastSeed) {                //daca ultimele 2 seed-uri sunt egale mutam ultimul seed cu un bit la dreapta in baza 2
            seed = (int)seed >> 1;
        }

        boolean blnExists = tmap.containsValue(seed);

        while (blnExists) {

            //seed = rand.nextInt(_pow(10, seedNumber)-1) + _pow(10, seedNumber-1) ;
            seed = ThreadLocalRandom.current().nextInt(_pow(10, countNumbers(seed)-1), _pow(10, countNumbers(seed)));
            System.out.println(seed);
            /*if (seed == (_pow(10, seedNumber)-1)) {
                seed = seed - ThreadLocalRandom.current().nextInt(1, (int) (pow(10, seedNumber - 1)));
            }
            ++seed;
            seed = (seed * seed) / _pow(10, _number/2) % _pow(10, _number);*/
            blnExists = tmap.containsValue(seed);
        }

        tmap.put("Data_" + ++i, seed);
        //System.out.println("Random number is: " + seed);
        lastSeed = seed;


        /*Set set = tmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());*/
        System.out.println(((float)seed * ((float)1 / _pow(10, countNumbers(seed)))));
        //return (float) (seed * (1 / _pow(10, countNumbers(seed))));
        return  ((float)seed * ((float)1 / _pow(10, countNumbers(seed))));


    }



    public int NextSeed2()
    {

        seed = (seed * seed) / _pow(10, _number/2) % _pow(10, _number);
        //System.out.println("Random number is: " + seed);

        return seed;
    }




}
