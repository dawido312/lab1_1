package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public abstract class Money {

    private String currency;
    private BigDecimal value;

    Money(String currency, BigDecimal value) {
        this.currency = currency;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    Money() { };

}
