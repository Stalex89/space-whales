package models;

import play.mvc.PathBindable;
import play.libs.F;
import java.util.*;
import play.data.format.*;
import play.data.validation.Constraints;
import javax.persistence.*;
import io.ebean.*;

@Entity
public class Place extends Model implements PathBindable<Place> {
    // persistence
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // validation
    @Constraints.Required
    public String name;

    @Constraints.Required
    public String country;

    @Constraints.Required
    public String location;

    public String description;
    
    public byte[] picture;

    public int rating;

    public Place() {
        this(null, null, null);
    }
    
    public Place(String n, String co, String loc) {
       this(n, co, loc, "");
    }

    public Place(String n, String co, String loc, String desc) {
        name = n;
        country = co;
        location = loc;
        description = desc;

        picture = null;
        rating = 0;
    }
    
    // supporting methods
    public String toString() {
        return String.format("%s, %s, %s (rating=%d)\n  %s", name, country, location, rating, description);
    }
    

    // implementation of Pathbinding
    @Override
    public Place bind(String key, String value) {
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
    public static List<Place> findAll() {
        return find.all();
    }

    public static Finder<Long, Place> find = new Finder<>(Place.class);
    
    public static Place findById(Long id) {
        return find.query().where().eq("id", id).findOne();
    }

    public static void remove(Place stud) {
        stud.delete();
    }


/*
    other validators
    @Required
    @Min / @Max, np. @Min(3)
    @MinLenght / @MaxLenght
    @Pattern
    @ValidateWidth
    @Email
*/
}
    
    
