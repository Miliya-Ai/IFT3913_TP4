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
}