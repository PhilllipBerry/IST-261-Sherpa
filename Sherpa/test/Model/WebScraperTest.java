
package Model;

import org.jsoup.nodes.Document;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class WebScraperTest
{
    
    public WebScraperTest()
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
     * Test of getExchangeData method, of class WebScraper.
     */
    @Test
    public void testGetExchangeData()
    {
        System.out.println("getExchangeData");
        WebScraper instance = new WebScraper();
        instance.getExchangeData();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getExchangeURL method, of class WebScraper.
     */
    @Test
    public void testGetExchangeURL()
    {
        System.out.println("getExchangeURL");
        WebScraper instance = new WebScraper();
        String expResult = "https://www.exchange-rates.org/MajorRates.aspx";
        String result = instance.getExchangeURL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setExchangeURL method, of class WebScraper.
     */
    @Test
    public void testSetExchangeURL()
    {
        System.out.println("setExchangeURL");
        String exchangeURL = "https://www.google.com";
        WebScraper instance = new WebScraper();
        instance.setExchangeURL(exchangeURL);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSiteHtmlDoc method, of class WebScraper.
     */
    @Test
    public void testGetSiteHtmlDoc()
    {
        System.out.println("getSiteHtmlDoc");
        WebScraper instance = new WebScraper();
        Document expResult = null;
        Document result = instance.getSiteHtmlDoc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSiteHtmlDoc method, of class WebScraper.
     */
    @Test
    public void testSetSiteHtmlDoc()
    {
        System.out.println("setSiteHtmlDoc");
        Document siteHtmlDoc = new Document("TestText");
        WebScraper instance = new WebScraper();
        instance.setSiteHtmlDoc(siteHtmlDoc);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
