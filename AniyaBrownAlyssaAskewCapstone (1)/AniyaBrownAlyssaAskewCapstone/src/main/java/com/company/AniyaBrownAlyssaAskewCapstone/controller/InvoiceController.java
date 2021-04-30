package com.company.AniyaBrownAlyssaAskewCapstone.controller;


import com.company.AniyaBrownAlyssaAskewCapstone.model.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceController {
    //create Invoice ->post
    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody @Valid Invoice invoice) {
        return InvoiceService.saveInvoice(invoice);
    }
    //Read (get Invoice)

    @RequestMapping(value="/invoice/{id}", method = RequestMethod.GET)
    @ResponseStatus(value =HttpStatus.OK)
    public Invoice getInvoice(@PathVariable int id){
        return InvoiceService.findInvoice(id);
    }
    //get all Invoice
    @RequestMapping(value = "/invoice", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getAllInvoice(){

        return InvoiceService.getAllInvoices();

    }
    //update invoice
      @RequestMapping(value = "/invoice", method = RequestMethod.PUT)
        @ResponseStatus(value = HttpStatus.OK)
        public void updateInvoice(@PathVariable Invoice invoice){
           return InvoiceService.updateInvoice(invoice);

      }
//delete a Invoice
    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable int id){
        return InvoiceService.removeInvoice(id);
    }
    //get by Customer name
    @RequestMapping(value="/invoice/{name}", method = RequestMethod.GET)
    @ResponseStatus(value =HttpStatus.OK)
    public Invoice getInvoiceByCustomerName(@PathVariable String name){
        return InvoiceService.findInvoiceByCustomerName(name);
    }
    //get by size
    @RequestMapping(value="/invoice/{size}", method = RequestMethod.GET)
    @ResponseStatus(value =HttpStatus.OK)
    public Invoice getInvoiceBySize(@PathVariable String size){
        return InvoiceService.findInvoiceBySize(size);
    }


}
