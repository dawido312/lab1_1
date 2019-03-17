package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    private Money value = new Money();

    private String Cause;

    public String getDiscountCause() {
        return Cause;
    }

    Discount(String Cause, BigDecimal value) {
        this.Cause = Cause;
        this.value.setValue(value);
    }

}
