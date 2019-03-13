package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount extends Money {

    private String Cause;

    public String getDiscountCause() {
        return Cause;
    }

    Discount(String Cause, BigDecimal value) {
        this.Cause = Cause;
        setValue(value);
    }

}
