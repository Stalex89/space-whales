package models;

import play.mvc.PathBindable;
import play.libs.F;
import java.util.*;
import play.data.format.*;
import play.data.validation.Constraints;
import javax.persistence.*;
import io.ebean.*;

@Entity
public class TShirt extends Model  implements PathBindable<TShirt> 
{

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

        public String toString() {
            switch(this) {
                case Generic:
                    return "Generic";
                case Unusual:
                    return "Unusual";
                case Rare:
                    return "Rare";
                case Epic:
                    return "Epic";
                case Superb:
                    return "Superb";
            }
            return "Unknown";
        }
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public Rarity rarity;

    public String pictureUrl;

    public String description;

    public TShirt(){}

    public TShirt(String name, Rarity rarity, String description)
    {
        this.name = name;
        this.rarity = rarity;
        pictureUrl = "";
        this.description = description;
    }

    public String toString() {
        return String.format("%s - %s - %s\\n", name, rarity, description);
    }

    // implementation of Pathbinding
    @Override
    public TShirt bind(String key, String value) {
        return findById(Long.parseLong(value));
    }
    
    @Override
    public String unbind(String key) {
        return "" + this.id;
    }
    
    @Override
    public String javascriptUnbind() {
        return "" + this.id;
    }

    // implementation of data access
    public static List<TShirt> findAll() {
        return find.all();
    }
    
    public static Finder<Long, TShirt> find = new Finder<>(TShirt.class);
        
    public static TShirt findById(Long id) {
        return find.query().where().eq("id", id).findOne();
    }

    public static void remove(TShirt tShirt) {
        tShirt.delete();
    }
}