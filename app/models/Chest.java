package models;

import play.mvc.PathBindable;
import java.math.BigDecimal;
import play.libs.F;
import java.util.*;
import play.data.format.*;
import play.data.validation.Constraints;
import javax.persistence.*;
import io.ebean.*;

@Entity
public class Chest extends Model implements PathBindable<Chest> 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Constraints.Required
    public String name;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<TShirt> tShirts = new ArrayList<TShirt>();

    @Constraints.Required
    public BigDecimal price;

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
        return String.format("%s - %s - %s", name, price, description);
    }

   // implementation of Pathbinding
   @Override
   public Chest bind(String key, String value) {
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
    public static List<Chest> findAll() {
    return find.all();
    }
    
    public static Finder<Long, Chest> find = new Finder<>(Chest.class);
        
    public static Chest findById(Long id) {
        return find.query().where().eq("id", id).findOne();
    }

    public static void remove(Chest chest) {
        chest.delete();
    }
}