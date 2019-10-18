
package Model;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class TestHarness
{
    private final DecimalFormat df = new DecimalFormat("#.##");
    private ArrayList<Printable> printableArrayList = new ArrayList();
    
    public void testConstructor()
    {
        System.out.println();
        System.out.println();
        System.out.println("**********TESTING COUNTRIES AND EXCHANGE RATE SET AND "
                + "GETS**********");
        System.out.println("Creating a new Exchange Rate object...");
        
        ExchangeRate instance = new ExchangeRate("Test Country Name", "Test Country"
                + " Region", "Test Country Currency", 0.05, 20.00);
        
        System.out.println("Base ExchangeRate object created: ");
        System.out.println();

        System.out.println("Country Name: " + instance.getCountryName());
        System.out.println("Country Region: " + instance.getCountryRegion()); 
        System.out.println("Currency Name: " + instance.getCurrencyName());
        System.out.println("Current Exchange Rate: " +  df.format(instance.getCurrencyExchangeRate()));
        System.out.println("Current Exahcne Value: " +  df.format(instance.getCurrencyExchangeValue()));
               
        System.out.println();
        
        System.out.println("Changing countryName to \"New Test Country Name\" ...");
        instance.setCountryName("New Test Country Name");
        
        System.out.println("Changing countryRegion to \"New Test Country Region\" ...");
        instance.setCountryRegion("New Test Country Region");
        
        System.out.println("Changing currency name to \"New Test Country Currency\" ...");
        instance.setCurrencyName("New Test Country Currency");
        
        System.out.println("Changing Exhange Rate to \"0.5\" ...");
        instance.setCurrencyExchangeRate(0.5);
        
        System.out.println("Changing Exhange Value to \"2\" ...");
        instance.setCurrencyExchangeValue(2.0);
        
        System.out.println();
        
        System.out.println("Results: ");
        System.out.println("Country Name: " + instance.getCountryName());
        System.out.println("Country Region: " + instance.getCountryRegion());
        System.out.println("Currency Name: " + instance.getCurrencyName());
        System.out.println("Current Exchange Rate: " +  df.format(
        instance.getCurrencyExchangeRate()));
        System.out.println("Current Exahcne Value: " +  df.format(
        instance.getCurrencyExchangeValue()));
        System.out.println();
        
        if(instance.getCountryName().equalsIgnoreCase("New Test Country Name") &&
                instance.getCountryRegion().equalsIgnoreCase("New Test Country Region") &&
            instance.getCurrencyName().equalsIgnoreCase("New Test Country Currency")
            && instance.getCurrencyExchangeRate() == 0.5
            && instance.getCurrencyExchangeValue() == 2)
        {
            System.out.println("/////////////////////////////////////////////" +
                    "////////////////////////////////////");
            System.out.println("----------COUNTRIES AND EXCHANGE RATE SET AND GETS ARE"
                + " WORKING PROPERLY----------");
            System.out.println("/////////////////////////////////////////////" +
                    "////////////////////////////////////");
        } else
        {
            System.out.println("----------COUNTRIES AND EXCHANGE RATE SET AND GETS ARE"
                + " NOT WORKING PROPERLY----------");
            System.out.println("/////////////////////////////////////////////" +
                    "////////////////////////////////////");
        }
        
        
        System.out.println();
        System.out.println();
        System.out.println("**********TESTING COUNTRIES AND AIRPORTS SET AND "
                + "GETS**********");
        System.out.println("Creating a new Airport object...");
        
        Airports instance2 = new Airports("Test Country Name", "Test Country Region",
                "Test Country Airports","Test Country Airport Codes");
        
        System.out.println("Base Airport object created: ");
        System.out.println();

        System.out.println("Country Name: " + instance2.getCountryName());
        System.out.println("Country Region: " + instance2.getCountryRegion()); 
        System.out.println("Airport Name: " + instance2.getAirportName());
        System.out.println("Airport Code: " + instance2.getAirportCode());       
        System.out.println();
        
        System.out.println("Changing countryName to \"New Test Country Name\" ...");
        instance2.setCountryName("New Test Country Name");
        
        System.out.println("Changing countryRegion to \"New Test Country Region\" ...");
        instance2.setCountryRegion("New Test Country Region");
        
        System.out.println("Changing airportName to \"New Test Country Airport\" ...");
        instance2.setAirportName("New Test Country Airports");
        
        System.out.println("Changing airportCode to \"New Test Country Airport Codes\" ...");
        instance2.setAirportCode("New Test Country Airport Codes");
        
        System.out.println();
        
        if(instance2.getCountryName().equalsIgnoreCase("New Test Country Name") &&
            instance2.getCountryRegion().equalsIgnoreCase("New Test Country Region") &&
            instance2.getAirportName().equalsIgnoreCase("New Test Country Airports") &&
            instance2.getAirportCode().equalsIgnoreCase("New Test Country Airport Codes"))
        {
            System.out.println("/////////////////////////////////////////////" +
                    "////////////////////////////////////");
            System.out.println("----------COUNTRIES AND EXCHANGE RATE SET AND GETS ARE"
                + " WORKING PROPERLY----------");
            System.out.println("/////////////////////////////////////////////" +
                    "////////////////////////////////////");
        } else
        {
            System.out.println("/////////////////////////////////////////////" +
                    "////////////////////////////////////");
            System.out.println("----------COUNTRIES AND EXCHANGE RATE SET AND GETS ARE"
                + " NOT WORKING PROPERLY----------");
            System.out.println("/////////////////////////////////////////////" +
                    "////////////////////////////////////");
        }
    }
    
    
    public void testInterface()
    {
        getPrintableArrayList().add(new ExchangeRate("Country Name", "Country Region", "Currency Name", 1.0, 1.0));
        getPrintableArrayList().add(new Airports("Country Name", "Country Region", "Airport Name", "Airport Code"));
        
        for(Printable print : getPrintableArrayList())
        {
            print.sort();
            print.OutputResults();
        }
    
    }


    public ArrayList<Printable> getPrintableArrayList()
    {
        return printableArrayList;
    }

    public void setPrintableArrayList(ArrayList<Printable> printableArrayList)
    {
        this.printableArrayList = printableArrayList;
    }
    
    
}
