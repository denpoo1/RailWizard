import Graff.Graph;
import Graff.Vetrex;
import Locomotive.Locomotive;
import Statistics.StatisticsTrain;
import Wagons.Wafon_for_loquids.Wagon_for_liquids;
import Wagons.Wagon_Fridge.Wagon_Fridge;
import Wagons.Wagon_Letter.Wagon_Letter;
import Wagons.Wagon_for_Bagadge.Wagon_for_Bagaze;
import Wagons.Wagon_for_Gas.Wagon_Gas;
import Wagons.Wagon_for_explosive.Wagon_for_explosive_goods;
import Wagons.Wagon_for_liquid_toxic.Wagon_for_liquid_toxic;
import Wagons.Wagon_restaurant.Wagon_restaurant;
import Wagons.Wagons_for_passengers.Wagon_for_passengers;
import Wagons.Wagons_for_toxic_goods.Wagon_for_toxic_goods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MenuLocomotive {
    /**This is a Java code that defines a class named MenuLocomotive that handles a menu-driven command-line interface for adding and removing wagons,
     * locomotives, paths, and cities in a train network.

     The MenuLocomotive class has several private fields, including a StatisticsTrain object,
     an ArrayList of Locomotive objects, and a Scanner object to read user input.
     The class has a public method called menu() that presents a list of options to the user and executes the appropriate action based on their input.

     The user can select the following options from the menu:

     add a locomotive (c)
     remove a locomotive (v)
     add a wagon to a locomotive (d)
     remove a wagon from a locomotive (e)
     add a path (r)
     remove a path (t)
     add a city (y)
     remove a city (u)
     run the program (z)
     stop the program (p)
     The createWagon() method allows the user to create a new wagon and add it to a specific locomotive.
     It prompts the user to select a locomotive from the list of available locomotives and then presents a list of wagon types to choose from.
     Depending on the user's selection, it creates a new wagon object of the appropriate type and adds it to the selected locomotive's list of wagons.

     Other methods such as remoweWagon(), createLocomotive(), remoweLocomotive(), startProgram(), stopProgram(), createEdge(), createCity(), remoweEdge(),
     and remoweCity() handle other actions on the train network.*/
    private StatisticsTrain statisticsTrain = new StatisticsTrain();
    private ArrayList<Locomotive> locomotives = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        boolean startThread = false;
        while (!startThread) {
            System.out.println("c - add locomotive\n" +
                    "v - remove locomotive\n" +
                    "d - add wagon\n" +
                    "e - delete wagon\n" +
                    "r - add path\n" +
                    "t - delete path\n" +
                    "y - add city\n" +
                    "u - delete city\n" +
                    "z - run the program\n" +
                    "p - stop the program");
            char letter = scanner.next().charAt(0);
            switch (letter) {
                case 'd':
                    createWagon();
                    break;
                case 'e':
                    remoweWagon();
                    break;

                case 'c':
                    createLocomotive();
                    break;

                case 'v':
                    remoweLocomotive();
                    break;

                case 'z':
                    startProgram();
                    break;

                case 'p':
                    stopProgram();
                    break;

                case 'r':
                    createEdge();
                    break;

                case 'y':
                    createCity();
                    break;

                case 't':
                    remoweEdge();
                    break;

                case 'u':
                    remoweCity();
                    break;

                default:
                    System.out.println("You entered the wrong character. try again");
            }
        }
    }

    private void createWagon() {
        int count = 0;
        for (Locomotive locomotive1 : locomotives) {
            if (locomotive1 != null) System.out.println(count++ + " Locomotive:" + locomotive1.getname());
        }
        System.out.println("select the locomotive to which you want to add the wagon(write the index starting from zero)");
        int numberLocomotive = scanner.nextInt();
        System.out.println("select the type of wagon you want to add to locomotive " + locomotives.get(numberLocomotive) + " (index)");
        System.out.println("1.Wagon for Liquids");
        System.out.println("2.Wagon for Bagadge and Wagon for passengers");
        System.out.println("3.Wagon for Explosive");
        System.out.println("4.Wagon for Gas");
        System.out.println("5.Wagon for Liquid toxic");
        System.out.println("6.Wagon Fridge");
        System.out.println("7.Wagon Letter");
        System.out.println("8.Wagon Restaurant");
        System.out.println("9.Wagon for Toxic goods");
        int numberWagon = scanner.nextInt();
        switch (numberWagon) {
            case 1:
                Wagon_for_liquids wagon_for_liquids = new Wagon_for_liquids();
                locomotives.get(numberLocomotive).addVagon(wagon_for_liquids);
                break;
            case 2:
                Wagon_for_Bagaze wagon_for_bagaze = new Wagon_for_Bagaze();
                Wagon_for_passengers wagon_for_passengers = new Wagon_for_passengers(wagon_for_bagaze);
                locomotives.get(numberLocomotive).addVagon(wagon_for_bagaze);
                locomotives.get(numberLocomotive).addVagon(wagon_for_passengers);
                break;
            case 3:
                Wagon_for_explosive_goods wagon_for_explosive_goods = new Wagon_for_explosive_goods();
                locomotives.get(numberLocomotive).addVagon(wagon_for_explosive_goods);
                break;
            case 4:
                Wagon_Gas wagon_gas = new Wagon_Gas();
                locomotives.get(numberLocomotive).addVagon(wagon_gas);
                break;
            case 5:
                Wagon_for_liquid_toxic wagon_for_liquid_toxic = new Wagon_for_liquid_toxic();
                locomotives.get(numberLocomotive).addVagon(wagon_for_liquid_toxic);
                break;
            case 6:
                Wagon_Fridge wagon_fridge = new Wagon_Fridge();
                locomotives.get(numberLocomotive).addVagon(wagon_fridge);
                break;
            case 7:
                Wagon_Letter wagon_letter = new Wagon_Letter();
                locomotives.get(numberLocomotive).addVagon(wagon_letter);
                break;
            case 8:
                Wagon_restaurant wagon_restaurant = new Wagon_restaurant(locomotives.get(numberLocomotive).getname());
                locomotives.get(numberLocomotive).addVagon(wagon_restaurant);
                wagon_restaurant.start_Restaurant();
                break;
            case 9:
                Wagon_for_toxic_goods wagon_for_toxic_goods = new Wagon_for_toxic_goods();
                locomotives.get(numberLocomotive).addVagon(wagon_for_toxic_goods);
                break;
        }
        System.out.println("wagon created");
    }

    private void remoweWagon() {
        int count2 = 0;
        for (Locomotive locomotive1 : locomotives) {
            if (locomotive1 != null) System.out.println(count2++ + " Locomotive:" + locomotive1.getname());
        }
        System.out.println("select the locomotive to which you want to remowe the wagon(write the index starting from zero)");
        int numberLocomotive1 = scanner.nextInt();
        System.out.println();
        System.out.println(Arrays.toString(locomotives.get(numberLocomotive1).getWagony()));
        System.out.println("select the wagon you want to delete(write the index starting from zero)");
        int indexRemowe = scanner.nextInt();
        locomotives.get(numberLocomotive1).remoweWagon(locomotives.get(numberLocomotive1).getWagony()[indexRemowe]);
        System.out.println("wagon removed");
    }

    private void createLocomotive() {
        System.out.println("Give your locomotive a name");
        String name = scanner.next();
        System.out.println("Give the maximum number of wagons in the locomotive");
        int maxWagons = scanner.nextInt();
        System.out.println("Give the city from which the locomotive will start its journey");
        String departure = scanner.next();
        System.out.println("Give the city where the locomotive should arrive");
        String arrive = scanner.next();
        System.out.println("Give the load capacity of the locomotive");
        int carryingTon = scanner.nextInt();
        Locomotive locomotive = new Locomotive(name, maxWagons, departure, arrive, carryingTon);
        locomotives.add(locomotive);
        System.out.println("Locomotive " + name + " created");
    }

    private void remoweLocomotive() {
        int count1 = 0;
        for (Locomotive locomotive1 : locomotives) {
            if (locomotive1 != null) System.out.println(count1++ + " Locomotive:" + locomotive1.getname());
        }
        System.out.println("Select the locomotive you want to delete(write the index starting from zero)");
        int indexRemoweLocomotive = scanner.nextInt();
        System.out.println("locomotive " + locomotives.get(indexRemoweLocomotive).getname() + " removed");
        locomotives.remove(indexRemoweLocomotive);
    }

    private void startProgram() {
        System.out.println("Program started");
        for (Locomotive locomotive2 : locomotives) {
            locomotive2.start();
            StatisticsTrain.addStatistics(locomotive2);
            statisticsTrain.start();
        }
    }

    private void stopProgram() {
        System.out.println("Program stopped");
        System.exit(0);
    }

    private void createEdge() {
        int count3 = 0;
        for (Vetrex vetrex : Graph.getVertexList()) {
            if (vetrex != null) {
                System.out.println(count3++ + " " + vetrex.getCity());
            }
        }
        System.out.println("Write two indices of the cities you want to connect and indicate how many kilometers between them");
        System.out.println("Index 1:");
        int index1 = scanner.nextInt();
        System.out.println("Index 2:");
        int index2 = scanner.nextInt();
        System.out.println("Kilometers between");
        int kilometers = scanner.nextInt();
        Graph.addEdge(index1, index2, kilometers);
        System.out.println("edge created");
    }

    private void createCity() {
        System.out.println("Enter the name of the new city:");
        String city = scanner.next();
        Graph.addVetrexMenu(city);
        System.out.println("city created");
    }

    private void remoweEdge() {
        int count4 = 0;
        for (int x = 0; x < Graph.mas.length; x++) {
            for (int y = 0; y < Graph.mas[x].length; y++) {
                if (Graph.mas[x][y] != 0 && Graph.getVertexList()[x] != null && Graph.getVertexList()[y] != null) {
                    System.out.printf("%s (index : %d) -> %s (index : %d) : %d%n", Graph.getVertexList()[x].getCity(), x, Graph.getVertexList()[y].getCity(), y, Graph.mas[x][y]);
                }
            }
            System.out.println();
        }
        System.out.println("Specify two indexes and the route will be deleted");
        System.out.println("Index 1 :");
        int city1 = scanner.nextInt();
        System.out.println("Index 2 :");
        int city2 = scanner.nextInt();
        Graph.mas[city1][city2] = 0;
        Graph.mas[city2][city1] = 0;
        System.out.println("edge removed");
    }

    private void remoweCity() {
        int count5 = 0;
        for (Vetrex vetrex : Graph.getVertexList()) {
            if (vetrex != null) {
                System.out.println(count5++ + " " + vetrex.getCity());
            }
        }
        System.out.println("Enter city you want to delete");
        int indexCity = scanner.nextInt();
        Graph.removeVertexMenu(indexCity);
        System.out.println("city removed");
    }
}
