import Graff.Map;
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
import Wagons.Wagons_for_passedgers.Wagon_for_passengers;
import Wagons.Wagons_for_toxic_goods.Wagon_for_toxic_goods;

import java.awt.*;
import java.awt.Menu;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Map.createGraff();
        MenuLocomotive menuLocomotive = new MenuLocomotive();
        menuLocomotive.menu();
    }
}