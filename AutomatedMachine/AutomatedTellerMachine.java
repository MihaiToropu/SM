package AutomatedMachine;

import java.util.HashMap;

public class AutomatedTellerMachine extends stateMachine {

    AutomatedTellerMachine() {
        table = getTableContent();
        System.out.println("\n---Introduceti credit: (Se accepta numai bancnote de 5 RON sau 10 RON---");
    }

    private HashMap<String, HashMap<String, String>> getTableContent() {
        HashMap<String, String> actionNextState = new HashMap<>();

        actionNextState.put("0", "0");
        actionNextState.put("5", "5");
        actionNextState.put("10", "10");

        table.put("0", actionNextState);

        actionNextState = new HashMap<>();

        actionNextState.put("5", "10");
        actionNextState.put("10", "15");
        actionNextState.put("-5", "0");
        table.put("5", actionNextState);

        actionNextState = new HashMap<>();

        actionNextState.put("5", "15");
        actionNextState.put("10", "20");
        actionNextState.put("-5", "5");
        actionNextState.put("-10", "0");
        table.put("10", actionNextState);

        actionNextState = new HashMap<>();

        actionNextState.put("5", "20");
        actionNextState.put("10", "25");
        actionNextState.put("-5", "10");
        actionNextState.put("-10", "5");
        actionNextState.put("-15", "0");
        table.put("15", actionNextState);

        actionNextState = new HashMap<>();

        actionNextState.put("5", "25");
        actionNextState.put("10", "30");
        actionNextState.put("-5", "15");
        actionNextState.put("-10", "10");
        actionNextState.put("-15", "5");
        actionNextState.put("-20", "0");
        table.put("20", actionNextState);

        actionNextState = new HashMap<>();

        actionNextState.put("5", "30");
        actionNextState.put("-5", "20");
        actionNextState.put("-10", "15");
        actionNextState.put("-15", "10");
        actionNextState.put("-20", "5");
        actionNextState.put("-25", "0");
        table.put("25", actionNextState);

        actionNextState = new HashMap<>();

        actionNextState.put("-5", "25");
        actionNextState.put("-10", "20");
        actionNextState.put("-15", "15");
        actionNextState.put("-20", "10");
        actionNextState.put("-25", "5");
        actionNextState.put("-30", "0");
        table.put("30", actionNextState);

        return table;
    }
}
