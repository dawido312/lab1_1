package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class ProductData extends Money {

    private String Id;

    private String Name;

    private Date SnapshotDate;

    private String Type;

    public String getProductId() {
        return Id;
    }

    public BigDecimal getProductPrice() {
        return getValue();
    }

    public String getProductName() {
        return Name;
    }

    public Date getProductSnapshotDate() {
        return SnapshotDate;
    }

    public String getProductType() {
        return Type;
    }

    ProductData(String Id, BigDecimal Price, String Name, Date SnapshotDate, String Type) {
        this.Id = Id;
        setValue(Price);
        this.Name = Name;
        this.SnapshotDate = SnapshotDate;
        this.Type = Type;
    }
}
