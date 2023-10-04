package Wagons.Wagon_restaurant;

class Order {
    private long time;
    private byte tableNumber;

    Order(byte tableNumber) {
        time = (long) (Math.random() * 200);
        this.tableNumber = tableNumber;
    }

    long getTime() {
        return time;
    }

    byte getTableNumber() {
        return tableNumber;
    }
}