package com.example.qatraining.service;

import com.example.qatraining.model.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class OrderService {

    /**
     * Applies a percentage discount to an order total.
     * Constraints:
     * - percent in [0, 100]
     * - total must be non-negative
     * Rounding: HALF_UP to 2 decimals.
     */
    public BigDecimal applyDiscount(BigDecimal total, double percent) {
        if (total == null) throw new IllegalArgumentException("total null");
        if (total.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("total negative");
        if (percent < 0 || percent > 100) throw new IllegalArgumentException("percent out of range");
        BigDecimal discount = total.multiply(BigDecimal.valueOf(percent / 100.0));
        BigDecimal result = total.subtract(discount);
        return result.setScale(2, RoundingMode.HALF_UP);
    }
}
