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

    @OneToMany
    public List<SubItem> subItems;
    
    public Item(String content) {
      this.content = content;
      this.subItems = new ArrayList<SubItem>();
    }

    public boolean allSubItemsComplete(){
      for(SubItem si: subItems){
        if(!si.isComplete)
          return false;
      }
      return true;
    }

    public void markAllSubItemsComplete(){
      for(SubItem si: subItems){
        si.isComplete = true;
        si.save();
      }
    }
}
