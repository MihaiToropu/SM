import java.util.ArrayList;
import java.util.Random;

public class RunSimulation {

    int nrCostumers;
    public ArrayList<Customer> customerPrelucrareColet = new ArrayList<>();
    public ArrayList<Customer> customerLivrareColet = new ArrayList<>();
    public ArrayList<Customer> customerPlatiFacturi = new ArrayList<>();
    public ArrayList<Customer> customerMandatePostale = new ArrayList<>();

    RunSimulation(int nrCostumers) {
        this.nrCostumers = nrCostumers;
    }

    //generate lists of Customers for PayDesks
    public void randomizeCustomers() {
        int arrivalTime = 0;
        for (int i = 0; i < nrCostumers; i++) {
            int nrOfCustomers = i + 1;
            Services value;
            double serviceTime;
            arrivalTime = randInt(1, 7);
            int nrOfServices = randInt(1, 3);
            boolean hasServices = false;

            for (int j = 0; j < nrOfServices; j++) {
                value = Services.getRandomService();
                serviceTime = randDouble(1, 7);
                Customer c = new Customer(nrOfCustomers, arrivalTime, serviceTime, value, hasServices);

                if (value == Services.PRELUARE_COLET) {
                    customerPrelucrareColet.add(c);
                } else if (value == Services.LIVRARE_COLET) {
                    customerLivrareColet.add(c);
                } else if (value == Services.PLATI_FACTURI) {
                    customerPlatiFacturi.add(c);
                } else {
                    customerMandatePostale.add(c);
                }
            }
        }
    }

    public static int randInt(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static double randDouble(int min, int max) {

        Random rand = new Random();
        double randomNum = min + (max - min) * rand.nextDouble();

        return randomNum;
    }
}
