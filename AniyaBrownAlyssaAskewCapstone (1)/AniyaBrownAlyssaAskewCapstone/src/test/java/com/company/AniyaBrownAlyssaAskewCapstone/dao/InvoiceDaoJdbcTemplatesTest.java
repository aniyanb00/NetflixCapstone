package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import com.company.AniyaBrownAlyssaAskewCapstone.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoJdbcTemplatesTest {

    @Autowired
    protected InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception{
        List<Invoice> iList = invoiceDao.getAllInvoices();
        for (Invoice i:iList){
            invoiceDao.deleteInvoice(i.getInvoiceId());
        }
    }
    @Test
    public void addGetDeleteInvoice(){
        Invoice invoice = new Invoice();
        invoice.setName("Jake");
        invoice.setStreet("Wood Pine Drive");
        invoice.setCity("Newport News");
        invoice.setState("Virginia");
        invoice.setZipcode("23064");
        invoice.setItemType("game");
        invoice.setItemId(2784);
        invoice.setUnitPrice(new BigDecimal("14.99"));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("14.99"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("17.38"));

        //Act
        invoice = invoiceDao.addInvoice(invoice);
        Invoice invoice2 = invoiceDao.getInvoice(invoice.getInvoiceId());

        //assert
        assertEquals(invoice2,invoice);

        //assertEquals(invoice2,invoice);

        //Act
        invoiceDao.deleteInvoice(invoice.getInvoiceId());
        invoice2 = invoiceDao.getInvoice(invoice.getInvoiceId());

        //Assert
        assertNull(invoice2);
    }
    @Test
    public void getAllInvoices(){
        Invoice invoice = new Invoice();
        invoice.setName("Jake");
        invoice.setStreet("Wood Pine Drive");
        invoice.setCity("Newport News");
        invoice.setState("Virginia");
        invoice.setZipcode("23064");
        invoice.setItemType("game");
        invoice.setItemId(2784);
        invoice.setUnitPrice(new BigDecimal("14.99"));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("14.99"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("17.38"));
        //Act
        invoice = invoiceDao.addInvoice(invoice);
        invoice = new Invoice();
        invoice.setName("Ryan");
        invoice.setStreet("Willsbury Road");
        invoice.setCity("Williamsburg");
        invoice.setState("Virginia");
        invoice.setZipcode("23164");
        invoice.setItemType( "console");
        invoice.setItemId(123 );
        invoice.setUnitPrice(new BigDecimal("14.99"));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("14.99"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("17.38"));
        //Act
        invoice = invoiceDao.addInvoice(invoice);
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        //Assert
        assertEquals(invoiceList.size(), 2);
    }
    @Test
    public void getInvoicesByCustomerName(){
        Invoice invoice = new Invoice();
        invoice.setName("Jake");
        invoice.setStreet("Wood Pine Drive");
        invoice.setCity("Newport News");
        invoice.setState("Virginia");
        invoice.setZipcode("23064");
        invoice.setItemType("game");
        invoice.setItemId(2784);
        invoice.setUnitPrice(new BigDecimal("14.99"));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("14.99"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("17.38"));
        invoice = invoiceDao.addInvoice(invoice);
        List<Invoice> iList = invoiceDao.getInvoicesByCustomerName(invoice.getName());
        assertEquals(1,iList.size());
    }

    @Test
    public void updateInvoice(){
        Invoice invoice = new Invoice();
        invoice.setName("Jake");
        invoice.setStreet("Wood Pine Drive");
        invoice.setCity("Newport News");
        invoice.setState("Virginia");
        invoice.setZipcode("23064");
        invoice.setItemType("game");
        invoice.setItemId(2784);
        invoice.setUnitPrice(new BigDecimal("14.99"));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("14.99"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("17.38"));
        //Act
        invoice = invoiceDao.addInvoice(invoice);
        //Arrange
        invoice.setCity("Richmond");
        invoice.setStreet("Walker Road");
        invoice.setZipcode("23426");

        //Act
        invoiceDao.updateInvoice(invoice);
        Invoice invoice2 = invoiceDao.getInvoice(invoice.getInvoiceId());

        //assert
        assertEquals(invoice2,invoice);
    }
}

