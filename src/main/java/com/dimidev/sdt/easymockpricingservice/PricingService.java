package com.dimidev.sdt.easymockpricingservice;

import java.math.BigDecimal;

public class PricingService implements IPricingService {
    private IDataAccess dataAccess;

    public PricingService() {
        super();
    }

    public PricingService(IDataAccess dataAccess) {
        super();
        this.dataAccess = dataAccess;
    }

    public void setDataAccess(IDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public BigDecimal getPrice(String id) throws ProductNotFoundException {
        BigDecimal price = this.dataAccess.getPriceByID(id);
        if (price == null) {
            throw new ProductNotFoundException("ID not found.");
        }
        return price;
    }
}
