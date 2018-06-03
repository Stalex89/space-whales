package models;

import java.math.BigDecimal;

public class Chest {

    String name;
    TShirt[] tShirts;
    BigDecimal price;

    public Chest(){}
    public Chest(String name, TShirt[] tShirts, BigDecimal price)
    {
        this.name = name;
        this.tShirts = tShirts;
        this.price = price;
    }
}