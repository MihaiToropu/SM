package AutomatedMachine;

import java.util.HashMap;

public class stateMachine {
    protected String stareCurenta = "0";
    protected HashMap<String, HashMap<String, String>> table = new HashMap<>();

    protected void transaction(String actiune) {
        stareCurenta = table.get(stareCurenta).get(actiune);
        System.out.println("                         Ati introdus " + actiune);
        System.out.println("                Creditul dumneavoastra este de " + stareCurenta + " RON");
    }
}
