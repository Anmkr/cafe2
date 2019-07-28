import model.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cafe {
    Barmen barmen = new Barmen();
    Table table = new Table();

    public void reservTable() throws IOException {
        barmen.printDialog();
        while (true) {
            int numberTable = table.numberOfTable();
            if (barmen.checkTable(numberTable)) {
                if (!barmen.isReserv(numberTable)) {
                    barmen.reservTable(numberTable);
                    break;
                } else {
                    barmen.isReserv(numberTable);
                    System.out.println(numberTable + " սեղանը զբաղված է");
                    continue;
                }
            } else {
                barmen.printDialog2();
                continue;
            }
        }
    }

    public void Order() throws IOException {
        barmen.dialogMenu();
        System.out.println("Մեր խմիչքների ցանկն է");
        for (Menu menu1 : Menu.values()) {
            System.out.println(menu1 + ":" + menu1.getPrice() + " դրամ");
        }
        System.out.println();
        String order = table.makeOrder();
        if (!order.equals(Menu.values())) {
            System.out.println(" Ձեր պահանջածը չկա մեզ մոտ:");
        }
        String order1 = table.makeOrder();
        barmen.takeOrderMenu(order1);

        System.out.println("Ձեր պատվերը ընդունված է");
        System.out.println("Էլ ի՞նչ եք պատվիրում:(Ոչ մի բան պատվիրելու դեպքում (no)");
        while (true) {


            String newOrder = table.makeOrder();

            if (newOrder.equals("no") || !newOrder.equals(Menu.values())) {
                System.out.println(" Ձեր հաշիվն է");
                barmen.printAccount();
                break;
            }
            barmen.takeOrderMenu(newOrder);
        }
    }

    public static void main(String[] args) throws IOException {

        Cafe cafe = new Cafe();
        cafe.reservTable();
        cafe.Order();
        while (true) {
            System.out.println("Բարև ձեզ: Ցանկանում եք սեղան պատվիրել:(yes or no)");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String order1 = reader.readLine();
            if (order1.equals("no")) {
                System.exit(0);

            }
            cafe.reservTable();
            cafe.Order();
        }
    }

}

