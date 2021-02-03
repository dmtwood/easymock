package com.dimidev.sdt.easymockpricingservice;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class PricingServiceTests {

    private static final String ID = "32";
    private static final String BAD_ID = "-99";

    private IPricingService pricingService;
    private IDataAccess mockedDataAccess;

    @Before
    public void doBeforeEachTestCase() {
        pricingService = new PricingService();
        mockedDataAccess = createMock(IDataAccess.class);
        pricingService.setDataAccess(mockedDataAccess);
    }

    @Test
    public void getPrice() throws ProductNotFoundException {

        expect(mockedDataAccess.getPriceByID(ID)).andReturn(
                new BigDecimal(100));

        replay(mockedDataAccess);

        final BigDecimal price = pricingService.getPrice(ID);
        assertNotNull(price);

        verify(mockedDataAccess);
    }

    @Test(expected = ProductNotFoundException.class)
    public void getPriceNonExistentIDThrowsException()
            throws ProductNotFoundException {

        // instellen verwachtingen van mock
        expect(mockedDataAccess.getPriceByID(BAD_ID)).andReturn(null);

        // Mock in testing modus
        replay(mockedDataAccess);

        @SuppressWarnings("unused")
        final BigDecimal price = pricingService.getPrice(BAD_ID);

        verify(mockedDataAccess);
    }

    @Test
    public void getTweedeManier() throws ProductNotFoundException {

        // instellen verwachtingen van mock
        expect(mockedDataAccess.getPriceByID(BAD_ID)).andReturn(null);

        // Mock in testing modus
        replay(mockedDataAccess);

        try {
            @SuppressWarnings("unused")
            final BigDecimal price = pricingService.getPrice(BAD_ID);

            fail("Fout is niet opgetreden");
        } catch (ProductNotFoundException ex) {
            // eventueel assertion
        }

        verify(mockedDataAccess);
    }

    @Test(expected = RuntimeException.class)
    public void getPriceDataAccessThrowsRuntimeException()
            throws ProductNotFoundException {

        expect(mockedDataAccess.getPriceByID(ID)).andThrow(
                new RuntimeException("Fatal data access exception."));

        replay(mockedDataAccess);

        @SuppressWarnings("unused")
        final BigDecimal price = pricingService.getPrice(ID);
    }

}