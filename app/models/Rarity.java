package models;

public enum Rarity
{
    Generic,
    Unusual,
    Rare,
    Epic,
    Superb;

    public float rarityCoeff() {
        switch(this) {
            case Generic:
                return 200;
            case Unusual:
                return 100;
            case Rare:
                return 50;
            case Epic:
                return 10;
            case Superb:
                return 5;
        }
        return 0;
    }

    @Override
    public String toString() {
        switch(this) {
            case Generic:
                return "generic";
            case Unusual:
                return "unusual";
            case Rare:
                return "rare";
            case Epic:
                return "epic";
            case Superb:
                return "superb";
        }
        return "unknown";
    }
};