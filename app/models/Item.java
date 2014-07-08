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

    @OneToMany(mappedBy="item", cascade=CascadeType.ALL)
    public List<SubItem> subItems;
    
    public Item(String content) {
      this.content = content;
      subItems = new ArrayList<SubItem>();
    }
}
