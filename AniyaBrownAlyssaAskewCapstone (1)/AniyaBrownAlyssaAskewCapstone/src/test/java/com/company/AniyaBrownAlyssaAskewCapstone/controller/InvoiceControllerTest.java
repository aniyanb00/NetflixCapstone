package com.company.AniyaBrownAlyssaAskewCapstone.controller;

import com.company.AniyaBrownAlyssaAskewCapstone.ServiceLayer.InvoiceService;
import com.company.AniyaBrownAlyssaAskewCapstone.model.Invoice;
import com.company.AniyaBrownAlyssaAskewCapstone.viewModel.InvoiceViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Before;
import org.junit.Test;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import java.math.BigDecimal;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {
    @Autowired
    private MockMvc mockMvc;



    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private InvoiceService invoiceService;


    @Before
    public void setUp(){


    }
    @Before
    public void before() {
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
    @Test
    public void shouldReturnAllInvoicesInCollection() throws Exception {
        String outputJson = mapper.writeValueAsString(invoiceService);
        mockMvc.perform(
                get("/invoice"))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    public void shouldReturnNewInvoiceOnPostRequest() throws Exception {
        Invoice invoice = new Invoice();
        invoice.setName("Bill");
        invoice.setStreet("Pinetta Drive");
        invoice.setCity("Richmond");
        invoice.setState("VA");
        invoice.setZipcode("23164");
        invoice.setItemType("t-shirt");
        invoice.setItemId(1);
        invoice.setQuantity(1);
        //invoice.setInvoiceId(2);
        String inputJson = mapper.writeValueAsString(invoice);


        Invoice invoice2 = new Invoice();
        invoice2.setName("Mary");
        invoice2.setStreet("Willsbury Road");
        invoice2.setCity("Willamsburg");
        invoice2.setState("VA");
        invoice2.setZipcode("23164");
        invoice2.setItemType("game");
        invoice2.setItemId(4);

        invoice2.setQuantity(2);


       // String outputJson = mapper.writeValueAsString(invoice2);
        mockMvc.perform(
                post("/invoice")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)

        )
                .andDo(print())
                .andExpect(status().isCreated());
    }
    @Test
    public void shouldReturnInvoicesById() throws Exception {

        Invoice invoice = new Invoice();
        invoice.setName("Jill");
        invoice.setStreet("Wood Park Drive");
        invoice.setCity("Yorktown");
        invoice.setState("VA");
        invoice.setZipcode("23062");
        invoice.setItemType("game");
        invoice.setItemId(2);
        invoice.setQuantity(1);



        String outputJson = mapper.writeValueAsString(invoice);
        mockMvc.perform(
                get("/invoice/2"))
                .andDo(print())
                .andExpect(status().isOk());
              // .andExpect(content().json(outputJson));

    }
    @Test
    public void shouldUpdateReturn204StatusCode() throws Exception {
        Invoice invoice = new Invoice();
        invoice = new Invoice();
        invoice.setName("Ryan");
        invoice.setStreet("Willsbury Road");
        invoice.setCity("Williamsburg");
        invoice.setState("VA");
        invoice.setZipcode("23164");
        invoice.setItemType( "console");
        invoice.setItemId(3 );
        invoice.setQuantity(1);

        String inputJson = mapper.writeValueAsString(invoice);
        mockMvc.perform(
                put("/invoice")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)

        )
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(delete("/invoice/2"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
    @Test
    public void shouldReturnByCustomerName() throws Exception {
        Invoice invoice = new Invoice();
        invoice.setName("Jake");
        invoice.setStreet("Wood Pine Drive");
        invoice.setCity("Newport News");
        invoice.setState("VA");
        invoice.setZipcode("23064");
        invoice.setItemType("game");
        invoice.setItemId(2784);
        invoice.setUnitPrice(new BigDecimal("14.99"));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("14.99"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("17.38"));
        String outputJson = mapper.writeValueAsString(invoice);
        mockMvc.perform(
                get("/invoice/name/Jake"))
                .andDo(print())
                .andExpect(status().isOk());
               // .andExpect(content().json(outputJson));

    }



}
