

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;


public class CoffeeShop {
    public static void main(String[] args) {
        // change the constants if needed
        final int numberOfCashiers = 4;
        final int numberOfMachines = 6;
        final int threadCount = 10;
        // add extra fields if needed

        String[] cashierNames = {"Cashier1", "Cashier2", "Cashier3", "Cashier4"};
        String[] machineNames = {"Machine1", "Machine2", "Machine3", "Machine4", "Machine5", "Machine6", "Machine7", "Machine8"};

        Random random = new Random();

        ExecutorService executorService =
                Executors.newFixedThreadPool(threadCount);


        for(int i=0; i<numberOfMachines;i++){
            // change name to random name generated using faker
            // add extra fields to constructor if needed
            String randomMachineName = machineNames[random.nextInt(machineNames.length)];
            executorService.submit(new CoffeeMachine(randomMachineName));
        }

        for(int i=0; i<numberOfCashiers;i++) {
            // change name to random name generated using faker
            // add extra fields to constructor if needed
            String randomCashierName = cashierNames[random.nextInt(cashierNames.length)];
            executorService.submit(new Cashier(randomCashierName));
        }

    }
}