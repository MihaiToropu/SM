package pack;

public class needed {
}

public class MainMoreThreadsJoin {
    public static void main(String[] args) {
        Thread[] thread = new Thread[8];
        for (int i = 0; i < thread.length; i++) {
            thread[i] =
                    new MyThread("Hello world from thread" + i);
        }
        for (int i = 0; i < thread.length; i++) {
            thread[i].start();
        }
        for (int i = 0; i < thread.length; i++) {
            try {
                thread[i].join();
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main finished");
    }
}

public class FirulMeu extends Thread {
...
    private volatile boolean done = false;
...
    public void run( ) {
        while (!done) {
...
        }
    }
    public void setDone() {
        done = true;
    }
}


public class FirulMeu extends Thread {
...
    public void run( ) {
        while (!isInterrupted()) {
...
        }
    }
}