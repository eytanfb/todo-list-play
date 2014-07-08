package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
public class SubItem extends Model {
 
    @Required
    @ManyToOne
    public Item item;

    @Required
    public String content;
    public boolean isComplete = false;
    
    public SubItem(String content, Item item) {
      this.content = content;
      this.item = item;
    }
 
}
