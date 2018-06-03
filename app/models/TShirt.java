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

    enum Rarity
    {
        Generic,
        Unusual,
        Rare,
        Epic,
        Superb,
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