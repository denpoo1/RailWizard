package Wagons.Wagon_restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Manager {
    /**This is a Java code for a singleton class called "Manager".
     * It has a list of 10 tables and two concurrent queues for orders and dishes.

     The "Manager" constructor creates 10 tables by initializing an ArrayList of Table objects.
     The method "getNextTable" returns the next table in a circular manner, starting from the first table.

     The "getOrderQueue" and "getDishesQueue" methods provide access to the queues for orders and dishes respectively.

     This class is designed to be used in a restaurant simulation, where orders are placed by customers and picked up by waiters.
     The orders are then cooked by a cook, and when ready, the dishes are added to the dishes queue by the cook.*/

    private final List<Table> restaurantTables = new ArrayList<Table>(10);
    private int currentIndex = 0;

    private final Queue<Order> orderQueue = new ConcurrentLinkedQueue<Order>();        // queue with orders
    private final Queue<Dishes> dishesQueue = new ConcurrentLinkedQueue<Dishes>();     // queue with ready meals

     Manager() {               // create 10 tables
        for (int i = 0; i < 10; i++) {
            restaurantTables.add(new Table());
        }
    }

    synchronized Table getNextTable() {           // the waiter walks around from table 1 to table 10
        Table table = restaurantTables.get(currentIndex);
        currentIndex = (currentIndex + 1) % 10;
        return table;
    }

    Queue<Order> getOrderQueue() {
        return orderQueue;
    }

    Queue<Dishes> getDishesQueue() {
        return dishesQueue;
    }
}
