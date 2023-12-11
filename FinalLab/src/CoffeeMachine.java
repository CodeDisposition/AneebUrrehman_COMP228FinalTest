import java.util.Random;

public class CoffeeMachine implements Runnable {

    public final String machineName;
    // Add more fields if needed


    public CoffeeMachine(String machineName) {
        this.machineName = machineName;
    }


    @Override
    public void run() {
        brewCoffee();
    }

    private void brewCoffee() {
        // Add brewing logic here according to the coffee type in the order
        // Use different Thread.sleep time for each type of coffee,
        // any time is fine as long as it is different

        // print the order details the coffee is ready
        // example "Thread-5 machineName order id abc (Latte) for John is ready for pickup
        Random random = new Random();

        // Create an instance of the Order class
        Order order = new Order("Customer Name", CoffeeType.ESPRESSO);

        System.out.println(Thread.currentThread().getName() + " " + machineName + " Order id " +
                order.getId() + " (" + order.getCoffeeType() + ") for " + order.getName() +
                " is ready for pickup");
    }
}

