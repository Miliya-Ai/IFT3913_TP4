package test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainWindowTest {
    public ArrayList<Currency> currencies;
    @BeforeEach
    void setUp() {
        currencies = Currency.init();
    }
    @Test
    void convertPartition() {
       /*
       Devise acceptée
        */
        assertDoesNotThrow(() -> MainWindow.convert("Euro", "US Dollar", currencies, 1.0));
        assertDoesNotThrow(() -> MainWindow.convert("Canadian dollar", "US Dollar", currencies, 1.0));
        assertDoesNotThrow(() -> MainWindow.convert("British Pound", "US Dollar", currencies, 1.0));
        assertDoesNotThrow(() -> MainWindow.convert("Swiss franc", "US Dollar", currencies, 1.0));
        assertDoesNotThrow(() -> MainWindow.convert("Australian dollar", "US Dollar", currencies, 1.0));

//        System.out.println(MainWindow.convert("Euro", "US Dollar", currencies, 1.0));
//        System.out.println(MainWindow.convert("Canadian dollar", "US Dollar", currencies, 1.0));
//        System.out.println(MainWindow.convert("British Pound", "US Dollar", currencies, 1.0));
//        System.out.println(MainWindow.convert("Swiss franc", "US Dollar", currencies, 1.0));
//        System.out.println(MainWindow.convert("Australian dollar", "US Dollar", currencies, 1.0));

        /*
        Devise non acceptée
         */
        assertThrows(IllegalArgumentException.class, () -> MainWindow.convert("Japanese yen", "US Dollar", currencies, 1.0));
//        System.out.println(MainWindow.convert("Japanese yen", "US Dollar", currencies, 1.0));
    }

    @Test
    public void testInstructionCoverage(){
        assertEquals(1.0, MainWindow.convert("US Dollar", "US Dollar", currencies, 1.0));
        assertEquals(1.07, MainWindow.convert("Euro", "US Dollar", currencies, 1.0));
        assertEquals(1.51, MainWindow.convert("British Pound", "US Dollar", currencies, 1.0));
        assertEquals(0.0, MainWindow.convert("Dollar exist pas", "US Dollar", currencies, 1.0));
        assertEquals(0.0, MainWindow.convert("US Dollar", "Dollar exist pas", currencies, 1.0));
    }

    @Test
    public void testControlFlowGraphCoverage() {
        assertEquals(1.0, MainWindow.convert("US Dollar", "US Dollar", currencies, 1.0));
        assertEquals(1.07, MainWindow.convert("US Dollar", "Euro", currencies, 1.0));
        assertEquals(0.0, MainWindow.convert("US Dollar", null, currencies, 1.0));
        assertEquals(0.0, MainWindow.convert(null, "British Pound", currencies, 1.0));
        assertEquals(1.41, MainWindow.convert("Euro","British Pound", currencies, 1.0));
    }

    @Test
    public void testGraphIndependentPathCoverage() {
        assertEquals(0.0, MainWindow.convert("US Dollar", null, currencies, 1.0));
        assertEquals(1.0, MainWindow.convert("US Dollar", "US Dollar", currencies, 1.0));
        assertEquals(0.0, MainWindow.convert(null, "British Pound", currencies, 1.0));
    }
}