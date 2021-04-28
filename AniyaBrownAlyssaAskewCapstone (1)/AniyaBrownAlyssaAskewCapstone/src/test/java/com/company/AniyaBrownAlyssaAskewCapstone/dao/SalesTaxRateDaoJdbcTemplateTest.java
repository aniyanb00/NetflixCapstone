package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateDaoJdbcTemplateTest {

    @Autowired
    protected SalesTaxRateDao salesTaxRateDao;

    @Test
    public void getSalesTaxRateDao( ){
        String state = "VA";
        BigDecimal expectedRate = salesTaxRateDao.getSalesTaxRate(state);
        assertEquals(expectedRate, new BigDecimal("0.06"));
    }
}