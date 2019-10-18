/*
    THIS CLASS HANDLES THE EXECUTION AND IMPLEMENTATION OF THE WEBSCRAPING TASKS

*/

package Model;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class WebScraper
{
    
    //---------------Attributes---------------
    private String exchangeURL = "https://www.exchange-rates.org/MajorRates.aspx";
    private Document siteHtmlDoc;
   
    
    
    //---------------Methods---------------
    
   public void getExchangeData()                                                //Method that stores the HTML scraped from a web site into a document object.
   {
        try{
            final Document htmlDoc = Jsoup.connect(getExchangeURL()).get();
            setSiteHtmlDoc(htmlDoc);   

        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        } 
   }

   //---------------Sets and Gets---------------
    public String getExchangeURL()                                              //Get method to allow for the retrieval of the currently set URL
    {
        return exchangeURL;
    }

 
    public void setExchangeURL(String exchangeURL)                              //Set method that allows for the changing of the URL
    {
        this.exchangeURL = exchangeURL;
    }

  
    public Document getSiteHtmlDoc()                                            //Get method that allows for the retrieval of the document object
    {
        return siteHtmlDoc;
    }


    public void setSiteHtmlDoc(Document siteHtmlDoc)                            //Set method that allows for the changing of the document object
    {
        this.siteHtmlDoc = siteHtmlDoc;
    }
   
}
