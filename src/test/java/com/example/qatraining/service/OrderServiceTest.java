package com.example.qatraining.service;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final OrderService service = new OrderService();

    @Test
    void applyDiscount_basic() {
        assertEquals(new BigDecimal("90.00"), service.applyDiscount(new BigDecimal("100"), 10));
    }

    // TODO: boundary tests: 0%, 100%

    @Test
    void testare_pentru_zero(){

        BigDecimal total = new BigDecimal(199.99);
        double percent = 0.0;

        BigDecimal result = service.applyDiscount(total,percent);

        assertEquals(new BigDecimal("199.99"),result);
    }

    @Test
    void testare_pentru_suta(){
        BigDecimal total1 = new BigDecimal(199.99);
        double percent = 100.0;

        BigDecimal result = service.applyDiscount(total1,percent);

        assertEquals(new BigDecimal("0.00"),result);

    }

    @Test
    void testare_reducerepste100(){
        BigDecimal total = new BigDecimal("200.00");
        double percent = 101;

        assertThrows(IllegalArgumentException.class,() ->service.applyDiscount(total,percent));
    }

    @Test
    void reduceremaimarede100(){
        BigDecimal total = new BigDecimal("100.00");
        double percent = 110;

        assertThrows(IllegalArgumentException.class,() -> service.applyDiscount(total, 120));
    }


    // TODO: invalid percent: -1, 101 -> IllegalArgumentException
    // TODO: negative total -> IllegalArgumentException
    // TODO: rounding to 2 decimals HALF_UP (e.g., 100 * 12.345%)

    @Test
    void verificaprocentminus(){
        BigDecimal total =  new BigDecimal("200.00");
        double procent = -1.0;

       // BigDecimal resul = service.applyDiscount(total,procent);

        assertThrows(IllegalArgumentException.class,()->service.applyDiscount(total,procent));

    }








    @Test
    void applyDiscount_roundsHalfUp_twoDecimals() {
        // Arrange
        BigDecimal total = new BigDecimal("100.00");
        double percent = 12.345; // discount = 12.345 -> 100 - 12.345 = 87.655

        // Act
        BigDecimal result = service.applyDiscount(total, percent);

        // Assert
        assertEquals(new BigDecimal("87.66"), result); // 87.655 -> 87.66 (HALF_UP)
    }

    @Test
    void applyDiscount_roundsHalfUp_twoDecimals2() {
        // Arrange
        BigDecimal total = new BigDecimal("100.00");
        double percent = 12.346; // discount = 12.346 -> 100 - 12.346 = 87.654

        // Act
        BigDecimal result = service.applyDiscount(total, percent);

        // Assert
        assertEquals(new BigDecimal("87.65"), result); // 87.655 -> 87.66 (HALF_UP)
    }

}
