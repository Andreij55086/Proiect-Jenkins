package com.example.qatraining.service;

public class OrderService2 {
    private final InventoryService inventory;
    private final PaymentGateway payments;

    public OrderService2(InventoryService inventory, PaymentGateway payments) {
        this.inventory = inventory;
        this.payments = payments;
    }

    public OrderReceipt placeOrder(String sku, int qty, String cardToken) {
        if (qty <= 0) throw new IllegalArgumentException("qty must be > 0");

        boolean reserved = inventory.reserve(sku, qty);
        if (!reserved) throw new IllegalStateException("Insufficient stock");

        PaymentResult result = payments.charge(cardToken, sku, qty);
        if (!result.success()) {
            inventory.release(sku, qty); // rollback rezervare
            throw new IllegalStateException("Payment failed: " + result.message());
        }
        return new OrderReceipt(sku, qty, result.transactionId());
    }
}

// Interfețe simple (dependințe)
interface InventoryService {
    boolean reserve(String sku, int qty);
    void release(String sku, int qty);
}
interface PaymentGateway {
    PaymentResult charge(String cardToken, String sku, int qty);
}
record PaymentResult(boolean success, String transactionId, String message) {
    @Override
    public boolean success() { return success; }
}
record OrderReceipt(String sku, int qty, String transactionId) {}
