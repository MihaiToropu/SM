import java.util.HashMap;

public class Customer {

    int nrOfCustomer;
    int arrivalTime;
    boolean inService;
    HashMap<Double, Services> services = new HashMap<>();
    double serviceTime;
    Services serviceOrdered;


    Customer(int nrOfCustomer, int arrivalTime, double serviceTime, Services serviceOrdered, boolean inService) {
        this.nrOfCustomer = nrOfCustomer;
        this.arrivalTime = arrivalTime;
        this.serviceOrdered = serviceOrdered;
        this.serviceTime = serviceTime;
        this.inService = inService;
    }

    public int getNrOfCustomer() {
        return nrOfCustomer;
    }

    public void setNrOfCustomer(int nrOfCustomer) {
        this.nrOfCustomer = nrOfCustomer;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
