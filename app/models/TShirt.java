package models;

import play.data.validation.Constraints;

public class TShirt
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
    String name;
    Size size;
    Gender gender;
    Rarity rarity;
    String description;

    public TShirt(){}

    public TShirt(Size size, String name, Gender gender, Rarity rarity, String description)
    {
        this.name = name;
        this.size = size;
        this.gender = gender;
        this.rarity = rarity;
        this.description = description;
    }

    public String toString()
    {
        return String.format("%s - %s - %s - %s - %s\\n", name, size, gender, rarity, description);
    }
}