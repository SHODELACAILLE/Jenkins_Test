package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DemoApplicationTests {

    private Calculatrice calculatrice;

    @BeforeEach
    public void setUp() {
        calculatrice = new Calculatrice();
    }

    @Test
    public void testAddition() {
        // Utilisez l'instance de Calculatrice pour appeler la méthode add
        assertThat(calculatrice.add(2, 3)).isEqualTo(5);
    }

    @Test
    public void testSubtraction() {
        // Utilisez l'instance de Calculatrice pour appeler la méthode subtract
        assertThat(calculatrice.subtract(5, 3)).isEqualTo(2);
    }

    @Test
    public void testMultiplication() {
        // Utilisez l'instance de Calculatrice pour appeler la méthode multiply
        assertThat(calculatrice.multiply(2, 3)).isEqualTo(6);
    }
}
