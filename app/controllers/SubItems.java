package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class SubItems extends Application {

    public static void addSubItem(@Required(message="Missing content") String content, @Required(message="Missing id") Long itemId) {
      Item item = Item.findById(itemId);
      if(validation.hasErrors()){
        render("Items/show.html", item);
      }
      item.subItems.add(new SubItem(content, item));
      item.isComplete = false;
      item.save();
      Items.show(itemId);
    } 

    public static void markComplete(Long id, boolean isComplete) {
      SubItem subItem = SubItem.findById(id);
      subItem.isComplete = isComplete;
      subItem.save();
      Items.show(subItem.item.id);
    }
}

