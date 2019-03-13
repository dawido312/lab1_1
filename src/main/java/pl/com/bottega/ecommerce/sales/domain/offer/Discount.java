package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    private String Cause;

    private BigDecimal value;

    public BigDecimal getDiscount() {
        return value;
    }

    public String getDiscountCause() {
        return Cause;
    }

    Discount(String Cause, BigDecimal value) {
        this.Cause = Cause;
        this.value = value;
    }

}
