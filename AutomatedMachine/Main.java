package AutomatedMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {

        AutomatedTellerMachine atm = new AutomatedTellerMachine();
        //coffeeMachine cm = new coffeeMachine();
        Scanner scanner = new Scanner(System.in);
        int x = 1;
        String Credit;
        int y;
        List<String> Types = new ArrayList<>();
        Types.add("Espresso");
        Types.add("Ristretto");
        Types.add("Cappucino");
        Types.add("Mocha");
        Types.add("Latte");
        Types.add("Americano");
        Types.add("Machiatto");
        Types.add("Frappe");
        Types.add("5");
        Types.add("10");
        Types.add("-5");
        Types.add("-10");
        Types.add("-15");
        Types.add("-20");
        Types.add("-25");
        Types.add("-30");
        Types.add("Exit");

        do {
            y = 0;
            Credit = scanner.nextLine();
            for (int iterator = 0; iterator < Types.size(); iterator++) {
                if (Credit.equals("Exit")) {
                    exit(3417);
                    y = 1;
                } else if (Credit.equals(Types.get(iterator))) {

                    atm.transaction(Credit);
                    //cm.transaction(Credit);
                    y = 1;
                }
            }
            if(0 == y){
                System.out.println("\n---Introduceti credit: (Se accepta numai bancnote de 5 RON sau 10 RON---");
            }
        } while (x == 1);
    }
}
