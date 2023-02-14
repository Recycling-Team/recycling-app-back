package com.recycleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.recycleapp.model.ItemRepository;
import com.recycleapp.model.Item;

@CrossOrigin
@Controller
public class ItemController {
    @Autowired
    private ItemRepository Irepository;

    // listaa
    @RequestMapping(value = { "/itemlist" })
    public String ItemList(Model model) {
        model.addAttribute("items", Irepository.findAll());
        return "Itemlist";
    }

    // Listaa kaikki itemit REST avulla
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public @ResponseBody List<Item> itemListRest() {
        return (List<Item>) Irepository.findAll();
    }

    // tallentaa
    @RequestMapping(value = "/saveitem", method = RequestMethod.POST)
    public String save(Item item) {
        System.out.println("TEST" + item);
        Irepository.save(item);
        return "redirect:itemlist";
    }

}
