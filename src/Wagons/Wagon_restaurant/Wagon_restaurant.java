package Wagons.Wagon_restaurant;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Interfaces.Electricity;
import Wagon.Wagon;

public class Wagon_restaurant extends Wagon implements Electricity {
    /**This code defines a class called Wagon_restaurant that extends the Wagon class and implements the Electricity interface.
     * The Wagon_restaurant class represents a restaurant in a train wagon. The restaurant has a manager, a waiter, and a cook, each running on a separate thread.

     The constructor of Wagon_restaurant initializes an integer count and creates a new file with a name that includes this count.
     If the file already exists, it is cleared. The constructor also calls the constructor of the Wagon class, passing it the name of the wagon,
     a string representing an additional layer of steel, and two integers representing the maximum weight and volume of the wagon.

     The Wagon_restaurant class has a private field manager of type Manager, which manages the restaurant.
     It also has a private field waiterTarget of type Waiter, which represents the waiter and is initialized with the file and the manager.
     Similarly, it has a private field cookTarget of type Cook, which represents the cook and is initialized with the file and the manager.

     The Wagon_restaurant class has two threads, waiter and cook, which are created with the waiterTarget and cookTarget, respectively.
     The waiter and cook threads are added to a threads list.

     The start_Restaurant method of the Wagon_restaurant class starts the waiter and cook threads if they are not already running.
     The method does this by checking if the continueWorking flag of both the waiterTarget and the cookTarget is set to true.
     If either of them is set to false, the start_Restaurant method sets both flags to true and starts the threads. Otherwise, it does nothing.

     The stop_Restaurant method of the Wagon_restaurant class stops the waiter and cook threads by setting the continueWorking
     flag of both the waiterTarget and the cookTarget to false.

     The debarkation and lading methods of the Wagon_restaurant class are empty and do not do anything, as they are required by the Electricity interface.*/
    private static int count = 0;
    private File file =  new File( System.getProperty("user.dir") + "/" + count++ + ".txt");{
        if(file.exists()) {
            try(FileWriter writer = new FileWriter(file)){
                writer.write("");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public Wagon_restaurant(String name) {
        super(name, "Additional layer of steel", 5, 10);
    }
    private Manager manager = new Manager();
    private Waiter waiterTarget = new Waiter(file,manager);
    private Thread waiter = new Thread(waiterTarget);
    private Cook cookTarget = new Cook(file,manager);
    private Thread cook = new Thread(cookTarget);
    private List<Thread> threads = new ArrayList<>();

    {
        threads.add(waiter);
        threads.add(cook);
    }

    public void start_Restaurant() {
        if (!(waiterTarget.isContinueWorking() && cookTarget.isContinueWorking())) {
            waiterTarget.setContinueWorking(true);
            cookTarget.setContinueWorking(true);
        }else{
            waiter.start();
            cook.start();
        }
    }

    public void stop_Restaurant() {
        waiterTarget.setContinueWorking(false);
        cookTarget.setContinueWorking(false);
        }

    @Override
    public void debarkation() {

    }

    @Override
    public void lading() {

    }
}
