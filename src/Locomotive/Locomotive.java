package Locomotive;

import Graff.Graph;
import Interfaces.Debarkation;
import Interfaces.Electricity;
import Interfaces.Lading;
import Wagon.Wagon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Locomotive extends Thread implements Lading, Debarkation {
    /**This is a Java code for a class named "Locomotive", which extends the "Thread" class and implements the "Lading" and "Debarkation" interfaces.

The code imports various classes and interfaces, including the "Graph" class from the "Graff" package and the "Wagon" class from the "Wagon" package.
It also imports several classes from the "java.io" and "java.util" packages.

The "Locomotive" class has several private instance variables, including a name, the distance traveled as a percentage,
the distance between stations as a percentage, the maximum number of wagons and electric locomotives, the departure and arrival stations, an ID,
the speed, the route, the total distance traveled, the carrying capacity, an array of wagons, the number of wagons in the locomotive, the number of electric wagons,
and a boolean indicating whether the locomotive is currently loaded.

The class overrides the "toString()" method to provide a string representation of the object's state.

The constructor for the "Locomotive" class takes several parameters, including the name of the locomotive,
the maximum number of wagons, the departure and arrival stations, and the carrying capacity.
It initializes the instance variables and calculates the route and total distance traveled using the "Graph" class.

The class also has several getter and setter methods for the instance variables.

The "run()" method is called when the "Locomotive" object is started as a thread.
It runs a loop that iterates over the route and calls the "statisticsLocomotive()" method,
which calculates and writes various statistics to a file.
The "checkSpeed()" method is called in a separate thread to periodically check the speed of the locomotive and update the "speed" instance variable.
The loop also checks a static boolean variable named "stop" to determine when to stop the thread.

Overall, the "Locomotive" class represents a train locomotive that can carry wagons and travel between two stations along a predetermined route.
It can calculate and report various statistics about its journey.*/

    private final String name;

    public String getname() {
        return name;
    }

    private double distanceTraveled_percent;
    private double distance_between_station_persent;
    private final int max_Vagon;
    private final int max_Electrick;
    private final String departure_station;
    private final String arrival_station;
    private final int id;
    private volatile double speed;
    private final List<Integer> route;
    private double allDistance;

    private double carrying_ton;

    private Wagon[] wagony;
    private int countVagon = 0;
    private int number_of_Wagons_in_the_locomotive = 0;

    private int haveElectrickVagons = 0;
    private boolean isLading = false;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Locomotive: ").append(name).append("\n");
        sb.append("Departure Station: ").append(departure_station).append("\n");
        sb.append("Arrival Station: ").append(arrival_station).append("\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Route: ").append(route).append("\n");
        sb.append("Distance Traveled: ").append(distanceTraveled_percent).append("%").append("\n");
        sb.append("Distance Between Stations: ").append(distance_between_station_persent).append("%").append("\n");
        sb.append("Maximum Speed: ").append(speed).append(" km/h").append("\n");
        sb.append("Maximum Number of Wagons: ").append(max_Vagon).append("\n");
        sb.append("Maximum Number of Electric Locomotives: ").append(max_Electrick).append("\n");
        sb.append("Total Distance: ").append(allDistance).append(" km").append("\n");
        sb.append("Carrying Capacity: ").append(carrying_ton).append(" tons").append("\n");
        sb.append("Wagons: ").append(Arrays.toString(wagony)).append("\n");
        sb.append("Number of Wagons in Locomotive: ").append(number_of_Wagons_in_the_locomotive).append("\n");
        sb.append("Has Electric Wagons: ").append(haveElectrickVagons).append("\n");
        sb.append("Is Currently Loaded: ").append(isLading).append("\n");
        return sb.toString();
    }

    public Locomotive(String name, int max_Vagon, String departure_station, String arrival_station, int carrying_ton) {
        this.name = name;
        this.max_Vagon = max_Vagon;
        this.departure_station = departure_station;//проверка на наличие такой станции на карте
        this.arrival_station = arrival_station;
        //должно быть автоматическая построение маршрута(добавлнеия массива маршрута)
        speed = 100;//проверка бывает ли такая скорость у поездов
        max_Electrick = max_Vagon / 2;
        this.carrying_ton = carrying_ton;
        wagony = new Wagon[max_Vagon];
        route = Graph.dijkstra(Graph.getVertexList(departure_station), Graph.getVertexList(arrival_station));
        for (int x = 0; x < route.size() - 1; x++) {
            allDistance += Graph.mas[route.get(x)][route.get(x + 1)];
        }
        distanceTraveled_percent = 0;
        id = (int) (Math.random() * 10_000_000) + 1;
    }

    public double getDistanceTraveled_percent() {
        return distanceTraveled_percent;
    }

    public void setDistanceTraveled_percent(double distanceTraveled_percent) {
        this.distanceTraveled_percent = distanceTraveled_percent;
    }

    public double getDistance_between_station_persent() {
        return distance_between_station_persent;
    }

    public void setDistance_between_station_persent(double distance_between_station_persent) {
        this.distance_between_station_persent = distance_between_station_persent;
    }

    public double getAllDistance() {
        return allDistance;
    }

    public void setAllDistance(double allDistance) {
        this.allDistance = allDistance;
    }

    public String getDeparture_station() {
        return departure_station;
    }

    public String getArrival_station() {
        return arrival_station;
    }


    public static boolean stop = false;

    @Override
    public void run() {
        while (true) {
            try {
                String projectDir = System.getProperty("user.dir");
                File file = new File(projectDir + "/" + name + ".txt");
                Thread checkSpeed = new Thread() {
                    @Override
                    public void run() {
                        checkSpeed();
                    }
                };
                checkSpeed.start();
                for (int x = 0; x < route.size() - 1; x++) {
                    statisticsLocomotive(file);
                    try {
                        System.out.println("Speed " + getname() + " = " + speed);
                        System.out.printf("%s in the city under %s\n", name, Graph.getVertexList(route.get(x)));
                        loadOrUnload(x);
                        synchronized (this) {
                            while (stop) {
                                wait();
                            }
                        }
                        sleep(2000);
                        Graph.blockRoad(route.get(x), route.get(x + 1));
                        System.out.printf("%s on the road between %s and %s\n", name, Graph.getVertexList(route.get(x)), Graph.getVertexList(route.get(x + 1)));
                        movement_between_stations(x);
                        System.out.printf("%s drove off the road between %s и %s\n", name, Graph.getVertexList(route.get(x)), Graph.getVertexList(route.get(x + 1)));
                        Graph.unblockRoad(route.get(x), route.get(x + 1));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(getname() + " traveled the whole route and will wait 30 seconds");
                checkSpeed.sleep(30_000);
                distanceTraveled_percent = 0;
                Collections.reverse(route);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public void debarkation() {
        //реализовать этот метод
        if (isLading) {
            unload_all_Wagons();
            isLading = false;
        } else {
            System.out.println("The " + getClass() + "has already been unloaded");
        }
    }

    @Override
    public void lading() {
        //реализовать этот метод
        if (!isLading) {
            fill_all_Wagons();
            isLading = true;

        } else {
            System.out.println("The " + getClass() + " is already loaded");
        }
    }

    public Wagon[] getWagony() {
        return wagony;
    }

    private void unload_all_Wagons() {
        for (Wagon wagon : wagony) {
            if (wagon != null) {
                wagon.debarkation();
                carrying_ton += wagon.getGross_weight();
            }
        }
    }

    private void fill_all_Wagons() {
        for (Wagon wagon : wagony) {
            if (wagon != null) {
                wagon.lading();
                carrying_ton -= wagon.getGross_weight();
            }
        }
    }

    public void addVagon(Wagon wagon) {
        if (wagon instanceof Electricity) {
            if (haveElectrickVagons == max_Electrick) {
                //throws new MaxElectrick();
                System.out.println("Can't add wagon");
            } else {
                wagony[countVagon++] = wagon;
                haveElectrickVagons++;
                carrying_ton -= wagon.getGross_weight() + wagon.getNet_weight();
                number_of_Wagons_in_the_locomotive++;
            }
        } else {
            wagony[countVagon++] = wagon;
            carrying_ton -= wagon.getGross_weight() + wagon.getNet_weight();
            number_of_Wagons_in_the_locomotive++;
        }
    }

    private void movement_between_stations(int x) {
        try {
            double distance_between_station = Graph.mas[route.get(x)][route.get(x + 1)];
            distance_between_station_persent = 0;
            while (distance_between_station_persent < 100) {//time != (Graph.mas[route.get(x)][route.get(x + 1)] / max_speed)
                sleep(1);
                distance_between_station_persent += ((speed * 0.001) / distance_between_station) * 100;
                distanceTraveled_percent += ((speed * 0.001) / allDistance) * 100;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static class RailroadHazard extends Throwable {
        RailroadHazard(String nameLocomotive) {
            super(String.format("Speed exceeded. %s locomotive crashed", nameLocomotive));
        }
    }

    public void statisticsLocomotive(File file) {
        try (FileOutputStream output = new FileOutputStream(file, false)) {
            output.write(toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkSpeed() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            double random = (Math.random() * 2);
            if (speed > 200) {
                try {
                    throw new RailroadHazard(name);
                } catch (RailroadHazard e) {
                    e.printStackTrace();
                }
            } else if (random > 1) {
                speed += 3;
            } else {
                speed -= 3;
            }
        }
    }

    private void loadOrUnload(int currentIndex) {
        if (currentIndex % 2 == 0) {
            lading();
        } else {
            debarkation();
        }
    }

    public void remoweWagon(Wagon wagon) {
        int count = 0;
        Wagon[] wagons = new Wagon[wagony.length];
        number_of_Wagons_in_the_locomotive--;
        if (wagon instanceof Electricity) {
            haveElectrickVagons--;
        }
        for (Wagon wagon1 : wagony) {
            if (wagon1 != wagon) {
                wagons[count++] = wagon1;
            }
        }
        wagony = wagons;
    }
}

