/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class OfferItem {

    private int quantity;

    private ProductData product;

    private Discount discount;

    private Money totalCost = new Money();

    public OfferItem(ProductData product, int quantity) {
        this(product, quantity, null, null);
    }

    public OfferItem(ProductData product, int quantity, BigDecimal discount, String discountCause) {
        this.product = product;
        this.quantity = quantity;
        this.discount = new Discount(discountCause, discount);

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount);
        }

        this.totalCost.setValue(product.getProductPrice().multiply(new BigDecimal(quantity)).subtract(discountValue));
    }

    public String getCurrency() {
        return totalCost.getCurrency();
    }

    public BigDecimal getTotalCost() {
        return totalCost.getValue();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override public int hashCode() {
        return Objects.hash(totalCost.getCurrency(), discount, product, quantity, totalCost);
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OfferItem other = (OfferItem) obj;
        return Objects.equals(totalCost.getCurrency(), other.totalCost.getCurrency()) && Objects.equals(discount, other.discount) && Objects
                .equals(product, other.product) && quantity == other.quantity && Objects.equals(totalCost, other.totalCost);
    }

    public boolean sameAs(OfferItem other, double delta) {
        if (product.getProductPrice() == null) {
            if (other.product.getProductPrice() != null) {
                return false;
            }
        } else if (!product.getProductPrice().equals(other.product.getProductPrice())) {
            return false;
        }
        if (product.getProductName() == null) {
            if (other.product.getProductName() != null) {
                return false;
            }
        } else if (!product.getProductName().equals(other.product.getProductName())) {
            return false;
        }

        if (product.getProductId() == null) {
            if (other.product.getProductId() != null) {
                return false;
            }
        } else if (!product.getProductId().equals(other.product.getProductId())) {
            return false;
        }
        if (product.getProductType() != other.product.getProductType()) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getValue().compareTo(other.totalCost.getValue()) > 0) {
            max = totalCost.getValue();
            min = other.totalCost.getValue();
        } else {
            max = other.totalCost.getValue();
            min = totalCost.getValue();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

    public ProductData getProduct() {
        return product;
    }

}
