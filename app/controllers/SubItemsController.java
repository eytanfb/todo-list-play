package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class SubItemsController extends Application {

  public static void addItem(@Required String content, @Required Long itemId) {
      Item item = Item.findById(itemId);
      if(validation.hasErrors()){
        render("ItemsController/show.html", item);
      }
      SubItem subItem = new SubItem(content, item);
      subItem.save();
      item.subItems.add(subItem);
      item.isComplete = false;
      item.save();
      ItemsController.show(itemId);
    } 

    public static void markComplete(Long id, boolean isComplete) {
      SubItem subItem = SubItem.findById(id);
      subItem.isComplete = isComplete;
      subItem.save();
      if(subItem.item.allSubItemsComplete()){
        subItem.item.isComplete = true;
        subItem.item.save();
      } else {
        subItem.item.isComplete = false;
        subItem.item.save();
      }
      ItemsController.show(subItem.item.id);
    }
}


