import model.Menu;

import java.util.*;

public class Barmen {
    private Map<Integer, ArrayList<String>> orders = new HashMap<>();
    private int reservTable;


    public void printDialog() {
        System.out.println(" Մենք ունենք 10 սեղան: Ո՞ր սեղանն եք նախընտրում:");
    }

    public void printDialog2() {
        System.out.println(" Այդ սեղանը բացակայում է: Մենք ունենք 10 սեղան: Ընտրեք 10-1 սեղանները:");
    }

    public boolean checkTable(int tableNumber) {
        return tableNumber > 0 && tableNumber <= 10 ? true : false;
    }

    public boolean isReserv(int number) {
        return this.orders.get(number) == null ? false : true;
    }

    public void reservTable(int tableNumber) {
        reservTable = tableNumber;
        orders.put(tableNumber, new ArrayList<>());
    }

    public void dialogMenu() {
        System.out.println("Ի՞նչ եք պատվիրում:");
    }

    public void takeOrderMenu(String menu) {
        List<String> menuOrder = orders.get(reservTable);
        int count = 0;
        for (String item : menuOrder) {
            if (item.equals(menu.toLowerCase())) {
                count++;
            }
        }
        if (count != 0) {
            String x = new String(count + " " + menu);
            //  menuOrder.remove(menu);
            menuOrder.add(menu.toLowerCase());
        }
        menuOrder.add(menu.toLowerCase());
    }


    public void printAccount() {
        for (Map.Entry<Integer, ArrayList<String>> map : orders.entrySet()) {
            System.out.println("Սեղան համար  " + map);

        }
    }

}


