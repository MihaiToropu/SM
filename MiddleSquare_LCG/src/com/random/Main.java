package com.random;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {

        int _numberOfNumbers;
        int _LastSeed;

        int seedLcg;
        int a;
        int c;
        int m;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Alege: ");
        System.out.println("1. MiddleSquare: ");
        System.out.println("2. LCG: ");
        int alege = scanner.nextInt();

        Scanner scannerMS = new Scanner(System.in);
        System.out.println("Cate numere random doriti sa generati? ");
        int MS = scannerMS.nextInt();

        switch (alege)
        {
            case 1:

            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Introduceti seed: ");
            int _seed = scanner2.nextInt();



            MiddleSquare mso = new MiddleSquare(_seed);
            _numberOfNumbers = mso.countNumbers(_seed);
            _seed = mso.NextSeed();


            if (0 == (int) (_seed / pow(10, _numberOfNumbers - 1)))                                                                       //numere care incep cu 0
                _seed = (int) (_seed + pow(10, _numberOfNumbers - 1) * ThreadLocalRandom.current().nextInt(1, 9 + 1));
            if (0 == _seed % (_numberOfNumbers / 2))                                                                                     //numere care se termina cu (_numberOfNumbers / 2) 0-uri
                _seed = _seed + ThreadLocalRandom.current().nextInt(1, (int) (pow(10, _numberOfNumbers - 1)));
            System.out.println("Random number is: " + _seed);
            _LastSeed = _seed;



            while (MS != 0) {

                        MiddleSquare mso2 = new MiddleSquare(_seed);
                        _seed = mso2.NextSeed();
                        if (0 == (int) (_seed / pow(10, _numberOfNumbers - 1)))
                            _seed = (int) (_seed + pow(10, _numberOfNumbers - 1) * ThreadLocalRandom.current().nextInt(1, 9 + 1));
                        if (0 == _seed % (_numberOfNumbers / 2))
                            _seed = _seed + ThreadLocalRandom.current().nextInt(1, (int) (pow(10, _numberOfNumbers - 1)));
                        if (_seed == _LastSeed)                                             //daca ultimele 2 seed-uri sunt egale mutam ultimul seed cu un bit la dreapta in baza 2
                            _seed = _seed >> 1;
                        _LastSeed = _seed;
                        System.out.println("Random number is: " + _seed);
                       --MS;
                }
            break;

            case 2:

                Scanner scannerSeedLCG = new Scanner(System.in);
                System.out.println("Introduceti seedLcg: ");
                seedLcg = scannerSeedLCG.nextInt();

                Scanner scanner_a = new Scanner(System.in);
                System.out.println("Introduceti _a: ");
                a = scanner_a.nextInt();

                Scanner scanner_c = new Scanner(System.in);
                System.out.println("Introduceti _c: ");
                c = scanner_c.nextInt();

                Scanner scanner_m = new Scanner(System.in);
                System.out.println("Introduceti _m: ");
                m = scanner_m.nextInt();

                LCG lcgo = new LCG(seedLcg, a, c, m);
                lcgo.NextSeed();

                while (MS != 0) {

                    lcgo.NextSeed();
                    --MS;
                }
                break;

                default:
                    System.exit(0);
                    break;
            }

        }
    }

