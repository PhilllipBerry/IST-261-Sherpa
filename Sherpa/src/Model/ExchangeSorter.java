/*
    THIS CLASS IS RESPONSIBLE FOR SORTING THE ARRAYLIST<EXCHANGERATE> BEFORE IT 
    IS DISPLAYED
 */
/*package Model;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class ExchangeSorter
{

//---------------Attributes---------------
private final DecimalFormat df = new DecimalFormat("#.##");
private ArrayList<ExchangeRate> currentExchangeRates = new ArrayList();
private ArrayList<Airports> airportList = new ArrayList();



//--------------Methods---------------

public ArrayList<ExchangeRate> sortByExchangeValue(ArrayList<ExchangeRate>  //Method that sorts the currentExchange Rate object by exchange rate value from highes to lowest
currentExchangeRates)
{
ArrayList<ExchangeRate> sortedExchangeRates = new ArrayList<>();

for(int i = 0; i < currentExchangeRates.size();)
{
int index = i;
for(int j = i + 1; j < currentExchangeRates.size(); j++)
{
if(currentExchangeRates.get(j).getCurrencyExchangeValue() >
currentExchangeRates.get(index).getCurrencyExchangeValue())
{
index = j;
}
}
sortedExchangeRates.add(currentExchangeRates.get(index));
currentExchangeRates.remove(index);
}
currentExchangeRates = sortedExchangeRates;

return sortedExchangeRates;
}


public void apOutputResults()                                               //Method that outputs to currentEchangeRates object for display
{
for(int i = 0; i < getAirportList().size(); i++)
{
System.out.println("Country: " + getAirportList().get(i).getCountryName());
System.out.println("Region: " + getAirportList().get(i).getCountryRegion());
System.out.println("Airports: " + getAirportList().get(i).getAirportName());
System.out.println("Airport Codes: " + getAirportList().get(i).getAirportCode());
System.out.println();
}
}


@Override
public void erOutputResults()                                                //Method with a different format of currentExchangeRates display
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





//---------------Sets and Gets---------------

public ArrayList<ExchangeRate> getCurrentExchangeRates()                    //Getter method that gets the currentExchangeRates ArrayList
{
return currentExchangeRates;
}


public void setCurrentExchangeRates(ArrayList<ExchangeRate>                 //Setter method that alters the contents of the currentExchangeRates ArrayList
currentExchangeRates)
{
this.currentExchangeRates = currentExchangeRates;
}


public ArrayList<Airports> getAirportList()                                 //Getter method that gets the airplaneList ArrayList
{
return airportList;
}


public void setAirportList(ArrayList<Airports> airportList)                 //Setter method that alters the contents of the airplaneList ArrayList
{
this.airportList = airportList;
}



}*/
