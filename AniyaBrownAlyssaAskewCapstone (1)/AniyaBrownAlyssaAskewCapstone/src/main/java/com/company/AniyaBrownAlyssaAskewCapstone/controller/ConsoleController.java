package com.company.AniyaBrownAlyssaAskewCapstone.controller;

import com.company.AniyaBrownAlyssaAskewCapstone.ServiceLayer.ConsoleService;
import com.company.AniyaBrownAlyssaAskewCapstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class ConsoleController {
    @Autowired
    private ConsoleService consoleService;


    //create console ->post
    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console) {

        return consoleService.saveConsole(console);
    }
    //Read (get  console)

    @RequestMapping(value="/console/{id}", method = RequestMethod.GET)
    @ResponseStatus(value =HttpStatus.OK)
    public Console getConsole(@PathVariable int id){
        return consoleService.getConsole(id);
    }

    //get all console
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles( ){
       List<Console> allConsole = consoleService.getAllConsoles( );
       if(allConsole == null){
           throw new IllegalArgumentException("no console found");
       }
       return allConsole;

    }
    //update console
    @RequestMapping(value = "/console", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateConsole(@RequestBody Console console){
        consoleService.updateConsole(console);

    }
//delete a console
    @RequestMapping(value = "/console/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id){
         consoleService.deleteConsole(id);
    }

    //get by Manufacturer
    @RequestMapping(value="/console/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(value =HttpStatus.OK)
    public List<Console> getConsoleByManufacturer(@PathVariable String manufacturer){
        return consoleService.getConsolebyManufacturer(manufacturer);
    }



}


