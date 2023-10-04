package Wagons.Wagon_restaurant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Cook implements Runnable {
    /**This code is a Java implementation of a restaurant simulation.
     * The Cook class implements the Runnable interface and represents a cook working in the restaurant.
     * The Cook object is responsible for cooking orders and writing information about the process to a file.

     The Cook class has several private fields, including a continueWorking boolean flag that indicates whether the cook should continue working,
     a File object that represents the file to which information should be written, and a Manager object that represents the restaurant manager.

     The run() method is the main method of the Cook class.
     It contains a while loop that continues until the continueWorking flag is set to false and there are no orders left in the queue.
     Inside the loop, the cook checks whether there are any orders to cook by calling the needToCookOrders() method,
     and if there are, the cook takes an order from the queue and cooks it by calling the cook() method.
     If there are no orders to cook, the cook writes a message to the file indicating that they are resting, and then waits for 100 milliseconds.

     The cook() method takes an order from the queue, writes a message to the file indicating that the order is being cooked,
     and then sleeps for a certain amount of time (specified by the order). After sleeping, the cook creates a Dishes object representing the completed order,
     writes a message to the file indicating that the order is ready, and adds the Dishes object to the dishes queue.

     Overall, the Cook class is responsible for cooking orders and writing information about the process to a file.
     It works together with other classes in the restaurant simulation to create a complete simulation of a restaurant.*/
    private boolean continueWorking = true;
    private File file;
    private Manager manager1;

    Cook(File file, Manager manager) {
        this.file = file;
        this.manager1 = manager;
    }

    public boolean isContinueWorking() {
        return continueWorking;
    }

    public void setContinueWorking(boolean continueWorking) {
        this.continueWorking = continueWorking;
    }

    @Override
    public void run() {
        boolean needToWait;
        while (continueWorking || needToCookOrders()) {
            try {
                synchronized (this) {
                    needToWait = !needToCookOrders();
                    if (!needToWait) {
                        cook();
                    }
                }
                if (continueWorking && needToWait) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                        writer.write("The cook is resting\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException ignored) {
            }
        }
    }

    private boolean needToCookOrders() {
        return !manager1.getOrderQueue().isEmpty();
    }

    private void cook() throws InterruptedException {
        Manager manager = manager1;
        Order order = manager.getOrderQueue().poll();      // повар берет заказ из очереди
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(String.format("Order will cook in %d ms for table no.%d", order.getTime(), order.getTableNumber()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(order.getTime());
        Dishes dishes = new Dishes(order.getTableNumber());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(String.format("Order for table %d is ready", dishes.getTableNumber()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        manager.getDishesQueue().add(dishes);
    }
}
