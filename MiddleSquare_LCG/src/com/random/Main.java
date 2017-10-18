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


            while (true) {
                System.out.println("Doriti sa continuati? y(Yes) or n(No)) ");
                Scanner stringScanner = new Scanner(System.in);
                String _choose = stringScanner.nextLine();
                switch (_choose) {
                    case "y":
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
                        break;
                    case "n":
                        System.exit(0);
                        break;


                    default:
                        System.exit(0);
                        break;
                }
            }

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

                while (true) {
                    System.out.println("Doriti sa continuati? y(Yes) or n(No)) ");
                    Scanner stringScanner = new Scanner(System.in);
                    String _choose = stringScanner.nextLine();


                    switch (_choose) {
                        case "y":
                            lcgo.NextSeed();
                            break;
                        case "n":
                            System.exit(0);
                            break;


                        default:
                            System.exit(0);
                            break;
                    }
                }
        }
    }
}
