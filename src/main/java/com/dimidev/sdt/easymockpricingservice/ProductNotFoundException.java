package com.dimidev.sdt.easymockpricingservice;

public class ProductNotFoundException extends Exception {

    private static final long serialVersionUID = -13283225970292847L;

    public ProductNotFoundException(String string) {
        super(string);
    }
}
