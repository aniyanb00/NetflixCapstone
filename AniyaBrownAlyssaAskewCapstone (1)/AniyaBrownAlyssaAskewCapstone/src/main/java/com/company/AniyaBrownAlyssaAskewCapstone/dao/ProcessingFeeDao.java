package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import com.company.AniyaBrownAlyssaAskewCapstone.model.ProcessingFee;

import java.math.BigDecimal;

public interface ProcessingFeeDao {

    BigDecimal getProcessingFee(String productType);


}
