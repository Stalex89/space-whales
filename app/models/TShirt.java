package models;


import play.libs.F;
import java.util.*;
import play.data.format.*;
import play.data.validation.Constraints;
import javax.persistence.*;
import io.ebean.*;

@Entity
public class TShirt extends Model
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public Size size;

    @Constraints.Required
    public Gender gender;

    @Constraints.Required
    public Rarity rarity;

    public String pictureUrl;

    public String description;

    public TShirt(){}

    public TShirt(Size size, String name, Gender gender, Rarity rarity, String description)
    {
        this.name = name;
        this.size = size;
        this.gender = gender;
        this.rarity = rarity;
        pictureUrl = "";
        this.description = description;
    }

    public String toString() {
        return String.format("%s - %s - %s - %s - %s\\n", name, size, gender, rarity, description);
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