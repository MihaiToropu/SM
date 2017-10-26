package MS_LCG;

import java.util.Scanner;

public class Run
{
    public static void main(String[] args)
    {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Alege: ");
//        System.out.println("1. MiddleSquare: ");
//        System.out.println("2. LCG: ");
//        int alege = scanner.nextInt();
//
//        Scanner scanner_numereGenerate = new Scanner(System.in);
//        System.out.println("Cate numere random doriti sa generati? ");
//        int numereGenerate = scanner_numereGenerate.nextInt();

//        switch (alege)
//        {
//            case 1:
//
//
//        }


        //MiddleSquare mso = new MiddleSquare(10);
        //mso.run();
        Evaluator eo = new Evaluator(10000,3);
        eo.accuracy();

    }


}
