package petriNet;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine tonomat = new CoffeeMachine();
        tonomat.execute("5b");
        tonomat.execute("5b");
        tonomat.execute("5b");
        tonomat.execute("5b");
        tonomat.execute("c20");
        System.out.println("finish");

        /*ReadWrite rw = new ReadWrite(1);
        rw.execute("StartReading");
        rw.execute("StopReading");
        rw.execute("StartWriting");
        rw.execute("StopWriting");*/

        /*ProducerConsumer pc = new ProducerConsumer();
        pc.execute("produce");
        pc.execute("push");
        pc.execute("pop");
        pc.execute("consume");*/
    }
}
