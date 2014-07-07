package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
      List<Item> items = Item.findAll();
      render(items);
    }
    
    public static void addItem(@Required String item) {
      if(validation.hasErrors()){
        List<Item> items = Item.findAll();
        render("Application/index.html", items);
      }
      new Item(item).save();
      index();
    } 

    public static void markComplete(Long id, boolean isComplete) {
      Item item = Item.findById(id);
      item.isComplete = isComplete;
      item.save();
      index();
    }

}
