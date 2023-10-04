package Wagons.Wagon_for_explosive;

import java.util.Arrays;

public class Wooden_box {
    private Explosive[] explosives = new Explosive[40];
    private double mass_all_Explosive_KG = 0;
    public double getMass_all_Explosive_KG() {
        return mass_all_Explosive_KG;
    }
    public void fillWoodenBox() {
        for(int x = 0; x < explosives.length; x++) {
            int random = (int)(Math.random() * 3);
            switch (random){
                case 0 :
                    explosives[x] = new C4();
                    mass_all_Explosive_KG = explosives[x].getMass_gramm();
                    break;
                case 1 :
                    explosives[x] = new Dynamite();
                    mass_all_Explosive_KG = explosives[x].getMass_gramm();
                    break;
                case 2 :
                    explosives[x] = new Powder();
                    mass_all_Explosive_KG = explosives[x].getMass_gramm();
                    break;
            }
        }
    }
    public void unloadWoodenBox() {
        Arrays.fill(explosives, null);
        mass_all_Explosive_KG = 0;
    }

    @Override
    public String toString() {
        return "Wooden_box{" +
                "explosives=" + Arrays.toString(explosives) +
                ", mass_all_Explosive_KG=" + mass_all_Explosive_KG +
                '}';
    }
}
