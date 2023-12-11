import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class Cashier implements Runnable {

    private final String cashierName;
    private String[] customerNames;

    public Cashier(String cashierName) {
        this.cashierName = cashierName;
    }

    @Override
    public void run() {
        while (true) {
            placeOrder();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void placeOrder() {
        Random random = new Random();
        String customerName = generateRandomName(); // Assume a method to generate random customer names
        CoffeeType coffeeType = getRandomCoffeeType(random); // Get a random coffee type

        Order order = new Order(customerName, coffeeType);
        System.out.println(Thread.currentThread().getName() + " " + cashierName + ": Order id " +
                order.getId() + " (" + order.getCoffeeType() + ") is accepted for " + order.getName());
    }

    private String generateRandomName() {
        String[] customerNames = {"Alice", "Muhammad", "Bob", "Fatima", "Charlie", "Layla", "Diana", "Yusuf",
                "Emily", "Ahmed", "Frank", "Aisha", "Grace", "Omar", "Henry", "Jasmine",
                "Ivy", "Zainab", "Jack", "Sofia", "Lucas", "Noor", "Emma", "Ali",
                "Oliver", "Mira", "William", "Lina", "Maryam", "Olivia", "Omar",
                "Sophia", "Hamza", "Charlotte", "Youssef", "Amelia", "Daniel", "Nour", "Alex"};


        Random random = new Random();
        int randomIndex = random.nextInt(customerNames.length);
        return customerNames[randomIndex];
    }

    private CoffeeType getRandomCoffeeType(Random random) {
        return CoffeeType.values()[random.nextInt(CoffeeType.values().length)];
    }
}