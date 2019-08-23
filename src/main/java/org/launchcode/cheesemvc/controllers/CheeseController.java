package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Cheesy Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        Cheese newCheese = new Cheese(cheeseName, cheeseDescription);
        cheeses.add(newCheese);
        return "redirect: ";
    }

    @RequestMapping(value="remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeses);
        return "cheese/remove";
    }

    @RequestMapping(value="remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam ArrayList<String> cheeseNameRemovalArrayList){

        /*Iterator i = cheeses.iterator();
        String str = "";
        while (i.hasNext()) {
            str = (String) i.next();
            if
        }*/
        for (String cheeseNameToRemove : cheeseNameRemovalArrayList) {
            for (Cheese cheese : cheeses) {
                if (cheese.getName().equals(cheeseNameToRemove)) {
                    cheeses.remove(cheese);
                }
            }
        }

        return "redirect: ";
    }
}
