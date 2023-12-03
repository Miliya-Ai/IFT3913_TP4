package test;

import currencyConverter.Currency;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {
    //https://www.investopedia.com/articles/forex/090314/how-calculate-exchange-rate.asp
    private double calculateExpectedResults(double amount, double exchangeValue){
        if (amount == 0.0 || exchangeValue == 0.0)
            return 0.0;
        return amount * exchangeValue;
    }
    @Test
    public void convertPartition() {
        /*
        appartenant à l'interval valide: [0, 1 000 000]
         */

        assertEquals(calculateExpectedResults(500000.0, 1.43),Currency.convert(500000.0 , 1.43 ));
        /*
        As exchange rate can be negative
         */
        assertEquals(calculateExpectedResults(500000.0, -1.43),Currency.convert(500000.0 , -1.43 ));

        /*
        supérieur à l'interval
         */
//        assertThrows(IllegalArgumentException.class, () -> Currency.convert(2000000.0, 1.43 ));
//        assertThrows(IllegalArgumentException.class, () -> Currency.convert(2000000.0, -1.43 ));
        assertEquals(calculateExpectedResults(2000000.0, 1.43),Currency.convert(2000000.0 , 1.43 ));
        assertEquals(calculateExpectedResults(2000000.0, -1.43),Currency.convert(2000000.0 , -1.43 ));

        /*
        inférieur à l'interval
         */
//        assertThrows(IllegalArgumentException.class, () -> Currency.convert(-50.0, 1.43 ));
//        assertThrows(IllegalArgumentException.class, () -> Currency.convert(-50.0, -1.43 ));
        assertEquals(calculateExpectedResults(-50.0, 1.43),Currency.convert(-50.0 , 1.43 ));
        assertEquals(calculateExpectedResults(-50.0, -1.43),Currency.convert(-50.0 , -1.43 ));
    }

    @Test
    public void convertFrontiere(){
        /*
        typique
         */
//        assertThrows(IllegalArgumentException.class, () -> Currency.convert(-300.0, 1.43 ));
//        assertThrows(IllegalArgumentException.class, () -> Currency.convert(-300.0, -1.43 ));
        assertEquals(calculateExpectedResults(-300.0, 1.43),Currency.convert(-300.0 , 1.43 ));
        assertEquals(calculateExpectedResults(-300.0, -1.43),Currency.convert(-300.0 , -1.43 ));

        assertEquals(calculateExpectedResults(700000.0, 1.43),Currency.convert(700000.0, 1.43 ));
        assertEquals(calculateExpectedResults(700000.0, -1.43),Currency.convert(700000.0 , -1.43 ));

//        assertThrows(IllegalArgumentException.class, () -> Currency.convert(1000500.0, 1.43 ));
//        assertThrows(IllegalArgumentException.class, () -> Currency.convert(1000500.0, -1.43 ));
        assertEquals(calculateExpectedResults(1000500.0, 1.43),Currency.convert(1000500.0 , 1.43 ));
        assertEquals(calculateExpectedResults(1000500.0, -1.43),Currency.convert(1000500.0 , -1.43 ));

        /*
        frontiere
         */
//        assertThrows(IllegalArgumentException.class, () -> Currency.convert(-1.0, 1.43 ));
//        assertThrows(IllegalArgumentException.class, () -> Currency.convert(-1.0, -1.43 ));
        assertEquals(calculateExpectedResults(-1.0, 1.43),Currency.convert(-1.0, 1.43 ));
        assertEquals(calculateExpectedResults(-1.0, -1.43),Currency.convert(-1.0 , -1.43 ));


        assertEquals(calculateExpectedResults(0.0, 1.43),Currency.convert(0.0, 1.43 ));
        assertEquals(calculateExpectedResults(0.0, -1.43),Currency.convert(0.0 , -1.43 ));

        assertEquals(calculateExpectedResults(1000000.0, 1.43),Currency.convert(1000000.0 , 1.43 ));
        assertEquals(calculateExpectedResults(1000000.0, -1.43),Currency.convert(1000000.0, -1.43 ));

//        assertThrows(IllegalArgumentException.class, () -> Currency.convert(1000001.0, 1.43 ));
//        assertThrows(IllegalArgumentException.class, () -> Currency.convert(1000001.0, -1.43 ));
        assertEquals(calculateExpectedResults(1000001.0, 1.43),Currency.convert(1000001.0 , 1.43 ));
        assertEquals(calculateExpectedResults(1000001.0, -1.43),Currency.convert(1000001.0, -1.43 ));
    }




}