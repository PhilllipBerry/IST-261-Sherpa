/*
    THIS SUB-CLASS TO THE COUNTRIES MASTER CLASS HANDLES THE IMPLEMENTATION AND 
    SET AND GETS OF THE EXCHANGERATE CONSTRUCTOR

*/

package Model;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class ExchangeRate extends Countries implements Printable
{
    
    //---------------Attributes---------------
    
    private String countryName; 
    private String countryRegion; 
    private String currencyName; 
    private double currencyExchangeRate;
    private double currencyExchangeValue;
    private ArrayList<ExchangeRate> currentExchangeRates = new ArrayList<>();
    private final DecimalFormat df = new DecimalFormat("#.##");
    
    
    //---------------Constructor--------------
    
    public ExchangeRate(String countryName, String countryRegion)               //Constructor for the ExchangeRate object
    {
        super(countryName, countryRegion);
    }
    
    
    public ExchangeRate(String countryName, String countryRegion, String        //Constructor for the ExchangeRate object
            currencyName, double currencyExchangeRate, double currencyExchangeValue)
    {
        super(countryName, countryRegion);
        this.countryName = countryName;
        this.countryRegion = countryRegion;
        this.currencyName = currencyName; 
        this.currencyExchangeRate = currencyExchangeRate;
        this.currencyExchangeValue = currencyExchangeValue;
    }
    
    
 
    //---------------Methods---------------
    
    @Override
     public void displayInfo()                                                  //Overridden method used to display all ExchangeRate contructor information
    {
        System.out.println("Country: " + countryName + "\r" + 
                "Region: " + countryRegion + "\r" + 
                "Currency: " + currencyName + "\r" +
                "Exchange Rate: " + currencyExchangeRate + "\r" +
                "Exchange Value: " + currencyExchangeValue + "\r");
        System.out.println();   
    }
     
    @Override
    public void OutputResults()
    {
       for(int i = 0; i < getCurrentExchangeRates().size(); i++)
        {
            System.out.println("Country: " + getCurrentExchangeRates().get(i).getCountryName());
            System.out.println("Region: " + getCurrentExchangeRates().get(i).getCountryRegion());
            System.out.println("Currency: " + getCurrentExchangeRates().get(i).getCurrencyName());
            System.out.println("Exchange Rate: " + df.format(getCurrentExchangeRates().get(i).getCurrencyExchangeRate()));
            System.out.println("Exchange Value: " + df.format(getCurrentExchangeRates().get(i).getCurrencyExchangeValue()));
            System.out.println();
        }
    }

    @Override
    public void sort()                                                          //Method that sorts the currentExchange Rate object by exchange rate value from highes to lowest
    {
        ArrayList<ExchangeRate> sortedExchangeRates = new ArrayList<>();
            
        for(int i = 0; i < getCurrentExchangeRates().size();)
        {
            int index = i;
            for(int j = i + 1; j < getCurrentExchangeRates().size(); j++)
            {
                if(getCurrentExchangeRates().get(j).getCurrencyExchangeValue() > 
                        getCurrentExchangeRates().get(index).getCurrencyExchangeValue())
                {
                    index = j;
                }  
            }
            sortedExchangeRates.add(getCurrentExchangeRates().get(index));
            getCurrentExchangeRates().remove(index);
        }
        setCurrentExchangeRates(sortedExchangeRates);
    }
    
     
     
    //---------------Sets and Gets---------------
    public String getCurrencyName()                                             //Get method that allows for the retrieval of the currencyName attribute in the ExchangeRate object
    {
        return currencyName;
    }


    public void setCurrencyName(String currencyName)                            //Set method that allows for the changing of the currentcyName attribute in the ExchangeRate object
    {
        this.currencyName = currencyName;
    }


    public double getCurrencyExchangeRate()                                     //Get method that allows for the retrieval of the currencyEchangeRate attribute in the ExchangeRate object
    {
        return currencyExchangeRate;
    }


    public void setCurrencyExchangeRate(double currencyExchangeRate)            //Set method that allows for the changing of the currentcyExchangeRate attribute in the ExchangeRate object
    {
        this.currencyExchangeRate = currencyExchangeRate;
    }

    
    public double getCurrencyExchangeValue()                                    //Get method that allows for the retrieval of the currencyExchangeValue attribute in the ExchangeRate object
            
    {
        return currencyExchangeValue;
    }


    public void setCurrencyExchangeValue(double currencyExchangeValue)          //Set method that allows for the changing of the currentcyExchangeValue attribute in the ExchangeRate object
    {
        this.currencyExchangeValue = currencyExchangeValue;
    }


    public ArrayList<ExchangeRate> getCurrentExchangeRates()                    //Get method that allows for the retrieval of the currentExchangeRates ArrayList in the ExchangeRate object
    {
        return currentExchangeRates;
    }


    public void setCurrentExchangeRates(ArrayList<ExchangeRate>                 //Set method that allows for the changing of the currentExchangeRates ArrayList in the ExchangeRate object
            currentExchangeRates)
    {
        this.currentExchangeRates = currentExchangeRates;
    }

    
}
