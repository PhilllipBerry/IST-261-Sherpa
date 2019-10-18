
package Model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ExchangeRateTest
{
    
    public ExchangeRateTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }

    /**
     * Test of getCurrencyName method, of class ExchangeRate.
     */
    @Test
    public void testGetCurrencyName()
    {
        System.out.println("getCurrencyName");
        ExchangeRate instance = new ExchangeRate("Test Country Name", "Test Country"
                + " Region", "TestCountry", 0.0000123, 164634.1463414634);
        String expResult = "TestCountry";
        String result = instance.getCurrencyName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrencyName method, of class ExchangeRate.
     */
    @Test
    public void testSetCurrencyName()
    {
        System.out.println("setCurrencyName");
        String currencyName = "NewTestCountry";
        ExchangeRate instance = new ExchangeRate("Test Country Name", "Test Country"
                + " Region","TestCountry", 0.0000123, 164634.1463414634);
        instance.setCurrencyName(currencyName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrencyExchangeRate method, of class ExchangeRate.
     */
    @Test
    public void testGetCurrencyExchangeRate()
    {
        System.out.println("getCurrencyExchangeRate");
        ExchangeRate instance = new ExchangeRate("Test Country Name", "Test Country"
                + " Region","TestCountry", 0.0000123, 164634.1463414634);
        double expResult = 0.0000123;
        double result = instance.getCurrencyExchangeRate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrencyExchangeRate method, of class ExchangeRate.
     */
    @Test
    public void testSetCurrencyExchangeRate()
    {
        System.out.println("setCurrencyExchangeRate");
        double currencyExchangeRate = 0.00234;
        ExchangeRate instance =  new ExchangeRate("Test Country Name", "Test Country"
                + " Region","TestCountry", 0.0000123, 164634.1463414634);
        instance.setCurrencyExchangeRate(currencyExchangeRate);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrencyExchangeValue method, of class ExchangeRate.
     */
    @Test
    public void testGetCurrencyExchangeValue()
    {
        System.out.println("getCurrencyExchangeValue");
        ExchangeRate instance = new ExchangeRate("Test Country Name", "Test Country"
                + " Region","TestCountry", 0.0000123, 164634.1463414634);
        double expResult = 164634.1463414634;
        double result = instance.getCurrencyExchangeValue();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrencyExchangeValue method, of class ExchangeRate.
     */
    @Test
    public void testSetCurrencyExchangeValue()
    {
        System.out.println("setCurrencyExchangeValue");
        double currencyExchangeValue = 5.01;
        ExchangeRate instance = new ExchangeRate("Test Country Name", "Test Country"
                + " Region","TestCountry", 0.0000123, 164634.1463414634);
        instance.setCurrencyExchangeValue(currencyExchangeValue);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
