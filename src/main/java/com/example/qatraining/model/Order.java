package com.example.qatraining.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private Long id;
    private Long userId;
    private BigDecimal total;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Order() {}

    public Order(Long id, Long userId, BigDecimal total) {
        this.id = id;
        this.userId = userId;
        this.total = total;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(userId, order.userId) && Objects.equals(total, order.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, total);
    }
}
