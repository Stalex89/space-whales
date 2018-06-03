package models;

import java.math.BigDecimal;
import play.libs.F;
import java.util.*;
import play.data.format.*;
import play.data.validation.Constraints;
import javax.persistence.*;
import io.ebean.*;

@Entity
public class Chest extends Model
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Constraints.Required
    String name;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<TShirt> tShirts = new ArrayList<TShirt>();

    @Constraints.Required
    BigDecimal price;

    public String pictureUrl;

    public String description;


    public Chest(){}
    public Chest(String name, List<TShirt> tShirts, BigDecimal price, String description)
    {
        this.name = name;
        this.tShirts = tShirts;
        this.price = price;
        pictureUrl = "";
        this.description = description;
    }

    public String toString() {
        return String.format("%s - %s - %s\\n", name, price, description);
    }

    // implementation of data access
    public static List<Chest> findAll() {
    return find.all();
    }
    
    public static Finder<Long, Chest> find = new Finder<>(Chest.class);
        
    public static Chest findById(Long id) {
        return find.query().where().eq("id", id).findOne();
    }

    public static void remove(Chest tShirt) {
        tShirt.delete();
    }
}