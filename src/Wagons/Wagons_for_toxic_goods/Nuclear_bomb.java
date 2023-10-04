package Wagons.Wagons_for_toxic_goods;

public class Nuclear_bomb {
    /**This is a Java class named "Nuclear_bomb" that describes a nuclear bomb object.

     The class has several private instance variables such as the mass of the bomb, its name, constructor,
     manufacturer, length, diameter, volume, and a password required to detonate the bomb.

     The class has a public static method called "getMassBomb_KG" that returns the mass of the bomb.

     The class also has a method called "detonate_the_bomb" that takes an integer parameter and checks if it matches the password required to detonate the bomb.
     If the password is correct, a message is printed indicating that the bomb has been defused. If the password is incorrect, a custom exception called "BIG_BOOM" is thrown.

     Finally, the class has an overridden "toString" method that returns a string representation of the object's state.*/
    private static final double massBomb_KG = 4400;

    public static double getMassBomb_KG() {
        return massBomb_KG;
    }

    private final String nameItem = "Little Boy ID:" + (int)(Math.random() * 2000);
    private final String constructor = "Los Alamos National Laboratory";
    private final String manufacturer = "National Security Center Y-12, Tennessee Eastman Company";
    private final double lenth_mm = 3000;
    private final double diametr_mm = 700;
    private final double volume_meters = ((lenth_mm * Math.PI * Math.pow(diametr_mm,2)) / 4.0) / 1_000_000.0;
    private final int password = 25_03_2001;

    void detonate_the_bomb(int password) {
        if(password == this.password){
            System.out.println("What a score. bomb defused");
        }else{
            try{
                throw new BIG_BOOM();
            }catch (BIG_BOOM e){
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public String toString() {
        return "\nNuclear_bomb{" +
                "nameItem='" + nameItem + '\'' +
                ", constructor='" + constructor + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", lenth_mm=" + lenth_mm +
                ", diametr_mm=" + diametr_mm +
                ", volume_meters=" + (int)volume_meters +
                ", password=" + password +
                '}';
    }

    int getPassword() {
        return password;
    }
}
