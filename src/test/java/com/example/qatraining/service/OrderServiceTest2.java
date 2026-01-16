package com.example.qatraining.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest2 {


    @Mock InventoryService inventory;
    @Mock PaymentGateway gateway;

    @InjectMocks OrderService2 orderService2;

    @Test
            void test1() {

        String sku = "ceva";
        int quantity = 10;
        String card = "card";

        when(inventory.reserve(sku, quantity)).thenReturn(true);
        when(gateway.charge(card,sku,quantity)).thenReturn(new PaymentResult(true,"11","mesaj"));

        OrderReceipt receipt = orderService2.placeOrder(sku,quantity,card);

        assertNotNull(receipt);

    }
}
