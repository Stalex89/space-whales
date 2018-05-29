package models;

import play.data.validation.Constraints;

public class Tshirt
{
    enum Size
    {
        XS,
        S,
        M,
        L,
        XL,
        XXL,
    };

    enum Gender
    {
        Male,
        Female,
    };

    enum Rarity
    {
        Generic,
        Unusual,
        Rare,
        Epic,
        Superb,
    };


    int id;
    Size size;
    Gender gender;
    Rarity rarity;
    String description;

    public Tshirt(){}

    public Tshirt(Size size, Gender gender, Rarity rarity, String description)
    {
        this.size = size;
        this.gender = gender;
        this.rarity = rarity;
        this.description = description;
    }

    public String toString()
    {
        return String.format("%s - %s - %s - %s\\n", size, gender, rarity, description);
    }
}
