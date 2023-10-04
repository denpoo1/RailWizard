import Graff.Map;

public class Main {
    public static void main(String[] args) {
        Map.createGraff();
        MenuLocomotive menuLocomotive = new MenuLocomotive();
        menuLocomotive.menu();
    }
}