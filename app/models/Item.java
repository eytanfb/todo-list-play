package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
public class Item extends Model {
 
    @Required
    public String content;
    public boolean isComplete = false;
    
    public Item(String content) {
      this.content = content;
    }
 
}
