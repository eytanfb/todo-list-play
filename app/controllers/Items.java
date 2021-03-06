package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Items extends Application {

    public static void addItem(@Required String content) {
      if(validation.hasErrors()){
        List<Item> items = Item.findAll();
        render("Application/index.html", items);
      }
      new Item(content).save();
      Application.index();
    } 

    public static void markComplete(Long id, boolean isComplete) {
      Item item = Item.findById(id);
      item.isComplete = isComplete;
      item.save();
      Application.index();
    }

    public static void show(Long id) {
      Item item = Item.findById(id);
      List<SubItem> subItems = item.subItems;
      render(item, subItems);
    }
}

