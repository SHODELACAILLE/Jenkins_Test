package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatriceTest {

    @Test
    public void testAdd() {
        assertEquals(3, Calculatrice.add(1, 2));
    }

    @Test
    public void testMulti() {
        assertEquals(6, Calculatrice.multi(2, 3));
    }

    @Test
    public void testDiv() {
        assertEquals(2, Calculatrice.div(4, 2));
    }
}
