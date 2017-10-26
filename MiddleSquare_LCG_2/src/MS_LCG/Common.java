package MS_LCG;

public class Common {

    private int _number;

    public int _pow(int x, int n)
    {
        int i;
        int number = 1;

        for (i = 0; i < n; ++i)
            number *= x;

        return(number);
    }


    public int countNumbers(int seed)
    {
        int count = 0;
        while (seed != 0)
        {
            ++count;
            seed = seed / 10;
        }

        _number = (int)seed;
        return count;
    }

}
