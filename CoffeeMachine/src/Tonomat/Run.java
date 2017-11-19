package Tonomat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Run {
    public static void main(String[] args) {

        coffeeMachine bosch = new coffeeMachine();
        Scanner scanner = new Scanner(System.in);
        System.out.println("########################################################################");
        System.out.println("#----------------------------BUNA DIMINEATA----------------------------#");
        System.out.println("#   Espresso   15 RON       --------------       Ristretto  15 RON     #");
        System.out.println("#   Cappucino  15 RON       --------------       Mocha      20 RON     #");
        System.out.println("#   Latte      30 RON       --------------       Americano  25 RON     #");
        System.out.println("#   Machiatto  30 RON       --------------       Frappe     20 RON     #");
        System.out.println("########################################################################");


        System.out.println("\n---Introduceti credit: (Se accepta numai bancnote de 5 RON sau 10 RON---");
        int x = 1;
        String Credit;
        List<String> CoffeeTypes = new ArrayList<>();
        CoffeeTypes.add("Espresso");
        CoffeeTypes.add("Ristretto");
        CoffeeTypes.add("Cappucino");
        CoffeeTypes.add("Mocha");
        CoffeeTypes.add("Latte");
        CoffeeTypes.add("Americano");
        CoffeeTypes.add("Machiatto");
        CoffeeTypes.add("Frappe");
        CoffeeTypes.add("5");
        CoffeeTypes.add("10");
        CoffeeTypes.add("Exit");
        do {
            Credit = scanner.nextLine();
            for (int iterator = 0; iterator < CoffeeTypes.size(); iterator++) {
                if (Credit.equals("Exit")) {
                    exit(3417);
                } else if (Credit.equals(CoffeeTypes.get(iterator))) {
                    bosch.transaction(Credit);
                    break;
                } else {
                }
            }
        } while (x == 1);

    }
}
