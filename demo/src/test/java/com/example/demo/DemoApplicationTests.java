package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// Assurez-vous que cette importation est correcte
import com.example.demo.Calculatrice;

public class DemoApplicationTests {

    @Test
    public void testAddition() {
        // Supposons que la classe Calculatrice a une méthode add
        assertThat(Calculatrice.add(2, 3)).isEqualTo(5);
    }

    @Test
    public void testSubtraction() {
        // Supposons que la classe Calculatrice a une méthode subtract
        assertThat(Calculatrice.subtract(5, 3)).isEqualTo(2);
    }

    @Test
    public void testMultiplication() {
        // Supposons que la classe Calculatrice a une méthode multiply
        assertThat(Calculatrice.multiply(2, 3)).isEqualTo(6);
    }
}
