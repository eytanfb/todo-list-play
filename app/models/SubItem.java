package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
public class SubItem extends Model {
<<<<<<< HEAD
 
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
=======

  @Required
  public String content;

  @Required
  @ManyToOne
  public Item item;
  
  public boolean isComplete;

  public SubItem(String content, Item item){
    this.content = content;
    this.item = item;
  }

} 
>>>>>>> dev
