/*
    THIS MASTER CLASS HANDLES THE IMPLEMENTATION AND SET AND GETS OF THE 
    COUNTRIES CONSTRUCTOR

*/
package Model;


public class Countries
{
     //---------------Attributes---------------
    
    private String countryName;
    private String countryRegion;
    
    
    //---------------Constructor--------------
    
    public Countries(String countryName, String countryRegion)
    {
        this.countryName = countryName;
        this.countryRegion = countryRegion;
    }

    
    //---------------Methods---------------
    
    public void displayInfo()                                                   //Method used to display the Countries constructor information.
    {
        System.out.println("Country: " + countryName + "\r" + 
            "Region: " + countryRegion);
        System.out.println();
    }
    
    //---------------Sets and Gets---------------
    
    public String getCountryName()                                              //Get method that allows for the retrieval of the countryName attribute in the Countries super object
    {
        return countryName;
    }

  
    public void setCountryName(String countryName)                              //Set method that allows for the setting of the countryName attribute in the Countries super object
    {
        this.countryName = countryName;
    }


    public String getCountryRegion()                                            //Get method that allows for the retrieval of the countryRegion attribute in the Countries super object
    {
        return countryRegion;
    }

 
    public void setCountryRegion(String countryRegion)                          //Set method that allows for the setting of the countryRegion attribute in the Countries super object
    {
        this.countryRegion = countryRegion;
    }
    
    
    
}
