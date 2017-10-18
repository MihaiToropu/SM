package com.random;

public class MiddleSquare implements GenerateNumber
{

    int seed;
    int _number;

    public MiddleSquare(int Seed)
    {
        seed = Seed;
    }

    @Override
    public int NextSeed()
    {

        seed = (seed * seed) / _pow(10, _number/2) % _pow(10, _number);
        //System.out.println("Random number is: " + seed);

        return seed;
    }

    public int countNumbers(int number)
    {
        int count = 0;
        while (number != 0)
        {
            ++count;
            number = number / 10;
        }

        _number = number;
        return count;
    }

    public int _pow(int x, int n)
    {
        int i;
        int number = 1;

        for (i = 0; i < n; ++i)
            number *= x;

        return(number);
    }
}
