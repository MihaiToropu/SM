package com.random;

public class LCG implements GenerateNumber
{
    int Seed;
    int old_seed;
    int _a;
    int _c;
    int _m;

    public LCG(int $seed, int $a, int $c, int $m)
    {
        old_seed = $seed;
        _a = $a;
        _c = $c;
        _m = $m;
    }
    @Override
    public int NextSeed() {

        Seed = (_a * old_seed + _c) % _m;
        System.out.println(Seed);
        old_seed = Seed;

        return Seed;
    }
}
