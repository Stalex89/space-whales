package models;

import java.math.BigDecimal;

public class Chest {

    String name;
    Tshirt[] tShirts;
    BigDecimal price;

    public Chest(){}
    public Chest(String name, Tshirt[] tShirts, BigDecimal price)
    {
        this.name = name;
        this.tShirts = tShirts;
        this.price = price;
    }
}
