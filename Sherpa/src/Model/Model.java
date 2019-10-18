/*
    THIS MODEL MVC CLASS HANDLES SENDING EXECUTION COMMANDS TO ANY CLASS WITHIN 
    THE MODEL BRANCH OF CLASSES.

*/

package Model;

import java.util.ArrayList;


public class Model
{
    //---------------Attributes---------------
    public WebScraper webScraper = new WebScraper();
    public WebParser webParser = new WebParser();
    public ExchangeSorter exchangeSorter = new ExchangeSorter();
    public TestHarness testHarness = new TestHarness();
    public ExchangeRate exchangeRate = new ExchangeRate("CountryName", "CountryRegion");
    public Airports airports = new Airports("CountryName", "CountryRegion");
    
    //--------------Constructor---------------
    public Model() 
    {
        webScraper.getExchangeData();                                           //Get HTML from Exchange Website and place it into a document object
        webParser.parseWebDocument(webScraper.getSiteHtmlDoc());                //Parse the document oject and extract specific exchange rate information
        
        System.out.println("----------LIST OF EXCHANGE RATES----------");
        exchangeRate.setCurrentExchangeRates(webParser.getCurrentExchangeRates());
        exchangeRate.sort();
        exchangeRate.OutputResults();
        
        
        /*exchangeSorter.setCurrentExchangeRates(exchangeSorter.sortByExchangeValue//Set the currentExchangeRates ArrayList in ExchangeSorter class
        (webParser.getCurrentExchangeRates()));
        exchangeSorter.erOutputResults();                                       //Call method to output the currentExchangeRates ArrayList in the ExchangeSorter class*/
        
        System.out.println("----------LIST OF AIRPORTS----------");
        airports.setCurrentAirports(webParser.getAirportList());
        airports.sort();
        airports.OutputResults();
        
        
        /*       exchangeSorter.setAirportList(webParser.getAirportList());              //Set the airpotList ArrayList in ExchangeSorter class
        exchangeSorter.apOutputResults();                                       //Call method to output the airportList ArrayList in the ExchangeSorter clas*/
        
        //Test Harness calls
        System.out.println();
        System.out.println();
        System.out.println("//////////TEST HARNESS OUTPUT TO FOLLOW//////////");
        
        testHarness.testConstructor();
        testHarness.testInterface();
        
    }
    
    //--------------Methods---------------
    
    
   
}
