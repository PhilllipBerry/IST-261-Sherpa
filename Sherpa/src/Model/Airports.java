/*
    THIS SUB-CLASS TO THE COUNTRIES MASTER CLASS HANDLES THE IMPLEMENTATION AND 
    SET AND GETS OF THE AIRPORTS CONSTRUCTOR

*/
package Model;

import java.util.ArrayList;


public class Airports extends Countries implements Printable
{
    //---------------Attributes---------------
    private String countryName;
    private String countryRegion;
    private String airportName;
    private String airportCode;
    private ArrayList<Airports> currentAirports = new ArrayList();
    
    
    //---------------Constructor--------------
   
     public Airports(String countryName, String countryRegion)                  //Constructor for the Airport object
    {
        super(countryName, countryRegion);
    }
     
    
    public Airports(String countryName, String countryRegion, String airportName,//Constructor for the Airport object
            String airportCode)
    {
        super(countryName, countryRegion);
        this.countryName = countryName;
        this.countryRegion = countryRegion;
        this.airportName = airportName;
        this.airportCode = airportCode;
    }
    
    
    //---------------Methods---------------
    
    @Override
    public void OutputResults()
    {
        for(int i = 0; i < getCurrentAirports().size(); i++)
        {
            System.out.println("Country: " + getCurrentAirports().get(i).getCountryName());
            System.out.println("Region: " + getCurrentAirports().get(i).getCountryRegion());
            System.out.println("Airports: " + getCurrentAirports().get(i).getAirportName());
            System.out.println("Airport Codes: " + getCurrentAirports().get(i).getAirportCode());
            System.out.println();
        }
    }

    @Override
    public void sort()
    {
        ArrayList<Airports> sortedAirports = new ArrayList<>();
            
        for(int i = 0; i < getCurrentAirports().size();)
        {
            int index = i;
            for(int j = i + 1; j < getCurrentAirports().size(); j++)
            {
                if(getCurrentAirports().get(j).getCountryName().compareTo(
                        getCurrentAirports().get(index).getCountryName()) < 0)
                {
                    index = j;
                }         
            }
            sortedAirports.add(getCurrentAirports().get(index));
            getCurrentAirports().remove(index);
        }
        setCurrentAirports(sortedAirports);  
    }
    
    
    
    //---------------Sets and Gets---------------

  
    public String getCountryName()                                              //Getter that retrieves the countryName variable from the Airport object
    {
        return countryName;
    }

  
    public void setCountryName(String countryName)                              //Setter that changes the countryName variable from the Airport object
    {
        this.countryName = countryName;
    }

  
    public String getCountryRegion()                                            //Getter that retrieves the countryRegion variable from the Airport object
    {
        return countryRegion;
    }


    public void setCountryRegion(String countryRegion)                          //Setter that changes the countryRegion variable from the Airport object
    {
        this.countryRegion = countryRegion;
    }


    public String getAirportName()                                              //Getter that retrieves the airportName variable from the Airport object
    {
        return airportName;
    }

  
    public void setAirportName(String airportName)                              //Setter that changes the airportName variable from the Airport object
    {
        this.airportName = airportName;
    }

 
    public String getAirportCode()                                              //Getter that retrieves the airportCode variable from the Airport object
    {
        return airportCode;
    }

  
    public void setAirportCode(String airportCode)                              //Setter that changes the airportCode variable from the Airport object
    {
        this.airportCode = airportCode;
    } 


    public ArrayList<Airports> getCurrentAirports()                                    //Getter that retrieves the airport ArrayList from the Airport object
    {
        return currentAirports;
    }


    public void setCurrentAirports(ArrayList<Airports> airports)                       //Setter that changes the airport ArrayList from the Airport object
    {
        this.currentAirports = airports;
    }
    
}   