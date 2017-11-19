package Tonomat;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;

public class stateMachine {
    protected String stareCurenta = "0";
    protected HashMap<String, HashMap<String, String>> table = new HashMap<>();

    protected void transaction(String actiune) {
        stareCurenta = table.get(stareCurenta).get(actiune);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("                         Ati introdus " + actiune);
        System.out.println("                Creditul dumneavoastra este de " + stareCurenta + " RON");


        if (actiune.equals("Machiatto")) {
            System.out.println("                    Machiatto   30 RON");
            System.out.println("                        THANK YOU!");
            System.out.println("                           ENJOY");
        } else if (actiune.equals("Latte")) {
            System.out.println("                    Latte       30 RON");
            System.out.println("                        THANK YOU!");
            System.out.println("                           ENJOY");
        } else if (actiune.equals("Americano")) {
            System.out.println("                    Americano   25 RON");
            System.out.println("                        THANK YOU!");
            System.out.println("                           ENJOY");
        } else if (actiune.equals("Frappe")) {
            System.out.println("                    Frappe      20 RON");
            System.out.println("                        THANK YOU!");
            System.out.println("                           ENJOY");
        } else if (actiune.equals("Mocha")) {
            System.out.println("                    Mocha       20 RON");
            System.out.println("                        THANK YOU!");
            System.out.println("                           ENJOY");
        } else if (actiune.equals("Cappucino")) {
            System.out.println("                    Cappucino   15 RON");
            System.out.println("                        THANK YOU!");
            System.out.println("                           ENJOY");
        } else if (actiune.equals("Ristretto")) {
            System.out.println("                    Ristretto   15 RON");
            System.out.println("                        THANK YOU!");
            System.out.println("                           ENJOY");
        } else if (actiune.equals("Espresso")) {
            System.out.println("                    Espresso    15 RON");
            System.out.println("                        THANK YOU!");
            System.out.println("                           ENJOY");
        }


        if (stareCurenta.equals(5) || stareCurenta.equals(10) || stareCurenta.equals(null)) {
            System.out.println("---Introduceti credit: Se accepta numai bancnote de 5 RON sau 10 RON)---");
        } else if (stareCurenta.equals("30")) {
            System.out.println("        Ati atins limita maxima de credit admisa \n        Selectati cafeaua dorita");
            System.out.println("#   Machiatto   30 RON");
            System.out.println("#   Latte       30 RON");
            System.out.println("#   Americano   25 RON");
            System.out.println("#   Frappe      20 RON");
            System.out.println("#   Mocha       20 RON");
            System.out.println("#   Cappucino   15 RON");
            System.out.println("#   Ristretto   15 RON");
            System.out.println("#   Espresso    15 RON");
        } else if (stareCurenta.equals("25")) {
            System.out.println("---Introduceti credit: (Se accepta numai bancnote de 5 RON)---");
            System.out.println("-----------------Sau selectati cafeaua dorita-----------------");
            System.out.println("#   Americano   25 RON");
            System.out.println("#   Frappe      20 RON");
            System.out.println("#   Mocha       20 RON");
            System.out.println("#   Cappucino   15 RON");
            System.out.println("#   Ristretto   15 RON");
            System.out.println("#   Espresso    15 RON");
        } else if (stareCurenta.equals("20")) {
            System.out.println("---Introduceti credit: (Se accepta numai bancnote de 5 RON SAU 10 RON)---");
            System.out.println("----------------------Sau selectati cafeaua dorita-----------------------");
            System.out.println("#   Frappe      20 RON");
            System.out.println("#   Mocha       20 RON");
            System.out.println("#   Cappucino   15 RON");
            System.out.println("#   Ristretto   15 RON");
            System.out.println("#   Espresso    15 RON");
        } else if (stareCurenta.equals("15")) {
            System.out.println("---Introduceti credit: (Se accepta numai bancnote de 5 RON SAU 10 RON)---");
            System.out.println("----------------------Sau selectati cafeaua dorita-----------------------");
            System.out.println("#   Cappucino   15 RON");
            System.out.println("#   Ristretto   15 RON");
            System.out.println("#   Espresso    15 RON");
        } else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("---Introduceti credit: (Se accepta numai bancnote de 5 RON sau 10 RON)---");

        }


    }
}
