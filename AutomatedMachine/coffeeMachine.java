package AutomatedMachine;

import java.util.HashMap;

public class coffeeMachine extends stateMachine{

    coffeeMachine() {
        table = getTableContent();
        System.out.println("#   Machiatto   30 RON");
        System.out.println("#   Latte       30 RON");
        System.out.println("#   Americano   25 RON");
        System.out.println("#   Frappe      20 RON");
        System.out.println("#   Mocha       20 RON");
        System.out.println("#   Cappucino   15 RON");
        System.out.println("#   Ristretto   15 RON");
        System.out.println("#   Espresso    15 RON");
    }

    private HashMap<String, HashMap<String, String>> getTableContent() {

        HashMap<String, String> actionNextState = new HashMap<>();

        actionNextState.put("5", "5");
        actionNextState.put("10", "10");
        table.put("0", actionNextState);

        actionNextState = new HashMap<>();

        actionNextState.put("5","10");
        actionNextState.put("10","15");
        table.put("5",actionNextState);

        actionNextState = new HashMap<>();

        actionNextState.put("5","15");
        actionNextState.put("10","20");
        table.put("10",actionNextState);

        actionNextState = new HashMap<>();

        actionNextState.put("Espresso","0");
        actionNextState.put("Ristretto","0");
        actionNextState.put("Cappucino","0");
        actionNextState.put("5","20");
        actionNextState.put("10","25");
        table.put("15",actionNextState);

        actionNextState = new HashMap<>();

        actionNextState.put("Espresso","5");
        actionNextState.put("Ristretto","5");
        actionNextState.put("Cappucino","5");
        actionNextState.put("Mocha","0");
        actionNextState.put("Frappe","0");
        actionNextState.put("5","25");
        actionNextState.put("10","30");
        table.put("20",actionNextState);

        actionNextState = new HashMap<>();

        actionNextState.put("Espresso","10");
        actionNextState.put("Ristretto","10");
        actionNextState.put("Cappucino","10");
        actionNextState.put("Mocha","5");
        actionNextState.put("Frappe","5");
        actionNextState.put("Americano","0");
        actionNextState.put("5","30");
        table.put("25",actionNextState);

        actionNextState = new HashMap<>();

        actionNextState.put("Espresso","15");
        actionNextState.put("Ristretto","15");
        actionNextState.put("Cappucino","15");
        actionNextState.put("Mocha","10");
        actionNextState.put("Frappe","10");
        actionNextState.put("Americano","5");
        actionNextState.put("Latte","0");
        actionNextState.put("Machiatto","0");
        table.put("30",actionNextState);

        return table;
    }

}

