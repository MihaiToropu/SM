package MS_LCG;

public class Lcg extends Common implements Generator
{
    private int seed;
    private int old_seed;
    private int a;
    private int c;
    private int m;
    private int numberOfDigits;
    public Lcg(int seed, int a, int c, int m, int numberOfDigits)
    {
        old_seed = seed;
        this.a = a;
        this.c = c;
        this.m = m;
        this.numberOfDigits = numberOfDigits;


    }
    @Override
    public float NextSeed() {

        seed = (a * old_seed + c) % m;
        //System.out.println(seed * (1 / _pow(10, numberOfDigits)));
        old_seed = seed;

        return  ((float)seed * ((float)1 / _pow(10, numberOfDigits)));
    }
}
