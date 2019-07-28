package model;

public enum Menu {
    COLA(200),
    FANTA(300),
    COFFEE(300),
    TEA(400);


private int price;
    Menu(int i) {
        price=i;
    }


    public int getPrice(){
        return price;
    }
}
