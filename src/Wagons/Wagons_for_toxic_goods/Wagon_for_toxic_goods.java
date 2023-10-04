package Wagons.Wagons_for_toxic_goods;

import Locomotive.Locomotive;
import Wagon.Wagon_for_heavy_goods;
import Wagons.Names_of_shipper;

import java.util.Arrays;
import java.util.Scanner;

public class Wagon_for_toxic_goods extends Wagon_for_heavy_goods {
    /**This is a Java code for a class named "Wagon_for_toxic_goods" which extends another class "Wagon_for_heavy_goods".
     * It also imports classes "Locomotive" and "Names_of_shipper" from packages "Locomotive" and "Wagons", respectively,
     * and class "Nuclear_bomb" from package "Wagons.Wagons_for_toxic_goods". The code has the following properties and methods:

     Properties:

     "isLading": a boolean variable that indicates whether the wagon is loaded or not.
     "mass_all_Bombs_Ton": a double variable that stores the total mass of all the bombs loaded on the wagon in tons.
     "bombs": an array of type "Nuclear_bomb" that can store up to five nuclear bombs.
     Constructors:

     A default constructor that calls the constructor of the superclass "Wagon_for_heavy_goods" with a randomly selected item from the enum "Names_of_shipper.randomItemsToxic()" as an argument.
     Methods:

     "lading()": a method that loads the wagon with five randomly generated instances of the "Nuclear_bomb" class. It also sets the "isLading" variable to true and updates the "gross_weight" of the wagon.
     "debarkation()": a method that unloads the wagon and sets the "isLading" variable to false.
     If the wagon was loaded and a random event occurs (with a probability of 1 in 10,000), the method calls the "gameBombs()" method with a randomly selected bomb from the "bombs" array.
     "Random_detonate_the_bomb()": a method that randomly selects and returns a bomb from the "bombs" array. If the wagon is not loaded, it prints a message and returns null.
     "gameBombs()": a method that simulates a game where the user has five attempts to enter the correct password for a given nuclear bomb.
     If the password is incorrect, the method prompts the user to try again until five attempts are exhausted. If the user enters the correct password, the bomb is defused. Otherwise, the bomb explodes and the program terminates.
     "toString()": a method that returns a string representation of the wagon object, including the values of its properties.*/
    private boolean isLading = false;
    private double mass_all_Bombs_Ton = 0;
    private final Nuclear_bomb[] bombs = new Nuclear_bomb[5];


    public Wagon_for_toxic_goods() {
        super(Names_of_shipper.randomItemsToxic());
    }

    @Override
    public void debarkation() {
        if (isLading) {
            if ((int)(Math.random() * 10_000) == 1) {
                Locomotive.stop = true;
                gameBombs(Random_detonate_the_bomb());
                Locomotive.stop = false;
            }
                Arrays.fill(bombs, null);
                mass_all_Bombs_Ton = 0;
                isLading = false;
            } else {
                System.out.println("The " + getClass() + "has already been unloaded");
            }
        }

    @Override
    public void lading() {
        if (!isLading) {
            for (int x = 0; x < bombs.length; x++) {
                bombs[x] = new Nuclear_bomb();
                mass_all_Bombs_Ton += Nuclear_bomb.getMassBomb_KG() / 1000.0;
            }
            isLading = true;
            setGross_weight(mass_all_Bombs_Ton);
        } else {
            System.out.println("The " + getClass() + " is already loaded");
        }
    }

    public Nuclear_bomb Random_detonate_the_bomb() {
        if (isLading) {
            return bombs[(int) (Math.random() * bombs.length)];
        } else {
            System.out.println("first you need to load the wagon");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Wagon_for_toxic_goods{" +
                "isLading=" + isLading +
                ", mass_all_Bombs_Ton=" + mass_all_Bombs_Ton +
                ", bombs=" + Arrays.toString(bombs) +
                '}';
    }

    void gameBombs(Nuclear_bomb nuclear_bomb) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("While unloading, one of the cranes dropped a bomb and you heard the timer.\nYou have five attempts to enter the password. \nIf it fails, the bomb will explode:\n" +
                "Password:");
        for (int x = 0; x < 5; x++) {
            int password = scanner.nextInt();
            if (password != nuclear_bomb.getPassword()) {
                System.out.printf("the password is wrong. You have %d attempts left.\nPassword:", 5 - (x + 1));
            } else {
                nuclear_bomb.detonate_the_bomb(25032001);
                return;
            }
        }
        nuclear_bomb.detonate_the_bomb(1);
        System.exit(0);
    }
}
