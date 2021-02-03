package com.dimidev.sdt.easymockpricingservice;

import java.math.BigDecimal;

public interface IDataAccess {
    BigDecimal getPriceByID(String ID);
}
