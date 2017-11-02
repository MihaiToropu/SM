package MS_LCG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {

        int seed;
        int a;
        int c;
        int m;
        int numereGenerate;
        List<Float> myFloatList =
                new ArrayList<Float>();
        List<Integer> myList =
                new ArrayList<Integer>();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Alege: ");
        System.out.println("1. MiddleSquare: ");
        System.out.println("2. LCG: ");
        System.out.println("3. Accuracy: ");
        System.out.println("4. Binomial: ");
        System.out.println("5. Poisson: ");
        System.out.println(" Exit ");
        int alege = scanner.nextInt();

        switch (alege) {
            case 1:
                System.out.println("##################################################################################");
                System.out.println("Introduceti seed-ul!!!");
                seed = scanner.nextInt();
                System.out.println("Cate numere random doriti sa generati? ");
                numereGenerate = scanner.nextInt();
                MiddleSquare mso = new MiddleSquare(seed, numereGenerate);
                mso.NextSeed();
                myList = mso.getNumbers();
                for (Integer Iterator : myList) {
                    System.out.println(Iterator);
                }
                break;

            case 2:
                System.out.println("##################################################################################");
                System.out.println("                          (a * seed + c) % m");
                System.out.println("Introduceti seed-ul!!!");
                seed = scanner.nextInt();
                System.out.println("Introduceti a!!!");
                a = scanner.nextInt();
                System.out.println("Introduceti c!!!");
                c = scanner.nextInt();
                System.out.println("Introduceti m!!!");
                m = scanner.nextInt();
                Lcg lcgo = new Lcg(seed, a, c, m, 4);
                myFloatList = lcgo.NextSeed();
                for (float Iterator : myFloatList) {
                    System.out.println(Iterator);
                }
                break;

            case 3:
                System.out.println("##################################################################################");
                numereGenerate = 10000;
                Evaluator dgo = new Evaluator(10000, new MiddleSquare(2500, numereGenerate));
                float result = dgo.accuracy();
                System.out.println("                   DefaultGenerator  -->   " + result);

                Evaluator mso2 = new Evaluator(10000, new Lcg(1, 61, 19, numereGenerate, 4));
                result = mso2.accuracy();
                System.out.println("                   MiddleSquare  ------>   " + result);

                Evaluator lcgo2 = new Evaluator(10000, new DefaultGenerator(10000));
                result = lcgo2.accuracy();
                System.out.println("                   Lcg  --------------->   " + result);
                break;

            default:
                System.out.println("Exit!!!");
                break;
        }


    }

}



