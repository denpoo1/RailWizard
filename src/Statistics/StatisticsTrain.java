package Statistics;

import Locomotive.Locomotive;
import Wagon.Wagon;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class StatisticsTrain extends Thread {
    /**This code is a Java class named "StatisticsTrain" that extends the "Thread" class.
    It imports two other classes named "Locomotive" and "Wagon". It also imports other Java IO and utility classes.

The class has a static list of locomotives named "trains" and a private File object named "file".
It also has a Comparator object that compares wagons based on their gross weight.

The class has a static method named "addStatistics" that adds a new locomotive object to the "trains" list.

The class overrides the "run" method from the "Thread" class.
In this method, the thread sleeps for 5 seconds and then sorts the "trains" list based on the distance traveled percentage of each locomotive. It also sorts the wagons of each locomotive using the comparator object. Then, it creates a string representation of each locomotive and writes it to a file named "Statistics.txt".

If any exceptions occur during the execution of the thread, they are caught and handled appropriately.*/
    static private List<Locomotive> trains = new ArrayList<Locomotive>();
    private File file = new File("src/Statistics/Statistics.txt");
Comparator<Wagon> comparatorWagon = Comparator.nullsFirst(Comparator.comparingDouble(Wagon::getGross_weight));

    public static void addStatistics(Locomotive locomotive) {
        trains.add(locomotive);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                try (FileOutputStream output = new FileOutputStream(file, false)) {
                    Collections.sort(trains, (a, b) -> Double.compare(a.getDistanceTraveled_percent(), b.getDistanceTraveled_percent()));
                    for (Locomotive locomotive : trains) {
                        Arrays.sort(locomotive.getWagony(), comparatorWagon);
                    }
                    String locomotive = null;
                    for (Locomotive train : trains) {
                        locomotive = String.format("%d %s %s->%s allDistance:%s DistanceTraveled_percent:%d%% Distance_between_station_persent:%d%%:\n",
                                train.getId(), train.getname(), train.getDeparture_station(), train.getArrival_station(),
                                train.getAllDistance(), (int) train.getDistanceTraveled_percent(), (int) train.getDistance_between_station_persent());
                        for(Wagon wagon : train.getWagony()){
                            if(wagon != null){
                                locomotive += wagon.getClass().getSimpleName() + " -> " + String.format("%.2f", wagon.getGross_weight()) + "\n";
                            }
                        }
                        locomotive += "\n";
                        byte[] bytes = locomotive.getBytes(StandardCharsets.UTF_8);
                        output.write(bytes);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
