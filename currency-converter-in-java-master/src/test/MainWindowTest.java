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
        assertEquals(0.93, MainWindow.convert("US Dollar", "Euro", currencies, 1.0));
        assertEquals(0.0, MainWindow.convert("US Dollar", null, currencies, 1.0));
        assertEquals(0.0, MainWindow.convert(null, "British Pound", currencies, 1.0));
        assertEquals(0.71, MainWindow.convert("Euro","British Pound", currencies, 1.0));
    }

    @Test
    public void testGraphIndependentPathCoverage() {
        assertEquals(0.0, MainWindow.convert("US Dollar", null, currencies, 1.0));
        assertEquals(1.0, MainWindow.convert("US Dollar", "US Dollar", currencies, 1.0));
        assertEquals(0.0, MainWindow.convert(null, "British Pound", currencies, 1.0));
    }

    @Test
    public void testiPathCoverage() {
        assertEquals(0.0,MainWindow.convert("US Dollar", null, currencies, 1.0));
        assertEquals(1.0,MainWindow.convert("US Dollar", "US Dollar", currencies, 1.0));
        assertEquals(0.93,MainWindow.convert("US Dollar", "Euro", currencies, 1.0));
        assertEquals(0.66,MainWindow.convert("US Dollar","British Pound", currencies, 1.0));
        assertEquals(1.01,MainWindow.convert("US Dollar", "Swiss Franc", currencies, 1.0));
        assertEquals(6.36,MainWindow.convert("US Dollar", "Chinese Yuan Renminbi", currencies, 1.0));
        assertEquals(123.54,MainWindow.convert("US Dollar", "Japanese Yen", currencies, 1.0));
        assertEquals(0.0,MainWindow.convert(null, "US Dollar", currencies, 1.0));
        assertEquals(0.71,MainWindow.convert("Euro","British Pound", currencies, 1.0));
        assertEquals(1.07,MainWindow.convert("Euro","US Dollar", currencies, 1.0));
        assertEquals(1.08,MainWindow.convert("Euro","Swiss Franc", currencies, 1.0));
        assertEquals(6.83,MainWindow.convert("Euro","Chinese Yuan Renminbi", currencies, 1.0));
        assertEquals(132.57,MainWindow.convert("Euro","Japanese Yen", currencies, 1.0));
        assertEquals(1.51,MainWindow.convert("British Pound","US Dollar", currencies, 1.0));
        assertEquals(1.41,MainWindow.convert("British Pound","Euro", currencies, 1.0));
        assertEquals(1.52,MainWindow.convert("British Pound","Swiss Franc", currencies, 1.0));
        assertEquals(9.6,MainWindow.convert("British Pound","Chinese Yuan Renminbi", currencies, 1.0));
        assertEquals(186.41,MainWindow.convert("British Pound","Japanese Yen", currencies, 1.0));
        assertEquals(0.99,MainWindow.convert("Swiss Franc","US Dollar", currencies, 1.0));
        assertEquals(0.93,MainWindow.convert("Swiss Franc","Euro", currencies, 1.0));
        assertEquals(0.66,MainWindow.convert("Swiss Franc","British Pound", currencies, 1.0));
        assertEquals(6.33,MainWindow.convert("Swiss Franc","Chinese Yuan Renminbi", currencies, 1.0));
        assertEquals(122.84,MainWindow.convert("Swiss Franc","Japanese Yen", currencies, 1.0));
        assertEquals(0.16,MainWindow.convert("Chinese Yuan Renminbi","US Dollar", currencies, 1.0));
        assertEquals(0.15,MainWindow.convert("Chinese Yuan Renminbi","Euro", currencies, 1.0));
        assertEquals(0.11,MainWindow.convert("Chinese Yuan Renminbi","British Pound", currencies, 1.0));
        assertEquals(0.16,MainWindow.convert("Chinese Yuan Renminbi","Swiss Franc", currencies, 1.0));
        assertEquals(19.41,MainWindow.convert("Chinese Yuan Renminbi","Japanese Yen", currencies, 1.0));
        assertEquals(0.01,MainWindow.convert("Japanese Yen","US Dollar", currencies, 1.0));
        assertEquals(0.01,MainWindow.convert("Japanese Yen","Euro", currencies, 1.0));
        assertEquals(0.01,MainWindow.convert("Japanese Yen","British Pound", currencies, 1.0));
        assertEquals(0.01,MainWindow.convert("Japanese Yen","Swiss Franc", currencies, 1.0));
        assertEquals(0.05,MainWindow.convert("Japanese Yen","Chinese Yuan Renminbi", currencies, 1.0));
    }
}