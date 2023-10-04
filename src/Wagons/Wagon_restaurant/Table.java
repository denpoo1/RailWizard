package Wagons.Wagon_restaurant;

public class Table {
    private static byte tableNumber;
    private byte number = ++tableNumber;

    Order getOrder() {
        return new Order(number);
    }
}
