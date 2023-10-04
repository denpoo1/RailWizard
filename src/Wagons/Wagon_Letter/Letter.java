package Wagons.Wagon_Letter;

import java.text.DateFormat;
import java.util.Calendar;
import Wagons.Names_of_shipper;

class Letter {
    private String fromWhom;
    private String forWhom;
    private String now;
    private int id;
    private String nameShipper;

    Letter() {
        id = (int) ((Math.random() * 10_000) + 100);
        nameShipper = Names_of_shipper.randomMail();
        fromWhom = Names_of_shipper.randomName() + " " + Names_of_shipper.randomLastName();
        forWhom = Names_of_shipper.randomName() + " " + Names_of_shipper.randomLastName();
        now = DateFormat.getDateInstance().format(Calendar.getInstance().getTime());
    }
    @Override
    public String toString() {
        return "Letter{" +
                "fromWhom='" + fromWhom + '\'' +
                ", forWhom='" + forWhom + '\'' +
                ", now='" + now + '\'' +
                ", id=" + id +
                ", nameShipper='" + nameShipper + '\'' +
                '}';
    }
}
