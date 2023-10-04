package Wagons.Wagon_restaurant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Waiter implements Runnable {
    /**This code defines a class Waiter that implements the Runnable interface.
     * The Waiter class takes a File object and a Manager object as input arguments in its constructor.

     The Waiter class has a boolean variable continueWorking which is initially set to true.
     The class also has a set of methods for getting and setting the value of continueWorking.

     The run() method of the Waiter class contains a while loop that continues to execute until continueWorking
     is set to false or there are no more dishes left in the dishesQueue of the Manager object.
     Within the while loop, there is an if-else block that checks if the dishesQueue is empty or not.
     If it is not empty, the waiter takes the order from the queue and writes to the file that the order has been taken.
     If the dishesQueue is empty, the waiter takes the order from the next table in a circular manner,
     adds the order to the orderQueue of the Manager object, and writes to the file that the order has been received.
     The waiter then waits for 100 milliseconds before moving on to the next table.
     If any exception occurs during the execution of the run() method, a RuntimeException is thrown.*/
    Waiter(File file, Manager manager) {
        this.file = file;
        manager1 = manager;
    }

    private boolean continueWorking = true;
    private File file;
    private Manager manager1;

    public boolean isContinueWorking() {
        return continueWorking;
    }

    public void setContinueWorking(boolean continueWorking) {
        this.continueWorking = continueWorking;
    }

    @Override
    public void run() {
        Manager manager = manager1;

        while (continueWorking || !manager.getDishesQueue().isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                if (!manager.getDishesQueue().isEmpty()) {       //we take the finished order
                    Dishes dishes = manager.getDishesQueue().poll();
                    writer.write("The waiter took the order for table no." + dishes.getTableNumber());
                    writer.newLine();
                } else {                                         //take a new order
                    Table table = manager.getNextTable();
                    Order order = table.getOrder();
                    writer.write("Order received from table no." + order.getTableNumber());
                    writer.newLine();
                    manager.getOrderQueue().add(order);
                }
                try {
                    Thread.sleep(100);  //walking to the next table
                } catch (InterruptedException e) {
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}