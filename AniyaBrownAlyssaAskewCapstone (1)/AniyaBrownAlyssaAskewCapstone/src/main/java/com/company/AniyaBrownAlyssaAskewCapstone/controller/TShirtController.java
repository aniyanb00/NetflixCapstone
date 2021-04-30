package com.company.AniyaBrownAlyssaAskewCapstone.controller;


import com.company.AniyaBrownAlyssaAskewCapstone.ServiceLayer.TShirtService;
import com.company.AniyaBrownAlyssaAskewCapstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TShirtController {

   @Autowired
   private TShirtService tShirtService;

    //create tshirt ->post
    @RequestMapping(value = "/TShirt", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TShirt createTShirt(@RequestBody @Valid TShirt tShirt) {

        return tShirtService.addTshirt(tShirt);
    }
    //Read (get  TShirt)

    @RequestMapping(value="/TShirt/{id}", method = RequestMethod.GET)
    @ResponseStatus(value =HttpStatus.OK)
    public TShirt getTShirt(@PathVariable int id){
        return tShirtService.getTshirt(id);
    }
    //get all TShirt
    @RequestMapping(value = "/TShirt", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getAllTShirt( ){

        List<TShirt> allTshirt = tShirtService.getAllTshirts( );
        if(allTshirt == null){
            throw new IllegalArgumentException("no t-shirt found");
        }
        return allTshirt;

    }
    //update tshirt
    @RequestMapping(value = "/TShirt", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTShirt(@RequestBody TShirt tShirt){
        tShirtService.updateTshirt(tShirt);

    }
//delete a TShirt
    @RequestMapping(value = "/TShirt/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id){
         tShirtService.deleteTshirt(id);
    }
    //get by Color
    @RequestMapping(value="/TShirt", method = RequestMethod.GET)
    @ResponseStatus(value =HttpStatus.OK)
    public List<TShirt> getConsoleByColor(@RequestParam String color){
        return tShirtService.getbyColor(color);
    }
    //get by size
    @RequestMapping(value="/TShirt", method = RequestMethod.GET)
    @ResponseStatus(value =HttpStatus.OK)
    public List<TShirt> getConsoleBySize(@RequestParam String size){
        return tShirtService.getbySize(size);
    }
}
