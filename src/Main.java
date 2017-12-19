
import java.util.Collections;

public class Main {

    /*
     * Pentru a calcula numarul de clienti serviti folosesc un vector de frecventa si cresc nr clientului servit
     */
    public static void main(String[] args) {
        int simulationTime = 700;
        int copyOfSimulationTime = simulationTime;
        int meanWaitingTime = 0;
        int meanAnswerTime = 0;
        int servedTime = 0;
        int nrOfClients = 400;
        int[] freqV = new int[nrOfClients +1];
        int nrOfAllServedClients = 0;
        boolean customerChecked = false; //check if there were made any changes in customers list
        PayDesk prelucrareColetDesk = new PayDesk();
        PayDesk mandatePostaleDesk = new PayDesk();
        PayDesk livrareColetDesk = new PayDesk();
        PayDesk platiFacturiDesk = new PayDesk();

        RunSimulation run = new RunSimulation(nrOfClients);
        run.randomizeCustomers();

        while(simulationTime > 0){
		/*System.out.println(run.customerPrelucrareColet.get(0).nrOfCustomer);
		System.out.println(run.customerLivrareColet.get(0).nrOfCustomer);
		System.out.println(run.customerMandatePostale.get(0).nrOfCustomer);
		System.out.println(run.customerPlatiFacturi.get(0).nrOfCustomer);*/


            while(!customerChecked){
                customerChecked = true;
                if((!run.customerPrelucrareColet.isEmpty() &&  !run.customerLivrareColet.isEmpty() && run.customerPrelucrareColet.get(0).nrOfCustomer == run.customerLivrareColet.get(0).nrOfCustomer)
                        || (!run.customerPrelucrareColet.isEmpty() && !run.customerMandatePostale.isEmpty() && run.customerPrelucrareColet.get(0).nrOfCustomer == run.customerMandatePostale.get(0).nrOfCustomer)
                        || (!run.customerPrelucrareColet.isEmpty() && !run.customerPlatiFacturi.isEmpty() && run.customerPrelucrareColet.get(0).nrOfCustomer == run.customerPlatiFacturi.get(0).nrOfCustomer))
                {
                    Collections.swap(run.customerPrelucrareColet, 0, 1);
                    customerChecked = false;
                }

                if((!run.customerLivrareColet.isEmpty() && !run.customerMandatePostale.isEmpty() && run.customerLivrareColet.get(0).nrOfCustomer == run.customerMandatePostale.get(0).nrOfCustomer)
                        || (!run.customerLivrareColet.isEmpty() && !run.customerPlatiFacturi.isEmpty() && run.customerLivrareColet.get(0).nrOfCustomer == run.customerPlatiFacturi.get(0).nrOfCustomer))
                {
                    Collections.swap(run.customerLivrareColet, 0, 1);
                    customerChecked = false;
                }

                if(!run.customerMandatePostale.isEmpty() && !run.customerPlatiFacturi.isEmpty() && run.customerMandatePostale.get(0).nrOfCustomer == run.customerPlatiFacturi.get(0).nrOfCustomer)
                {
                    Collections.swap(run.customerMandatePostale, 0, 1);
                    customerChecked = false;
                }
			/*System.out.println(run.customerPrelucrareColet.get(0).nrOfCustomer);
			System.out.println(run.customerLivrareColet.get(0).nrOfCustomer);
			System.out.println(run.customerMandatePostale.get(0).nrOfCustomer);
			System.out.println(run.customerPlatiFacturi.get(0).nrOfCustomer);*/
            }

            if(!run.customerPrelucrareColet.isEmpty())
            {
                prelucrareColetDesk.simulationTime++;
                run.customerPrelucrareColet.get(0).serviceTime--;
                servedTime++;
                if(run.customerPrelucrareColet.get(0).serviceTime <= 0)
                {
                    meanWaitingTime += run.customerPrelucrareColet.get(0).arrivalTime;
                    freqV[run.customerPrelucrareColet.get(0).nrOfCustomer]++;
                    prelucrareColetDesk.nrOfServedClients++;
                    run.customerPrelucrareColet.remove(0);
                }
            }

            if(!run.customerLivrareColet.isEmpty())
            {
                livrareColetDesk.simulationTime++;
                run.customerLivrareColet.get(0).serviceTime--;
                servedTime++;
                if(run.customerLivrareColet.get(0).serviceTime <= 0)
                {
                    meanWaitingTime += run.customerLivrareColet.get(0).arrivalTime;
                    freqV[run.customerLivrareColet.get(0).nrOfCustomer]++;
                    livrareColetDesk.nrOfServedClients++;
                    run.customerLivrareColet.remove(0);
                }
            }
            if(!run.customerMandatePostale.isEmpty())
            {
                mandatePostaleDesk.simulationTime++;
                run.customerMandatePostale.get(0).serviceTime--;
                servedTime++;
                if(run.customerMandatePostale.get(0).serviceTime <= 0)
                {
                    meanWaitingTime += run.customerMandatePostale.get(0).arrivalTime;
                    freqV[run.customerMandatePostale.get(0).nrOfCustomer]++;
                    mandatePostaleDesk.nrOfServedClients++;
                    run.customerMandatePostale.remove(0);
                }
            }
            if(!run.customerPlatiFacturi.isEmpty())
            {
                platiFacturiDesk.simulationTime++;
                run.customerPlatiFacturi.get(0).serviceTime--;
                servedTime++;
                if(run.customerPlatiFacturi.get(0).serviceTime <= 0)
                {
                    meanWaitingTime += run.customerPlatiFacturi.get(0).arrivalTime;
                    freqV[run.customerPlatiFacturi.get(0).nrOfCustomer]++;
                    platiFacturiDesk.nrOfServedClients++;
                    run.customerPlatiFacturi.remove(0);
                }
            }

            simulationTime--;
        }

        for(int i=1; i<=nrOfClients; i++)
            if(freqV[i] > 0)
                nrOfAllServedClients++;
        meanAnswerTime = meanWaitingTime + servedTime;

        System.out.println("Number of served clients: " + nrOfAllServedClients );
        System.out.println("Mean waiting time: " + meanWaitingTime / nrOfAllServedClients);
        System.out.println("Mean answer time: " + meanAnswerTime / nrOfAllServedClients);
        System.out.println("Utilisation of Preluare colet desk is: " + ((prelucrareColetDesk.simulationTime * 100)/ copyOfSimulationTime) + "%");
        System.out.println("Utilisation of Livrare colet desk is: " + ((livrareColetDesk.simulationTime * 100)/ copyOfSimulationTime) + "%");
        System.out.println("Utilisation of Mandate Postale desk is: " + ((mandatePostaleDesk.simulationTime * 100)/ copyOfSimulationTime) + "%");
        System.out.println("Utilisation of Plati facturi desk is: " + ((platiFacturiDesk.simulationTime * 100)/ copyOfSimulationTime) + "%");

    }
}

