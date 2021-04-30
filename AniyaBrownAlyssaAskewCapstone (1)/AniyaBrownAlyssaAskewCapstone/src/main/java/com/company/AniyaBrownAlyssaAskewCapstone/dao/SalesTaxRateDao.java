package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import com.company.AniyaBrownAlyssaAskewCapstone.model.SalesTaxRate;

import java.math.BigDecimal;

public interface SalesTaxRateDao {
    BigDecimal getSalesTaxRate(String state);

    SalesTaxRate getSalesTaxRate2(String state);
}
