package com.dimidev.sdt.easymockpricingservice;

import java.math.BigDecimal;

public interface IPricingService {
    void setDataAccess(IDataAccess dataAccess);

    BigDecimal getPrice(String id) throws ProductNotFoundException;
}
